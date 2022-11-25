package bai_tap.employee__management.utils;

import bai_tap.employee__management.model.Person;

import java.util.Comparator;

public class SortNameEmployee implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().compareTo(o2.getName()) > 0) {
            return -1;
        } else if (o1.getName().compareTo(o2.getName()) < 0) {
            return 1;
        } else {
            return 1;
        }
    }
}
