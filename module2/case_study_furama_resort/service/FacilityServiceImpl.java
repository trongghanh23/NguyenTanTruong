package case_study_furama_resort.service;

import case_study_furama_resort.model.House;
import case_study_furama_resort.model.Room;
import case_study_furama_resort.model.Villa;
import case_study_furama_resort.service.iextend.IFacilityService;
import case_study_furama_resort.utils.read_and_write_file.ReadAndWriteCharacter;
import case_study_furama_resort.utils.read_and_write_file.Regex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    private static Scanner sc = new Scanner(System.in);

    private static Map<Villa, Integer> villas = new LinkedHashMap<>();
    private static Map<House, Integer> houses = new LinkedHashMap<>();
    private static Map<Room, Integer> rooms = new LinkedHashMap<>();

    private static final String PATH_VILLA = "src/case_study_furama_resort/data/villa.csv";
    private static final String PATH_HOUSE = "src/case_study_furama_resort/data/house.csv";
    private static final String PATH_ROOM = "src/case_study_furama_resort/data/room.csv";


    @Override
    public void display() {

        villas = ReadAndWriteCharacter.readVilla(PATH_VILLA);
        System.out.println("*---List Facility---*");
        for (Map.Entry<Villa, Integer> item : villas.entrySet()) {
            System.out.println(item.getKey() + " Number of Used: " + item.getValue());
        }

        houses = ReadAndWriteCharacter.readHouse(PATH_HOUSE);
        for (Map.Entry<House, Integer> item : houses.entrySet()) {
            System.out.println(item.getKey() + " Number of Used: " + item.getValue());
        }

        rooms = ReadAndWriteCharacter.readRoom(PATH_ROOM);
        for (Map.Entry<Room, Integer> item : rooms.entrySet()) {
            System.out.println(item.getKey() + " Number of Used: " + item.getValue());
        }

    }

    @Override
    public void displayMaintain() {

    }

    @Override
    public void addNewVilla() {
        villas = ReadAndWriteCharacter.readVilla(PATH_VILLA);
        System.out.println("*---Enter the Villa---*");

        System.out.println("nhập id");
        String id = Regex.inputIdVilla();

        System.out.println("nhập tên:");
        String name = Regex.inputName();

        System.out.println("nhập diện tích:");
        Double area = Double.parseDouble(Regex.inputUseArea());

        System.out.println("nhập số người:");
        String person = Regex.inputPeopleMax();

        System.out.println("Nhập loại thuê: ");
        int type = Integer.parseInt(Regex.inputStandardVilla());
        System.out.println("nhập kiểu phòng");
        String room = Regex.inputName();

        System.out.println("nhập diện tích hồ bơi");
        Double pool = Double.parseDouble(Regex.inputAreaPool());

        System.out.println("nhập số tầng");
        int num = Integer.parseInt(Regex.inputFloor());

        System.out.println("nhập giá thue");
        Double acrea = Double.parseDouble(Regex.inputRentalPrice());

        Villa villa = new Villa(id, name, area, acrea, type, person, room, pool, num);
        villas.put(villa, 0);
        ReadAndWriteCharacter.writeVilla(PATH_VILLA, villas);
        System.out.println("Success added!");

    }

    @Override
    public void addNewHouse() {
        houses = ReadAndWriteCharacter.readHouse(PATH_HOUSE);
        System.out.println("*---Enter the House---*");

        System.out.println("nhập id");
        String id = Regex.inputIdHouse();

        System.out.println("nhập tên:");
        String name = Regex.inputName();

        System.out.println("nhập diện tích:");
        Double area = Double.parseDouble(Regex.inputUseArea());

        System.out.println("nhập số người:");
        String person = Regex.inputPeopleMax();

        System.out.println("Nhập loại thuê: ");
        String type = Regex.inputName();

        System.out.println("nhập diện tích hồ bơi");
        double pool = Double.parseDouble(Regex.inputAreaPool());

        System.out.println("nhập số tầng");
        int num = Integer.parseInt(Regex.inputFloor());

        System.out.println("nhập giá thue");
        int acrea = Integer.parseInt(Regex.inputRentalPrice());

        House house = new House(id, name, area, pool, acrea, person, type, num);
        houses.put(house, 0);
        ReadAndWriteCharacter.writeHouse(PATH_HOUSE, houses);

        System.out.println("Success added!");


    }

    @Override
    public void addNewRoom() {
        rooms = ReadAndWriteCharacter.readRoom(PATH_ROOM);
        System.out.println("*---Enter the House---*");

        System.out.println("nhập id");
        String id = Regex.inputIdRoom();

        System.out.println("nhập tên:");
        String name = Regex.inputName();

        System.out.println("nhập diện tích:");
        Double area = Double.parseDouble(Regex.inputUseArea());

        System.out.println("nhập số người:");
        int person = Integer.parseInt(Regex.inputPeopleMax());

        System.out.println("Nhập loại thuê: ");
        String type = Regex.inputName();

        System.out.println("nhập số tầng");
        String num = Regex.inputFloor();

        System.out.println("nhập giá thue");
        Double acrea = Double.parseDouble(Regex.inputRentalPrice());

        Room room = new Room(id, name, area, acrea, person, type, num);
        rooms.put(room, 0);

        ReadAndWriteCharacter.writeRoom(PATH_ROOM, rooms);

        System.out.println("Success added!");

    }


}
