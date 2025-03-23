/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package realestate;

import java.util.ArrayList;

/**
 *
 * @author xcsiz
 */
public class RealEstate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Ad> ads = Ad.fileBe("realestates.csv");
        
        double sum = 0;
        double db = 0;
        for (int i = 0; i < ads.size(); i++) {
            if(ads.get(i).getFloors() == 0){
                sum += ads.get(i).getArea();    
                db++;
            }
        }
        
        System.out.println("1. Földszinti ingatlanok átlagos alapterülete: " +
                String.format("%.2f", sum / db) + " m2");
        
            

        double legkisebb = ads.get(0).DistanceTo("47.4164220114023,19.066342425796986");
        int index = 0;
        for(int i = 0; i < ads.size(); i++) {
            if(legkisebb > ads.get(i).DistanceTo("47.4164220114023,19.066342425796986")){
                legkisebb = ads.get(i).DistanceTo("47.4164220114023,19.066342425796986");
                index = i;
            }
        }
        System.out.println("2. Mesevár óvodához légvonalban legközelebbi tehermentes ingatlan adatai:");
        System.out.println("\tEladó neve\t: " + ads.get(index).getSeller().getName());
        System.out.println("\tEladó telefonja\t: " + ads.get(index).getSeller().getPhone());
        System.out.println("\tAlapterület\t: " + ads.get(index).getArea());
        System.out.println("\tSzobák száma\t: " + ads.get(index).getRooms());
    }
}
