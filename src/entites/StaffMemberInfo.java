package entites;

public class StaffMemberInfo {
    private int number;
    private String date;
    private String fullName;

    public StaffMemberInfo(int number, String date, String fullName) {
        this.number = number;
        this.date = date;
        this.fullName = fullName;
    }

    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getFullName() {
        return fullName;
    }
}
