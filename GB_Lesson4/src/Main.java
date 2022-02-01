import java.util.ArrayList;
import java.util.HashMap;

public class Main<add> {
    public static void main(String[] args) {
        Phonebook book1 = new Phonebook();

        //первое задание
        HashMap<String, Integer> repeatwords = new HashMap<>();
        ArrayList<String> arrtmp = new ArrayList<>();
        arrtmp.add("день");
        arrtmp.add("ночь");
        arrtmp.add("привет");
        arrtmp.add("солнце");
        arrtmp.add("облака");
        arrtmp.add("день");
        arrtmp.add("прекрасно");
        arrtmp.add("тестирование");
        arrtmp.add("обработка");
        arrtmp.add("день");
        arrtmp.add("тестирование");
        arrtmp.add("обработка");
        arrtmp.add("облака");
        arrtmp.add("день");
        arrtmp.add("привет");

        for (String str : arrtmp) {
            if (repeatwords.get(str) == null) {
                repeatwords.put(str, 1);
            } else {
                repeatwords.put(str, repeatwords.get(str) + 1);
            }
        }
        System.out.println(repeatwords);

        System.out.println("Задание №2");
        //Задание №2
        book1.add("Иванов","99999 ");
        book1.add("Петров","11111 ");
        book1.add("Иванов","222222");
        book1.add("Иванов","555555");
        book1.add("Сидоров ","00000 ");

        System.out.println(book1.getAbonent("Иванов"));
    }

}

