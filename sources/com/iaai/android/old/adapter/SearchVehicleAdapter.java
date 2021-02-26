package com.iaai.android.old.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class SearchVehicleAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList();
    private final List<String> mFragmentTitleList = new ArrayList();

    public SearchVehicleAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment getItem(int i) {
        return this.mFragmentList.get(i);
    }

    public int getCount() {
        return this.mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String str) {
        this.mFragmentList.add(fragment);
        this.mFragmentTitleList.add(str);
    }

    public CharSequence getPageTitle(int i) {
        return this.mFragmentTitleList.get(i);
    }
}
