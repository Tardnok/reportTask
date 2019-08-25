package entites;

public class ParametersInfo {
    private final int pageWidth = 32;
    private final int pageheight = 12;
    private final int numberWidth = 8;
    private final int dateWidth = 7;
    private final int nameWidth = 7;

    public ParametersInfo() {
    }

    public int getPageWidth() {
        return pageWidth;
    }

    public int getPageheight() {
        return pageheight;
    }

    public int getNumberWidth() {
        return numberWidth;
    }

    public int getDateWidth() {
        return dateWidth;
    }

    public int getNameWidth() {
        return nameWidth;
    }

    @Override
    public String toString() {
        return "ParametersInfo{" +
                "pageWidth=" + pageWidth +
                ", pageheight=" + pageheight +
                ", numberWidth=" + numberWidth +
                ", dateWidth=" + dateWidth +
                ", nameWidth=" + nameWidth +
                '}';
    }
}
