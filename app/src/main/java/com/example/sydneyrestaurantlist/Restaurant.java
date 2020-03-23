/*
 * Created by Khang Bui (z5209606) on 23/03/20 8:31 PM.
 * This is an academic project completed as part of the UNSW course INFS3617.
 * Copyright (c) 2020. All rights reserved.
 * Last modified 23/03/20 8:31 PM.
 */

package com.example.sydneyrestaurantlist;

import java.util.ArrayList;

//Restaurant model class
public class Restaurant {

    //Attributes
    private String name;
    private float rating;
    private ArrayList<String> cuisine;
    private String suburb;
    private String desc;
    private String address;
    private String phone;
    private String website;

    //Constructor class
    public Restaurant(String name, float rating, ArrayList<String> cuisine, String suburb,
                      String desc, String address, String phone, String website) {
        this.name = name;
        this.rating = rating;
        this.cuisine = cuisine;
        this.suburb = suburb;
        this.desc = desc;
        this.address = address;
        this.phone = phone;
        this.website = website;
    }

    //GETTER AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public ArrayList<String> getCuisine() {
        return cuisine;
    }

    public void setCuisine(ArrayList<String> cuisine) {
        this.cuisine = cuisine;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    //Extra methods for the Restaurant
    /**
     * Formats the ArrayList cuisine into a String version that can be used by a TextView
     * @return a String format of the ArrayList cuisine
     */
    public String listCuisine() {
        String list = "";
        for(String type : this.cuisine) {
            if(type.equals(this.cuisine.get(0))) {
                list.concat(type);
            }
            else {
                list.concat(" | " + type);
            }
        }
        return list;
    }

    /**
     * Use this instead of getWebsite() --> More aesthetics
     * @return a formatted version of the website attribute for TextView to use
     */
    public String getFormattedLink() {
        int i = this.website.indexOf(':');
        int k = this.website.indexOf('/', 9);
        return website.substring(i+1, k);
    }

    /**
     * Use this to when creating a phone dial intent
     * @return a value to activate a phone dial Intent
     */
    public String getDial() {
        return "tel:" + phone.replaceAll("\\s", "");
    }

}