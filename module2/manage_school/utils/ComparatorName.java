package manage_school.utils;

import manage_school.modle.Persons;

import java.util.Comparator;

public class ComparatorName implements Comparator<Persons> {
    @Override
    public int compare(Persons o1, Persons o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
