import entites.ParametersInfo;
import entites.StaffMemberInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    private static String filePath = "E:\\Work\\reportTask\\src\\data\\source-data.txt";
    private static String fileReport = "E:\\Work\\reportTask\\src\\data\\report.txt";

    public static void main(String[] args) {
        List<StaffMemberInfo> staff = csvParser(filePath);
        List<String> infoToPrint = printToFile(staff, new ParametersInfo());
        makeReport(infoToPrint);
    }

    public static void makeReport(List<String> staffMembers) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileReport);
            for (String staff : staffMembers) {
                fileWriter.write(staff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        String header = "| Номер  | Дата  | ФИО   |";
        String separatingline = "--------------------------";
        String separatingTilde = "~";
        List<String> info = new ArrayList<>();
        info.add(header);
        for (StaffMemberInfo staff : staffMembers) {
            int countLine = 1;
            if (staff.getDate().length() > parametersInfo.getDateWidth()) {
                countLine = countLines(staff.getDate().length(), parametersInfo.getDateWidth());
            }
            for (int i = 0; i < countLine; i += 7) {
                info.add("| " + staff.getNumber() + "  | " + staff.getDate().substring(i) + " | " + staff.getFullName() + " |\n");
            }
            info.add(separatingline);
        }
        info.add(separatingTilde);
        return info;
    }

    public static int countLines(int staffLenght, int parameterLenght) {
        int countLine = 2;
        int length = staffLenght - parameterLenght;
        while (length > parameterLenght) {
            length = length - parameterLenght;
            countLine++;
        }
        return countLine;
    }
}
