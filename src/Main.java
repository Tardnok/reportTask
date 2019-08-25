import entites.ParametersInfo;
import entites.StaffMemberInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    private static String filePath = "E:\\Work\\reportTask\\src\\data\\source-data.txt";
    public static void main(String[] args) {
        List<StaffMemberInfo> staff = csvParser(filePath);
        ParametersInfo info = new ParametersInfo(32, 12, 8, 7, 7);
    }

    public void makeReport(List<StaffMemberInfo> staffMembers, ParametersInfo parametersInfo) {
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
        for (StaffMemberInfo s : staff) {
            System.out.println(s.toString());
        }
        return staff;
    }
}
