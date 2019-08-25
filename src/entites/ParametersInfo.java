package entites;

public class ParametersInfo {
    private int pageWidth;
    private int pageheight;
    private int numberWidth;
    private int dateWidth;
    private int nameWidth;

    public ParametersInfo(int pageWidth, int pageheight, int numberWidth, int dateWidth, int nameWidth) {
        this.pageWidth = pageWidth;
        this.pageheight = pageheight;
        this.numberWidth = numberWidth;
        this.dateWidth = dateWidth;
        this.nameWidth = nameWidth;
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
