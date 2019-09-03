public class StaffMemberInfo {
    private String number;
    private String date;
    private String fullName;

    public StaffMemberInfo(String number, String date, String fullName) {
        this.number = number;
        this.date = date;
        this.fullName = fullName;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "StaffMemberInfo{" +
                "number='" + number + '\'' +
                ", date='" + date + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
