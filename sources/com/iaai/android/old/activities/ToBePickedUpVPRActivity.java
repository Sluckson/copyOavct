package com.iaai.android.old.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iaai.android.C2723R;
import com.iaai.android.old.adapter.VPRExpandableListAdapter;
import com.iaai.android.old.managers.ToBePickedUpManager;
import com.iaai.android.old.models.ToBePickedUpBranchList;
import com.iaai.android.old.models.ToBePickedUpVehicles;
import com.iaai.android.old.models.VPRRequestModel;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.EVPPDFUtil;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p052cz.msebera.android.httpclient.Header;
import roboguice.application.RoboApplication;

public class ToBePickedUpVPRActivity extends AppCompatActivity {
    ImageButton btn_edit;
    ImageButton closeReviewPullout;
    WebView evp_webview;
    boolean isComeFromMyPullout;
    ExpandableListView listView;
    String note;
    int pin;
    Dialog progress;
    ArrayList<Integer> salvage_id_array;
    ArrayList<ToBePickedUpBranchList> selectedItems = null;
    boolean stockmodify;
    String title;
    ToBePickedUpManager toBePickedUpManager;
    ArrayList<ToBePickedUpBranchList> tobepickedupbranchArrayList = null;
    TextView toolbar_header;
    int vehiclePulloutRequestID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            WebView.enableSlowWholeDocumentDraw();
        }
        setContentView((int) C2723R.C2728layout.activity_tobe_picked_up_vpr_layout);
        this.toBePickedUpManager = (ToBePickedUpManager) ((RoboApplication) getApplicationContext()).getInjector().getInstance(ToBePickedUpManager.class);
        ((RelativeLayout) findViewById(C2723R.C2726id.layout_share_pullout)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePickedUpVPRActivity.this.checkWriteStoragePermission();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(C2723R.C2726id.toolbar);
        setSupportActionBar(toolbar);
        this.closeReviewPullout = (ImageButton) toolbar.findViewById(C2723R.C2726id.img_back);
        this.toolbar_header = (TextView) toolbar.findViewById(C2723R.C2726id.toolbar_header);
        this.btn_edit = (ImageButton) toolbar.findViewById(C2723R.C2726id.btn_edit);
        this.btn_edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePickedUpVPRActivity.this.editPullout();
            }
        });
        this.closeReviewPullout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePickedUpVPRActivity.this.closeConfirmPullout();
            }
        });
        this.listView = (ExpandableListView) findViewById(C2723R.C2726id.created_pullout_list);
        this.evp_webview = (WebView) findViewById(C2723R.C2726id.evp_webview);
        Intent intent = getIntent();
        this.vehiclePulloutRequestID = intent.getIntExtra("vehiclePulloutRequestID", -1);
        this.pin = intent.getIntExtra(Constants.EXTRA_PIN, 0);
        this.isComeFromMyPullout = intent.getBooleanExtra("mypullout", false);
        if (!this.isComeFromMyPullout) {
            this.toolbar_header.setText(C2723R.string.title_share_with_transporter);
            this.salvage_id_array = intent.getIntegerArrayListExtra("salvage_id_array");
            this.title = intent.getStringExtra("title");
            this.note = intent.getStringExtra("note");
            this.stockmodify = intent.getBooleanExtra("stockModified", false);
            getConfirmBranchPullout();
            return;
        }
        this.toolbar_header.setText(C2723R.string.title_pullout_confirm);
        getPulloutDetailBasedOnPulloutRequestID();
    }

    /* access modifiers changed from: private */
    public void checkWriteStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3);
        } else {
            createPdfAndShare();
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i != 3) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            AppUtils.showEnablePermissionMessage(true, this, (Fragment) null, "android.permission.WRITE_EXTERNAL_STORAGE", 3);
        } else {
            createPdfAndShare();
        }
    }

    private void getConfirmBranchPullout() {
        this.progress = MDActivityHelper.showProgressDialog(this, getString(C2723R.string.msg_Loading));
        VPRRequestModel vPRRequestModel = new VPRRequestModel();
        vPRRequestModel.pullout_list = this.salvage_id_array;
        vPRRequestModel.notes = this.note;
        vPRRequestModel.title = this.title;
        if (this.vehiclePulloutRequestID != -1) {
            vPRRequestModel.vehiclePulloutRequestID = "" + this.vehiclePulloutRequestID;
            vPRRequestModel.stocksModified = this.stockmodify;
        } else {
            vPRRequestModel.vehiclePulloutRequestID = null;
            vPRRequestModel.stocksModified = false;
        }
        vPRRequestModel.pin = "" + this.pin;
        this.toBePickedUpManager.loadBrachPulloutList(this, new Gson().toJson((Object) vPRRequestModel), new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                Gson gson = new Gson();
                String str = new String(bArr);
                Type type = new TypeToken<List<ToBePickedUpBranchList>>() {
                }.getType();
                ToBePickedUpVPRActivity.this.tobepickedupbranchArrayList = (ArrayList) gson.fromJson(str, type);
                if (ToBePickedUpVPRActivity.this.tobepickedupbranchArrayList == null || ToBePickedUpVPRActivity.this.tobepickedupbranchArrayList.size() <= 0) {
                    ToBePickedUpVPRActivity.this.progress.dismiss();
                    return;
                }
                ToBePickedUpVPRActivity toBePickedUpVPRActivity = ToBePickedUpVPRActivity.this;
                toBePickedUpVPRActivity.createHTMLFile(toBePickedUpVPRActivity.tobepickedupbranchArrayList, ToBePickedUpVPRActivity.this);
                ToBePickedUpVPRActivity.this.listView.setAdapter(new VPRExpandableListAdapter(ToBePickedUpVPRActivity.this.getApplicationContext(), ToBePickedUpVPRActivity.this.tobepickedupbranchArrayList));
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                ToBePickedUpVPRActivity.this.progress.dismiss();
            }
        });
    }

    private void getPulloutDetailBasedOnPulloutRequestID() {
        this.progress = MDActivityHelper.showProgressDialog(this, getString(C2723R.string.msg_Loading));
        this.toBePickedUpManager.loadPulloutDetailBasedOnPulloutID(this.vehiclePulloutRequestID, new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                Gson gson = new Gson();
                String str = new String(bArr);
                Type type = new TypeToken<List<ToBePickedUpBranchList>>() {
                }.getType();
                ToBePickedUpVPRActivity.this.tobepickedupbranchArrayList = (ArrayList) gson.fromJson(str, type);
                if (ToBePickedUpVPRActivity.this.tobepickedupbranchArrayList == null || ToBePickedUpVPRActivity.this.tobepickedupbranchArrayList.size() <= 0) {
                    ToBePickedUpVPRActivity.this.progress.dismiss();
                    return;
                }
                ToBePickedUpVPRActivity toBePickedUpVPRActivity = ToBePickedUpVPRActivity.this;
                toBePickedUpVPRActivity.createHTMLFile(toBePickedUpVPRActivity.tobepickedupbranchArrayList, ToBePickedUpVPRActivity.this);
                ToBePickedUpVPRActivity.this.listView.setAdapter(new VPRExpandableListAdapter(ToBePickedUpVPRActivity.this.getApplicationContext(), ToBePickedUpVPRActivity.this.tobepickedupbranchArrayList));
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                ToBePickedUpVPRActivity.this.progress.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    public void editPullout() {
        ArrayList<ToBePickedUpBranchList> arrayList = this.tobepickedupbranchArrayList;
        if (arrayList != null && arrayList.size() > 0) {
            Intent intent = new Intent(this, ToBePickedUpReviewPulloutActivity.class);
            intent.putParcelableArrayListExtra("vehicle_array", getReviewVehicleList());
            intent.putExtra("title", this.tobepickedupbranchArrayList.get(0).title);
            intent.putExtra("note", this.tobepickedupbranchArrayList.get(0).notes);
            intent.putExtra("vehiclePulloutRequestID", this.tobepickedupbranchArrayList.get(0).pullOutRequestID);
            intent.putExtra(Constants.EXTRA_PIN, this.tobepickedupbranchArrayList.get(0).pin);
            startActivityForResult(intent, 13);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 13 && i2 == -1) {
            setResult(-1, (Intent) null);
            finish();
        }
    }

    private ArrayList<ToBePickedUpVehicles> getReviewVehicleList() {
        ArrayList<ToBePickedUpVehicles> arrayList = new ArrayList<>();
        Iterator<ToBePickedUpBranchList> it = this.tobepickedupbranchArrayList.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().vehicleArrayList);
        }
        return arrayList;
    }

    private class PdfWebViewClient extends WebViewClient {
        private PdfWebViewClient() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ToBePickedUpVPRActivity.this.evp_webview.setVisibility(8);
            ToBePickedUpVPRActivity.this.progress.dismiss();
        }
    }

    private void createPdf() {
        Picture capturePicture = this.evp_webview.capturePicture();
        if (capturePicture.getHeight() != 0 && capturePicture.getWidth() != 0) {
            Bitmap createBitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Bitmap.Config.ARGB_8888);
            capturePicture.draw(new Canvas(createBitmap));
            Document document = new Document(new Rectangle((float) capturePicture.getWidth(), (float) capturePicture.getHeight()));
            try {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/evp");
                if (!file.exists()) {
                    file.mkdirs();
                }
                PdfWriter.getInstance(document, new FileOutputStream(new File(file, "ToBePickedUp.pdf")));
                document.open();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                Image instance = Image.getInstance(byteArrayOutputStream.toByteArray());
                instance.setAlignment(1);
                document.add(instance);
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            } catch (Throwable th) {
                document.close();
                createBitmap.recycle();
                throw th;
            }
            document.close();
            createBitmap.recycle();
        }
    }

    private void createPdfAndShare() {
        createPdf();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", getString(C2723R.string.vpr_vehicle_pullout));
        intent.putExtra("android.intent.extra.TEXT", getString(C2723R.string.vpr_view_pullout));
        intent.setType("plain/text");
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/evp", "ToBePickedUp.pdf");
        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this, getPackageName() + ".provider", file));
        startActivity(Intent.createChooser(intent, getString(C2723R.string.vpr_send_email)));
    }

    public void closeConfirmPullout() {
        if (!this.isComeFromMyPullout) {
            sendBroadcast(new Intent().setAction(Constants.INTENT_ACTION_REFRESH_TOBE_PICKEDUP_LIST));
        }
        finish();
    }

    public void createHTMLFile(ArrayList<ToBePickedUpBranchList> arrayList, Context context) {
        String str;
        ArrayList<ToBePickedUpBranchList> arrayList2 = arrayList;
        Context context2 = context;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (arrayList2.get(0).titileHandlingInstructions == null || arrayList2.get(0).titileHandlingInstructions.equals("null") || arrayList2.get(0).titileHandlingInstructions.equals("")) {
            str = "";
        } else {
            str = arrayList2.get(0).titileHandlingInstructions;
        }
        sb.append(EVPPDFUtil.replaceFromHeaderFile(EVPPDFUtil.readFromFile("evp/header.txt", context2), arrayList2.get(0).title, arrayList2.get(0).notes, str));
        Iterator<ToBePickedUpBranchList> it = arrayList.iterator();
        while (it.hasNext()) {
            ToBePickedUpBranchList next = it.next();
            sb.append(EVPPDFUtil.replaceFromBranchFile(EVPPDFUtil.readFromFile("evp/branch.txt", context2), next.branch_name, next.vehicleArrayList.get(i).branchStreet, next.vehicleArrayList.get(i).branchCity + ", " + next.vehicleArrayList.get(i).branchState + ", " + next.vehicleArrayList.get(i).branchZip, "" + next.pin, next.notes, next.vehicleArrayList.size(), arrayList2.get(i).buyerName, arrayList2.get(i).title));
            StringBuilder sb2 = new StringBuilder();
            Iterator<ToBePickedUpVehicles> it2 = next.vehicleArrayList.iterator();
            while (it2.hasNext()) {
                sb2.append(EVPPDFUtil.replaceFromVehicleFile(EVPPDFUtil.readFromFile("evp/vehicles.txt", context2), it2.next()));
            }
            int indexOf = sb.indexOf("~vehicleTable~");
            sb.replace(indexOf, indexOf + 14, sb2.toString());
            i = 0;
        }
        sb.append(EVPPDFUtil.readFromFile("evp/footer.txt", context2));
        File file = new File(context.getFilesDir().getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileWriter fileWriter = new FileWriter(new File(file, "ToBePickedUp.html"));
            fileWriter.write(sb.toString());
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.evp_webview.setWebViewClient(new PdfWebViewClient());
        this.evp_webview.getSettings().setLoadWithOverviewMode(true);
        this.evp_webview.loadUrl("file://" + getFilesDir().getPath() + "/ToBePickedUp.html");
    }
}
