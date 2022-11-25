package case_study_furama_resort.service;

import case_study_furama_resort.model.*;
import case_study_furama_resort.service.iextend.IBookingService;
import case_study_furama_resort.utils.read_and_write_file.BookingComparator;
import case_study_furama_resort.utils.read_and_write_file.Regex;

import java.util.*;

//public class BookingServiceImpl implements IBookingService {
//    static Scanner sc = new Scanner(System.in);
//
//    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
//
//    static List<Customer> customerList = new ArrayList<>();
//    static Map<Facility, Integer> facilities = new LinkedHashMap<>();
//
//    private static final String REGEX_DATE = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
//    private static final String PATH_BOOK = "src/casestudy/data/booking.csv";
//
//    static {
//        facilities.put(new Villa("SVVL-1996", "Villa 1", 500.0, 500, 10, "Day", "Vip", 100.0, 2), 1);
//        facilities.put(new Villa("SVVL-1997", "Villa 2", 2000.0, 1000, 30, "Day", "Vip", 400.0, 5), 2);
//        facilities.put(new House("SVHO-1996", "House 1", 500.0, 1000, 30, "Day", "Vip", 4), 2);
//        facilities.put(new House("SVHO-1997", "House 2", 2000.0, 1000, 30, "Day", "Vip", 2), 3);
//        facilities.put(new Room("SVRO-1996", "Room 1", 500.0, 1000, 30, "Day", "Breakfast"), 3);
//        facilities.put(new Room("SVRO-1997", "Room 2", 2000.0, 1000, 30, "Day", "BBQ"), 4);
//    }
//
//    public static Set<Booking> sendBooking() {
//        return bookingSet;
//    }

//    @Override
//    public void addBooking() {
//
//        int id = 1;
//        if (!bookingSet.isEmpty()) {
//            id = bookingSet.size();
//        }
//        System.out.println("Enter the Day Check in: ");
//        String starDay = Regex.regex(sc.nextLine(), REGEX_DATE, "Error: dd/MM/yyyy");
//        System.out.println("Enter the Day Check out: ");
//        String endDay = Regex.regex(sc.nextLine(), REGEX_DATE, "Error: dd/MM/yyyy");
//        String customer = chooseCustomer();
//        String facility = chooseFacility();
//        Booking booking = new Booking(id, starDay, endDay, customer, facility);
//        bookingSet.add(booking);
//
//    }

//    @Override
//    public void displayBooking() {
//
//        for (Booking booking : bookingSet) {
//            System.out.println(booking.toString());
//        }
//    }

//    public static String chooseCustomer() {
//
//        System.out.println("*List Customer: ");
//        for (Customer customer : customerList) {
//            System.out.println(" - ID : " + customer.getCustomerId() + " , " + customer.getName() + ".");
//        }
//        System.out.println("Enter the ID Customer: ");
//        boolean check = true;
//        int id = Integer.parseInt(sc.nextLine());
//        while (check) {
//            for (Customer customer : customerList) {
//                if (id == customer.getCustomerId()) {
//                    return customer.getCustomerId();
//                }
//            }
//            if (check) {
//                System.out.println("You Re- choice: ");
//                id = Integer.parseInt(sc.nextLine());
//            }
//            z
//        }
//
//    }




//
//    public static String chooseFacility() {
//        System.out.println("*List Service: ");
//        for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
//            System.out.println("-ID Facility Service : " + entry.getKey().getNameId());
//            System.out.println(" Số lần đã sử dụng  : " + entry.getValue());
//        }
//        boolean check = true;
//        System.out.println("Enter the ID Service: ");
//        String id =sc.nextLine();
//        while (check) {
//            for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
//                if (entry.getKey().getNameId().equals(id)) {
//                    FacilityServiceImpl.add(entry.getKey());
//                    return entry.getKey().getNameId()+"";
//                }
//            }
//            if (check) {
//                System.out.println("You Re- choice: ");
//                id = sc.nextLine();
//            }
//        }return null;
//
//    }
//}
