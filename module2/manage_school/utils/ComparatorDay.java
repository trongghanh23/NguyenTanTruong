package manage_school.utils;

import manage_school.modle.Persons;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class ComparatorDay implements Comparator<Persons> {

    @Override
    public int compare(Persons o1, Persons o2) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate Date1 = LocalDate.parse(o1.getBirthday().toString(), dateTimeFormatter);
        LocalDate Date2 = LocalDate.parse(o2.getBirthday().toString(), dateTimeFormatter);

        if (Date1.compareTo(Date2) > 0) {
            return 1;
        } else if (Date1.compareTo(Date2) < 0) {
            return -1;
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}

