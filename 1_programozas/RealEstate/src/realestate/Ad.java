/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realestate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author xcsiz
 */
public class Ad {
    
    private int area;
    private Category category;
    //private LocalDateTime createAt;
    private String description;
    private int floors;
    private boolean freeofcharge;
    private int id;
    private String imageurl;
    private String latlong;
    private int rooms;
    private Seller seller;

    public Ad(String sor) {
        String[] adatok = sor.split(";");
        
        this.id = Integer.parseInt(adatok[0]);
        this.rooms = Integer.parseInt(adatok[1]);
        this.latlong = adatok[2];
        this.floors = Integer.parseInt(adatok[3]);
        this.area = Integer.parseInt(adatok[4]);
        this.description = adatok[5];
        this.freeofcharge = Boolean.parseBoolean(adatok[6]);
        this.imageurl = adatok[7];
        
        //this.createAt = LocalDateTime.parse(adatok[8]);
        this.seller = new Seller(Integer.parseInt(adatok[9]), adatok[10], adatok[11]);
        this.category = new Category(Integer.parseInt(adatok[12]), adatok[13]);
        
    }
    
    public static ArrayList<Ad> fileBe(String filename){
        
        ArrayList<Ad> ads = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String sor;
            br.readLine();
            
            while((sor = br.readLine()) != null){
                ads.add(new Ad(sor));
            }

            
        } catch (IOException e) {
            System.out.println("A fájl nem található.");
        }
        
        return ads;
    }
    
    public Double DistanceTo(String coordinate){
        
        String[] coor1 = coordinate.split(",");
        String[] coor2 = this.latlong.split(",");
        
        double latitude = Double.parseDouble(coor1[0]);
        double longitude = Double.parseDouble(coor1[1]);
        
        double mylatitude = Double.parseDouble(coor2[0]);
        double mylongitude = Double.parseDouble(coor2[1]);
        
        double a = Math.abs(mylatitude - latitude);
        double b = Math.abs(mylongitude - longitude);
        
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /*public LocalDateTime getCreateAt() {
        return createAt;
    }*/

    /*public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }*/

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public boolean isFreeofcharge() {
        return freeofcharge;
    }

    public void setFreeofcharge(boolean freeofcharge) {
        this.freeofcharge = freeofcharge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getLatlong() {
        return latlong;
    }

    public void setLatlong(String latlong) {
        this.latlong = latlong;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    
    
    
    
    
    
    
}
