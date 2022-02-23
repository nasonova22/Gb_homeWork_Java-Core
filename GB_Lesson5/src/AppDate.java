import java.io.*;
import java.util.Arrays;

public class AppDate {
    private String[] header;
    private int[][] date;

    public AppDate(String[] header, int[][] date) {
        this.header = header;
        this.date = date;
    }
    //запись в файл
    public void saveAppDate() {
            String textWriter = "";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data.cvs"));
            //запись заголовка в файл
            for (int i=0;i<this.header.length;i++){
                textWriter=textWriter+this.header[i]+";";
            }
            bw.write(textWriter + "\n");

            // запись строк в файл
            textWriter = "";
            for (int i=0; i< date.length; i++) {
                for (int j=0; j < date[i].length; j++) {
                    textWriter = textWriter + Integer.toString(date[i][j]) + ";";
                }
                bw.write(textWriter + "\n");
                textWriter="";
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //чтение из файла
    public void readAppDate() {

        String textReader;
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.cvs"));
            //   прочитать заголовок и поместить в header
            textReader = br.readLine();
            this.header = textReader.split(";");
            count = this.header.length;
            // прочитать остальные строки файла  и поместить в date
            while ((textReader = br.readLine()) != null) {
                int i=0;
                for (int j=0; j<count;j++) {
                   if (textReader.indexOf(";") != -1) {
                       this.date[i][j]=Integer.valueOf(textReader.substring(0,textReader.indexOf(";")));
                           textReader=textReader.substring(textReader.indexOf(";")+1);
                   }else {
                       j=count;
                       i++;
                   }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "AppDate{" +
                "header=" + Arrays.toString(header) +
                ", date=" + Arrays.deepToString(date) +
                '}';
    }
}