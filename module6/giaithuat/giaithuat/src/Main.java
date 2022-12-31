public class Main {
    interface Readable {
        void readBook();

        void setBookMark();
    }

    abstract class Book implements Readable { // line 1

        public void readBook() {}z

//        //line n2
//      public abstract void setBookMark() ;
    }

    class EBook extends Book { //line 3
        public void readBook() {
        }

        @Override
        public void setBookMark() {

        }

        //line 4

    }
}