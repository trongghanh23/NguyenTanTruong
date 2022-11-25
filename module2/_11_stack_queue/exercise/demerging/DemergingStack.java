package _11_stack_queue.exercise.demerging;

import java.util.*;

public class DemergingStack {
    public static void main(String[] args) {
        Queue<Person> female = new LinkedList<>();
        Queue<Person> male = new LinkedList<>();

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("nguyên văn hàng", true, "12/1/1998"));
        personList.add(new Person("nguyên văn tuấn", true, "13/2/1999"));
        personList.add(new Person("nguyên thi hàng", false, "14/3/2000"));
        personList.add(new Person("nguyên thị tiếm", false, "15/4/2001"));
        personList.add(new Person("nguyên văn hàng", true, "16/5/2002"));
        personList.add(new Person("nguyên văn hàng", true, "17/6/2003"));
        System.out.println("danh sách trong mảng là:");
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getGender()) {
                female.add(personList.get(i));
            } else {
                male.add(personList.get(i));
            }
        }
        System.out.println("danh sách có giới tính nam là:");

        while (!female.isEmpty()) {
            System.out.println(female.poll());
        }
        System.out.println("sanh sách có giới tính nữ là : ");

        while (!male.isEmpty()) {
            System.out.println(male.poll());
        }


    }
}



