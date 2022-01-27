import java.util.ArrayList;

public class BoxFruitDemoApp {
    public static void main(String[] args) {
    ArrayList<Apple> apples = new ArrayList<>();
    ArrayList<Orange> oranges =new ArrayList<>();
    ArrayList<Orange> oranges1 =new ArrayList<>() ;

    BoxFruit<Apple> boxApple= new BoxFruit<>(apples);
    BoxFruit<Orange> boxOrange= new BoxFruit<>(oranges);
    BoxFruit<Orange> boxOrange1 = new BoxFruit<>(oranges1);


        boxApple.addArrFruit(new Apple());
        boxApple.addArrFruit(new Apple());
        boxApple.addArrFruit(new Apple());
        boxApple.addArrFruit(new Apple());
        boxApple.addArrFruit(new Apple());
        boxOrange.addArrFruit(new Orange());
        boxOrange.addArrFruit(new Orange());
        boxOrange.addArrFruit(new Orange());
        boxOrange.addArrFruit(new Orange());

        System.out.println (boxApple.getWeight());
        System.out.println( boxOrange.getWeight());



        if (boxApple.compare(boxOrange)) {
            System.out.println("Вес одинаковый");
        } else {
            System.out.println("Вес разный");
        }

        boxOrange.moveBox(boxOrange1);
        System.out.println ("Вес после перекладывания новой "+boxOrange1.getWeight());
        System.out.println ("Вес после перекладывания старой "+boxOrange.getWeight());


        //удаляем
        boxApple.delArrFruit(boxApple.getArrFruit().get(0));
        boxApple.delArrFruit(boxApple.getArrFruit().get(0));
        boxApple.delArrFruit(boxApple.getArrFruit().get(0));
        boxApple.delArrFruit(boxApple.getArrFruit().get(0));
        boxApple.delArrFruit(boxApple.getArrFruit().get(0));


        }

    }
