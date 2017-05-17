
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.lightcouch.CouchDbClient;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author boss
 */
public class App {
    public static void main( String args[] ){
        CouchDbClient dbClient = new CouchDbClient("lab10_new", true, "http", "127.0.0.1", 5984, "admin", "admin"); 
        Map<String, Object> map = new HashMap<>();
        
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
                                
                map.put("_id",country[0]);
                map.put("country",country[1]);
                map.put("region",country[2]);
                map.put("city",country[3]);
                map.put("postalCode",country[4]);
                map.put("latitude",country[5]);
                map.put("longitude",country[6]);
                if(country.length>7){
                    map.put("metroCode",country[7]);
                    if(country.length>8){
                    map.put("areaCode",country[8]);}
                }
                dbClient.save(map);
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
