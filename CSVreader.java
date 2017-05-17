
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author boss
 */
public class CSVreader {
    public static void main(String[] args) {

        String csvFile = "C:\\Users\\boss\\Documents\\NetBeansProjects\\lab_10_new\\GeoLiteCity-Location.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
                    br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
