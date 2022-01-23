import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"1", "2", "3", "4"},
                {"5", "6", "yy", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "12", "1"}};

        try {
            System.out.println( arraySum(arr));
        } catch (MyArrySizeException e){
            e.printStackTrace();
            System.out.println("Массив не 4x4");
        }
    }

    public static int arraySum(String[][] my_arr) throws MyArrySizeException  {
        boolean wrongSize = true;
        int arrSum=0, i=0, j=0;

        // определяем размер массива
        if (my_arr.length == 4) {
            for ( i = 0; i < my_arr.length; i++) {
                if (my_arr[i].length != 4) {
                    wrongSize = false;
                    break;
                }
            }
            if (!wrongSize) throw new MyArrySizeException();
        }

        //преобразовывем элементы массива в int и суммируем
        try {
        for ( i = 0; i < 4; i++) {
            for ( j = 0; j < 4; j++) {
                arrSum=arrSum+parseInt( my_arr[i][j]);
            }
        }
        } catch (NumberFormatException e) {
            throw new MyArryDataException ("Элемет массива m_arr["+  i +"][" + j + "] не число");
        }
        return arrSum;
    }
 }


