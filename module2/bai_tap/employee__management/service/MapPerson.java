package bai_tap.employee__management.service;

import bai_tap.employee__management.model.AdministrativePersonnel;
import bai_tap.employee__management.model.DailyWorker;
import bai_tap.employee__management.model.Person;
import bai_tap.employee__management.model.ProductionStaff;

import java.util.HashMap;

public class MapPerson {
    public static HashMap<Integer, Person> personHashMap = new HashMap<>();

    static {
        personHashMap.put(1, new AdministrativePersonnel("tran van dung", 2001, "đà nẵng", 2000, 1.5));
        personHashMap.put(2, new DailyWorker("tran van nho", 1999, "quang nam", 26));
        personHashMap.put(3, new ProductionStaff("tran van vinh", 1994, "đà nẵng", 1000));
    }

    public static void main(String[] args) {
        for (Integer item : personHashMap.keySet()) {
            if (item != null) {
                System.out.println(item + " " + personHashMap.get(item));
            } else {
                if (personHashMap.containsKey(item)) {
                    //đã tồn tại key
                } else {
                    //chưa tồn tại key
                }

            }
        }
    }
}
