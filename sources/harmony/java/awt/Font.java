package harmony.java.awt;

public class Font {
    public static final int BOLD = 1;
    public static final int ITALIC = 2;
    public static final int NORMAL = 0;
    private boolean bold;
    private boolean italic;
    private String name;
    private int size;

    public Font(String str, int i, int i2) {
        this.name = str;
        if ((i & 1) == 1) {
            this.bold = true;
        }
        if ((i & 2) == 2) {
            this.italic = true;
        }
        this.size = i2;
    }

    public String getFontName() {
        StringBuilder sb = new StringBuilder(String.valueOf(this.name));
        String str = "";
        sb.append(isBold() ? " Bold" : str);
        if (isItalic()) {
            str = " Italic";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean isBold() {
        return this.bold;
    }

    public boolean isItalic() {
        return this.italic;
    }

    public String getName() {
        return this.name;
    }
}
