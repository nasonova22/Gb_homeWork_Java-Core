import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private String name;
    private String phone;
    private HashMap<String, ArrayList<String>>  book = new HashMap<>();
    private ArrayList<String> phones =new ArrayList<>();

    public Phonebook() {
    }

    public void add(String name, String phone){
        if (book.get(name)==null) {             // нет абонента, добавить
        }
        else{                                  // абонент есть, добавить телефон
            phones=book.get(name);
        }
        phones.add(phone);
        book.put(name,new ArrayList<>(phones));
        phones.clear();
        System.out.println(book);
    }
    public ArrayList<String> getAbonent(String name){
        if (book.get(name)==null) {
            System.out.println("нет абонента");
            return (null);
        }
        else {
            System.out.print("Абонент "+name+" ");
            return book.get(name);
        }
    }
}
