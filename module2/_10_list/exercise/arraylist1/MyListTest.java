package _10_list.exercise.arraylist1;

public class MyListTest {
    static class Person {
        private String name;
        private int Age;

        Person(String name, int age) {
            this.name = name;
            Age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\n' +
                    ", Age=" + Age +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            return this.name.equals(((Person) obj).name)
                    && this.Age == ((Person) obj).Age;
        }
    }

    public static void main(String[] args) {
        MyList<Person> myList = new MyList<>(3);
        myList.ensureCapacity(4);
        myList.add(new Person("Nguyễn văn bảo ", 40));
        myList.add(new Person("Nguyễn tấn nhật ", 40));
        myList.add(new Person("Nguyễn bảo anh ", 40));
        myList.add(new Person("Nguyễn Văn khải ", 40), 1);
        MyList<Person> list2 = myList.clone();
        int index = list2.indexOf(new Person("Nguyễn Văn C ", 40));
        System.out.println("index = " + index);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(myList.get(i).toString());
        }
    }
}
