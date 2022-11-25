package ManageComputer.utils;

import ManageComputer.modle.ManageEmployee;
import ManageComputer.modle.ProductionStaff;
import case_study_furama_resort.model.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCharacter {
    public static void writeFile(String pathFile, List<String> list) {
        File file = new File(pathFile);

        try (FileWriter fileWriter = new FileWriter(file, false);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String data : list) {
                bufferedWriter.write(data);
                bufferedWriter.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }

    }

    public static void writeManageEmployee(String pathFile, List<ManageEmployee> manage) {
        List<String> list = new ArrayList<>();
        for (ManageEmployee e : manage) {
            list.add(e.convertLine());

        }
        writeFile(pathFile, list);
    }

    public static void writeProductionStaffs(String pathFile, List<ProductionStaff> manage) {
        List<String> list = new ArrayList<>();
        for (ProductionStaff e : manage) {
            list.add(e.convertLine());

        }
        writeFile(pathFile, list);
    }
    public static List<String> readFile(String pathFile) {
        File file = new File(pathFile);
        List<String> list = new ArrayList<>();

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
//                String[] arr = line.split(",");
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static List<ManageEmployee> readProduction(String path) {
        List<String> list = readFile(path);
        List<ManageEmployee> manageEmployeeList = new ArrayList<>();
        String[] arr = null;
        for (String str : list) {
            arr = str.split(",");
            manageEmployeeList.add(new ManageEmployee(Integer.parseInt(arr[0]), arr[1], arr[2],LocalDate.parse(arr[3]) , arr[4],Double.parseDouble(arr[5]), Double.parseDouble(arr[6])));

        }
        return manageEmployeeList;
    }
    public static List<ProductionStaff> readStaffs(String path) {
        List<String> list = readFile(path);
        List<ProductionStaff> productionStaffs = new ArrayList<>();
        String[] arr = null;
        for (String str : list) {
            arr = str.split(",");
            productionStaffs.add(new ProductionStaff(Integer.parseInt(arr[0]), arr[1], arr[2], LocalDate.parse(arr[3]), arr[4],Integer.parseInt(arr[5]), Double.parseDouble(arr[6])));

        }
        return productionStaffs;
    }
}
