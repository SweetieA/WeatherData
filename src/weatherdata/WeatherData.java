/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdata;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sweetiean
 */
public class WeatherData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        findSpreadMax();
    }
    
    public static void findSpreadMax(){
        Path file = new File("weather.dat").toPath();
        String[] records = null;
        String day, dayMax = " ";
        int MxT, MnT, spreadMax = 0, spread = 0;
        
        try {
            records = Files.readAllLines(file).toArray(new String[0]);
        } catch (IOException ex) {
            Logger.getLogger(WeatherData.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        for(int i = 2; i < records.length; i++){
            day = records[i].substring(2,4).trim();
            MxT = Integer.parseInt(records[i].substring(6,8).trim());
            MnT = Integer.parseInt(records[i].substring(12,14).trim());
            
            spread = MxT - MnT;
            
            if(spreadMax < spread){
                dayMax = day;
                spreadMax = spread;
            }
        }
        System.out.print(dayMax);
        System.out.println(" " + spreadMax);
    }
    
}
