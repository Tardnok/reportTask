import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    private static String filePath = "E:/Work/reportTask/src/main/resources/source-data.csv";
    private static String fileReport = "E:/Work/reportTask/src/main/resources/report.txt";
    private static final String HEADER = "| Номер  | Дата  | ФИО   |";
    private static final String SEPARATING_LINE = "--------------------------";
    private static final String SEPARATING_TILDE = "~";

    public static void main(String[] args) {
        List<StaffMemberInfo> staff = csvParser(filePath);
        List<String> infoToPrint = printToFile(staff, new ParametersInfo());
        makeReport(infoToPrint);
    }

    public static void makeReport(List<String> staffMembers) {
        PrintWriter fileWriter = null;
        try {
            fileWriter = new PrintWriter(fileReport);
            for (String staff : staffMembers) {
                fileWriter.println(staff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }
    }

    public static List<StaffMemberInfo> csvParser(String fileName) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        String[] country = null;
        List<StaffMemberInfo> staff = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                country = line.split(cvsSplitBy);
                List<String> arr = asList(country);
                staff.add(new StaffMemberInfo(arr.get(0), arr.get(1), arr.get(2)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        for (StaffMemberInfo s : staff) {
//            System.out.println(s.toString());
//        }
        return staff;
    }

    public static List<String> printToFile(List<StaffMemberInfo> staffMembers, ParametersInfo parametersInfo) {
        List<String> info = new ArrayList<>();
        info.add(HEADER);
        info.add(SEPARATING_LINE);
        for (StaffMemberInfo staff : staffMembers) {
            int countLine = 1;
            int countOfGap = 0;
            List<String> stringsForNumber = new ArrayList<>();
            List<String> stringsForDate = new ArrayList<>();
            List<String> stringsForName = new ArrayList<>();
            if (staff.getDate().length() > parametersInfo.getDateWidth()) {
                stringsForDate = returnMassive(staff.getDate(), parametersInfo.getDateWidth());
            } else {
                stringsForDate.add(0, staff.getDate());
            }
            if (staff.getFullName().length() > parametersInfo.getNameWidth()) {
                stringsForName = returnMassive(staff.getFullName(), parametersInfo.getNameWidth());
            } else {
                stringsForName.add(0, staff.getFullName());
            }
            if (staff.getNumber().length() > parametersInfo.getNumberWidth()) {
                stringsForNumber = returnMassive(staff.getNumber(), parametersInfo.getNumberWidth());
            } else {
                stringsForNumber.add(0, staff.getNumber());
            }
            if (stringsForDate.size() > stringsForName.size()) {
                countLine = stringsForDate.size();
                countOfGap = stringsForDate.size() - stringsForName.size();
                if (countOfGap != 0) {
                    for (int i = 0; i < countOfGap; i++) {
                        stringsForName.add(" ");
                    }
                    for (int i = 0; i < countLine; i++) {
                        stringsForNumber.add(" ");
                    }
                }
            } else {
                countLine = stringsForName.size();
                countOfGap = stringsForName.size() - stringsForDate.size();
                if (countOfGap != 0) {
                    for (int i = 0; i < countOfGap; i++) {
                        stringsForDate.add(" ");

                    }
                    for (int i = 0; i < countLine; i++) {
                        stringsForNumber.add(" ");
                    }
                }
            }
            System.out.println(staff.getFullName());
            for (int i = 0; i < countLine; i ++) {
                info.add("| " + stringsForNumber.get(i) + "  | "
                        + stringsForDate.get(i) + " | "
                        + stringsForName.get(i) + " |\n");
            }
            info.add(SEPARATING_LINE);
        }
        info.add(SEPARATING_TILDE);
        return info;
    }


    public static List<String> returnMassive(String field, int parameterLentgh) {
        List<String> arr = new ArrayList<>();
        int initialIndex = 0;
        int length = field.length();
        while (length > parameterLentgh) {
            length = length - parameterLentgh;
            arr.add(" " + field.substring(initialIndex, parameterLentgh + initialIndex) + " ");
            initialIndex =+ parameterLentgh;
        }
        if (length != 0) {
            String str = field.substring(initialIndex);
            String lastLine = " " + str + " ";
            int remainderLength = parameterLentgh - str.length();
            if (remainderLength != 0) {
                while (remainderLength > 0) {
                    str += " ";
                    remainderLength --;
                }
            }
            arr.add(lastLine);
        }
        return arr;
    }
}
