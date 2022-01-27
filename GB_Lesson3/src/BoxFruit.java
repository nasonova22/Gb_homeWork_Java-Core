import java.util.ArrayList;
import java.util.Iterator;

public class BoxFruit <T extends Fruit> {
    private ArrayList<T> arrFruit;

    int counter=0;
    float weightBox=0f;

    public BoxFruit( ArrayList <T> arrFruit) {
        this.arrFruit = arrFruit;
    }


    public ArrayList<T> getArrFruit() {
        return arrFruit;
    }

    // добавление фрукта
    public void addArrFruit (T obj){
        if (counter<10) {
            arrFruit.add(obj);
            counter++;
        }
        else {
            System.out.println ("Box is full");
        }
    }
    // удаление фрукта
    public void delArrFruit (T obj){
        if (counter > 1) {
            arrFruit.remove(obj);
            counter--;
        }
        else {
            System.out.println ("Box is empty");
        }
    }
    //подсчет веса коробки
    public double getWeight() {
        weightBox=0;
        if (arrFruit.size() != 0) {
            for (int i = 0; i < arrFruit.size(); i++) {
                weightBox = weightBox + arrFruit.get(i).getWeight();
            }
        } else {
            System.out.println("Коробка пуста");
        }
        return weightBox;
    }
    //сравнить коробки
    public boolean compare(BoxFruit<?> another) {
        return (this.getWeight()-another.getWeight()) ==0;
    }

    //пересыпать коробки
    public void moveBox(BoxFruit<T> box) {
        Iterator<T> tIterator = arrFruit.iterator();

        while (tIterator.hasNext()){
            T nextFruit=tIterator.next();
            box.getArrFruit().add(nextFruit);
            tIterator.remove();
        }
    }

}

