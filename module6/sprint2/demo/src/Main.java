public class Main {
    public static void main(String[] args) {

        StringBuilder character = new StringBuilder("cdab8932210");

        for (int i = 0; i < character.length(); i++) {
            for (int j = i + 1; j < character.length(); j++) {
                if (character.charAt(i) > character.charAt(j)) {
                    char temp1 = character.charAt(i);
                    char temp2 = character.charAt(j);
                    character.deleteCharAt(i).insert(i, temp2);
                    character.deleteCharAt(j).insert(j, temp1);
                }
            }
        }

        System.out.println(character);


    }
}