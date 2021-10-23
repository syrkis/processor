package parser;

import java.io.*;


public class CityCSVParser {

    public void readAndProcess(File file) {

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String[] h = br.readLine().split(",");
            String line;

            while ((line = br.readLine()) != null) {
                String[] s = line.split(",");
                for (int i = 0; i < 3; i++) {
                    System.out.print(h[i] +": " + s[i].replace("\"", "") + ", ");
                }
                System.out.println(h[3] + ": " + s[3]);
            }

        } catch (Exception e) {
            System.out.println("fuck");
        }
    }

    public static final void main(String[] args) {
        CityCSVParser reader = new CityCSVParser();

        File dataDirectory = new File("data/");
        File csvFile = new File(dataDirectory,"Cities.csv");

        reader.readAndProcess(csvFile);
    }
}