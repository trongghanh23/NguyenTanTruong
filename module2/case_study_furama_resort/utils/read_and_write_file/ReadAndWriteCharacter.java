package case_study_furama_resort.utils.read_and_write_file;

import case_study_furama_resort.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public static void writeEmployee(String pathFile, List<Employee> employees) {
        List<String> list = new ArrayList<>();
        for (Employee e : employees) {
            list.add(e.convertLine());

        }
        writeFile(pathFile, list);
    }

    public static void writeCustomer(String pathFile, List<Customer> customer) {
        List<String> list = new ArrayList<>();
        for (Customer c : customer) {
            list.add(c.convertLine());

        }
        writeFile(pathFile, list);
    }

    public static void writeVilla(String pathFile, Map<Villa, Integer> villas) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<Villa, Integer> item : villas.entrySet()) {
            list.add(item.getKey().convert());

        }
        writeFile(pathFile, list);
    }

    public static void writeHouse(String pathFile, Map<House, Integer> houses) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<House, Integer> item : houses.entrySet()) {
            list.add(item.getKey().convert());

        }
        writeFile(pathFile, list);
    }


    public static void writeRoom(String pathFile, Map<Room, Integer> room) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<Room, Integer> item : room.entrySet()) {
            list.add(item.getKey().convert());

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

    public static List<Employee> readEmployee(String path) {
        List<String> list = readFile(path);
        List<Employee> employeeList = new ArrayList<>();
        String[] arr = null;
        for (String str : list) {
            arr = str.split(",");
            employeeList.add(new Employee(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), arr[5], arr[6], arr[7], Double.parseDouble(arr[8])));

        }
        return employeeList;
    }

    public static List<Customer> readCustomer(String path) {
        List<String> list = readFile(path);
        List<Customer> customerList = new ArrayList<>();
        String[] arr = null;
        for (String str : list) {
            arr = str.split(",");
            customerList.add(new Customer(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), arr[5], arr[6], arr[7], arr[8]));

        }
        return customerList;
    }

    public static Map<Villa, Integer> readVilla(String path) {
        List<String> list = readFile(path);
        Map<Villa, Integer> villaList = new LinkedHashMap<>();
        String[] arr = null;
        for (String str : list) {
            arr = str.split(",");
            villaList.put(new Villa(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], Double.parseDouble(arr[7]), Integer.parseInt(arr[8])), 0);

        }
        return villaList;
    }

    public static Map<House, Integer> readHouse(String path) {
        List<String> list = readFile(path);
        Map<House, Integer> houseList = new LinkedHashMap<>();
        String[] arr = null;
        for (String str : list) {
            arr = str.split(",");
            houseList.put(new House(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], Integer.parseInt(arr[7])), 0);

        }
        return houseList;
    }


    public static Map<Room, Integer> readRoom(String path) {
        List<String> list = readFile(path);
        Map<Room, Integer> roomList = new LinkedHashMap<>();
        String[] arr = null;
        for (String str : list) {
            arr = str.split(",");
            roomList.put(new Room(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6]), 0);

        }
        return roomList;
    }
}

