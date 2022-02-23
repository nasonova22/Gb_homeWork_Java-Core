import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StreamDemoApp {

    public static void main(String[] args) {

         int [][] arrayDateSave = new int[][] {{100,101,102,103},{200,201,202,203},{300,301,302,303}};
         String [] arrHeader = {"Value 1","Value 2","Value 3","Value 4"};
         AppDate appDate =new AppDate(arrHeader,arrayDateSave);
         appDate.saveAppDate();
         appDate.readAppDate();
         System.out.println(appDate);

    }
}
