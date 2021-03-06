/*
 * Created by Khang Bui (z5209606) on 24/03/20 8:15 PM.
 * This is an academic project completed as part of the UNSW course, INFS3634.
 * Copyright (c) 2020. All rights reserved.
 * Last modified 24/03/20 6:44 PM.
 */

package com.example.sydneyrestaurantlist;

import java.util.ArrayList;

//Utility class to manage restaurant data
public class DataUtility {

    /**
     * Use this to get the default list of restaurants. Unfiltered and unordered.
     *
     * @return default list of restaurants.
     */
    public static ArrayList<Restaurant> getDefaultList() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(getHolyHeffas());
        restaurants.add(getMarysNewtown());
        restaurants.add(getWatsupBrothers());
        restaurants.add(getElJannahs());
        restaurants.add(getTFT());
        restaurants.add(getManpuku());
        restaurants.add(getSakura());
        restaurants.add(getRedPepper());
        restaurants.add(getJTB());
        restaurants.add(getPorkRoll());
        return restaurants;
    }


    /**
     * Use this to sort a Restaurant ArrayList from highest ratings (descending order).
     * Uses a QuickSort algorithm to ensure the fastest response time.
     *
     * @param restaurants is the ArrayList to be sorted.
     * @return a RestaurantArrayList sorted in descending order (in terms of ratings).
     */
    public static ArrayList<Restaurant> quickSortDescRating(ArrayList<Restaurant> restaurants) {
        if (restaurants.size() <= 1) {
            return restaurants; //list does not need to be sorted if there is one item
        } else {
            ArrayList<Restaurant> smaller = new ArrayList<>();
            ArrayList<Restaurant> greater = new ArrayList<>();
            Restaurant pivot = restaurants.get(restaurants.size() - 1); //pivot item
            for (int i = 0; i < restaurants.size() - 1; i++) {
                if (restaurants.get(i).getRating() > pivot.getRating()) {
                    greater.add(restaurants.get(i)); //item greater than pivot get added to this
                } else {
                    smaller.add(restaurants.get(i)); //item smaller than pivot get added to this
                }
            }

            //Recursive sorting
            greater = quickSortDescRating(greater); //repeat method for greater list until 1 item
            smaller = quickSortDescRating(smaller); //repeat method for smaller list until 1 item

            //Restructures the ArrayList - NOTE: greater > pivot > smaller
            greater.add(pivot); //adds the pivot
            greater.addAll(smaller); //adds smaller
            return greater; //return ordered ArrayList
        }
    }


    /**
     * Use this to sort a Restaurant ArrayList in ascending order (lowest to highest ratings).
     * Uses a QuickSort algorithm to ensure the fastest response time.
     *
     * @param restaurants is the ArrayList to be sorted.
     * @return a sorted ArrayList ordered by lowest ratings.
     */
    public static ArrayList<Restaurant> quickSortAscRating(ArrayList<Restaurant> restaurants) {
        if (restaurants.size() <= 1) {
            return restaurants;
        } else {
            ArrayList<Restaurant> smaller = new ArrayList<>();
            ArrayList<Restaurant> greater = new ArrayList<>();
            Restaurant pivot = restaurants.get(restaurants.size() - 1); //pivot item
            for (int i = 0; i < restaurants.size() - 1; i++) {
                if (restaurants.get(i).getRating() < pivot.getRating()) {
                    smaller.add(restaurants.get(i));
                } else {
                    greater.add(restaurants.get(i));
                }
            }

            //Recursive sorting
            smaller = quickSortAscRating(smaller);
            greater = quickSortAscRating(greater);

            //Restructures the ArrayList - NOTE: smaller > pivot > greater
            smaller.add(pivot);
            smaller.addAll(greater);
            return smaller;
        }
    }


    /**
     * Use this to sort a Restaurant ArrayList reverse alphabetically.
     * Uses a QuickSort algorithm to ensure the fastest response time.
     *
     * @param restaurants is the ArrayList to be sorted.
     * @return a reverse alphabetical ArrayList.
     */
    public static ArrayList<Restaurant> quickSortReverseAlpha(ArrayList<Restaurant> restaurants) {
        if (restaurants.size() <= 1) {
            return restaurants;
        } else {
            ArrayList<Restaurant> smaller = new ArrayList<>();
            ArrayList<Restaurant> greater = new ArrayList<>();
            Restaurant pivot = restaurants.get(restaurants.size() - 1);
            for (int i = 0; i < restaurants.size() - 1; i++) {
                boolean unsorted = true;
                int index = 0;
                while (unsorted) {
                    if (restaurants.get(i).getName().charAt(index) > pivot.getName().charAt(index)) {
                        greater.add(restaurants.get(i));
                        unsorted = false;
                    } else if (restaurants.get(i).getName().charAt(index) < pivot.getName().charAt(index)) {
                        smaller.add(restaurants.get(i));
                        unsorted = false;
                    } else {
                        index++;
                    }
                }
            }

            //Recursive sorting
            greater = quickSortReverseAlpha(greater);
            smaller = quickSortReverseAlpha(smaller);

            //Restructure list
            greater.add(pivot);
            greater.addAll(smaller);
            return greater;
        }
    }


    /**
     * Use this to sort an ArrayList by alphabetical order.
     * Uses a QuickSort algorithm to ensure the fastest response time.
     *
     * @param restaurants is the ArrayList to be sorted.
     * @return an alphabetically sorted ArrayList
     */
    public static ArrayList<Restaurant> quickSortAlpha(ArrayList<Restaurant> restaurants) {
        if (restaurants.size() <= 1) {
            return restaurants;
        } else {
            ArrayList<Restaurant> smaller = new ArrayList<>();
            ArrayList<Restaurant> greater = new ArrayList<>();
            Restaurant pivot = restaurants.get(restaurants.size() - 1);
            for (int i = 0; i < restaurants.size() - 1; i++) {
                boolean unsorted = true;
                int index = 0;
                while (unsorted) {
                    if (restaurants.get(i).getName().charAt(index) < pivot.getName().charAt(index)) {
                        smaller.add(restaurants.get(i));
                        unsorted = false;
                    } else if (restaurants.get(i).getName().charAt(index) > pivot.getName().charAt(index)) {
                        greater.add(restaurants.get(i));
                        unsorted = false;
                    } else {
                        index++;
                    }
                }
            }

            //Recursive sorting
            smaller = quickSortAlpha(smaller);
            greater = quickSortAlpha(greater);

            //Restructure list
            smaller.add(pivot);
            smaller.addAll(greater);
            return smaller;
        }
    }

    //The following methods return a certain restaurant
    private static Restaurant getHolyHeffas() {
        String name = "Holy Heffas";
        int ivId = R.drawable.holyheffa;
        float rating = 4.2f;
        ArrayList<String> cuisine = new ArrayList<>();
        cuisine.add("$$");
        cuisine.add("American");
        cuisine.add("Burgers");
        String suburb = "Edensor Park, NSW 2176";
        String desc = "Welcome to Holy Heffa - a burger truck devoted to serving affordable, delicious burgers.\n\n" +
                "Our menu changes regularly, with a different milkshake, special and topping for fries" +
                " each week. But you'll be coming here to eat our meat: freshly ground angus formed " +
                "into patties, grilled to medium-rare, and sandwiched within brioche-like buns. With " +
                "little exception, our burgers are delicious, juicy and messy, enhanced by a carefully " +
                "selected toppings.";
        String address = "661-671 Smithfield Rd, Edensor Park NSW 2176";
        String phone = "0414 046 726";
        String website = "http://www.holyheffa.com.au/menu";
        return new Restaurant(name, ivId, rating, cuisine, suburb, desc, address, phone, website);
    }

    private static Restaurant getMarysNewtown() {
        String name = "Mary's Newtown";
        int ivId = R.drawable.marysnewtown;
        float rating = 4.4f;
        ArrayList<String> cuisine = new ArrayList<>();
        cuisine.add("$$");
        cuisine.add("American");
        cuisine.add("Burgers");
        String suburb = "Newtown, NSW 2042";
        String desc = "Craft beer and burgers in a rustic bar with timber decor, a mezzanine and a " +
                "rock 'n' roll vibe.";
        String address = "6 Mary St, Newtown NSW 2042";
        String phone = "(02) 9002 0683";
        String website = "https://www.marys69.com/#/newtown/";
        return new Restaurant(name, ivId, rating, cuisine, suburb, desc, address, phone, website);
    }

    private static Restaurant getWatsupBrothers() {
        String name = "Watsup Brothers";
        int ivId = R.drawable.watsupbrothers;
        float rating = 4.5f;
        ArrayList<String> cuisine = new ArrayList<>();
        cuisine.add("$");
        cuisine.add("Turkish");
        cuisine.add("Kebab");
        String suburb = "Condell Park, NSW 2200";
        String desc = "Kebab, pizza, pide, charcoals and burgers.";
        String address = "149 Eldridge Rd, Condell Park NSW 2200";
        String phone = "(02) 8764 3236";
        String website = "https://www.watsupbrotherskebabs.com.au/condellpark.html";
        return new Restaurant(name, ivId, rating, cuisine, suburb, desc, address, phone, website);
    }

    private static Restaurant getElJannahs() {
        String name = "El Jannahs - Punchbowl";
        int ivId = R.drawable.eljannahs;
        float rating = 4.3f;
        ArrayList<String> cuisine = new ArrayList<>();
        cuisine.add("$");
        cuisine.add("Lebanese");
        cuisine.add("Chicken");
        String suburb = "Punchbowl, NSW 2196";
        String desc = "Lebanese food and charcoal chicken, cooked in an easygoing, counter-serve " +
                "joint with simple tables.";
        String address = "701 Punchbowl Rd, Punchbowl NSW 2196";
        String phone = "(02) 9759 2999";
        String website = "https://www.eljannah.com.au/";
        return new Restaurant(name, ivId, rating, cuisine, suburb, desc, address, phone, website);
    }

    private static Restaurant getTFT() {
        String name = "It's Time for Thai";
        int ivId = R.drawable.tft;
        float rating = 4.8f;
        ArrayList<String> cuisine = new ArrayList<>();
        cuisine.add("$");
        cuisine.add("Thai");
        cuisine.add("Malaysian");
        String suburb = "Kingsford NSW 2032";
        String desc = "Smart Thai eatery with colourful light shades serving classic curries, " +
                "BBQ & stir-fries.";
        String address = "2/309 Anzac Parade, Kingsford NSW 2032";
        String phone = "(02) 9662 3126";
        String website = "https://timeforthai.com.au/menu.html";
        return new Restaurant(name, ivId, rating, cuisine, suburb, desc, address, phone, website);
    }

    private static Restaurant getManpuku() {
        String name = "Manpuku Ramen";
        int ivId = R.drawable.manpuku;
        float rating = 4.4f;
        ArrayList<String> cuisine = new ArrayList<>();
        cuisine.add("$$");
        cuisine.add("Japanese");
        cuisine.add("Ramen");
        String suburb = "Kingsford NSW 2032";
        String desc = "Kingsford Manpuku is located in lively reasonable asian restaurant area " +
                "in Kingsford, only 200m away from UNSW.";
        String address = "482 Anzac Parade, Kingsford NSW 2032";
        String phone = "(02) 9662 1236";
        String website = "https://www.ramenmanpuku.com/menu";
        return new Restaurant(name, ivId, rating, cuisine, suburb, desc, address, phone, website);
    }

    private static Restaurant getSakura() {
        String name = "Sakura Fresh Sushi";
        int ivId = R.drawable.sakura;
        float rating = 4.6f;
        ArrayList<String> cuisine = new ArrayList<>();
        cuisine.add("$");
        cuisine.add("Japanese");
        cuisine.add("Sushi");
        String suburb = "Revesby NSW 2212";
        String desc = "Typical Japanese eatery with simple decor for made-to-order meals, " +
                "plus sashimi & tempura.";
        String address = "2/23 Selems Parade, Revesby NSW 2212";
        String phone = "(02) 9773 0779";
        String website = "https://www.facebook.com/pages/Sakura-Fresh-Sushi-Revesby/274849102594175";
        return new Restaurant(name, ivId, rating, cuisine, suburb, desc, address, phone, website);
    }

    private static Restaurant getRedPepper() {
        String name = "Red Pepper Bistro";
        int ivId = R.drawable.redpepper;
        float rating = 4.1f;
        ArrayList<String> cuisine = new ArrayList<>();
        cuisine.add("$$");
        cuisine.add("Korean");
        cuisine.add("Chicken");
        String suburb = "Strathfield NSW 2135";
        String desc = "Korean bulgogi & fried chicken served in a busy, cafeteria-style dining " +
                "room inside a sports club.";
        String address = "19 Morwick St, Strathfield NSW 2135";
        String phone = "(02) 9701 0911";
        String website = "https://strathfieldsportsclub.com.au/wp-content/uploads/2019/12/Full-Menu.pdf";
        return new Restaurant(name, ivId, rating, cuisine, suburb, desc, address, phone, website);
    }

    private static Restaurant getJTB() {
        String name = "Jang Ta Bal";
        int ivId = R.drawable.jtb;
        float rating = 4.5f;
        ArrayList<String> cuisine = new ArrayList<>();
        cuisine.add("$$");
        cuisine.add("Korean");
        cuisine.add("K-BBQ");
        String suburb = "Strathfield NSW 2135";
        String desc = "Convivial Korean eatery with tabletop BBQ grills for cooking meat, " +
                "plus generous platters to share.";
        String address = "48A The Boulevarde, Strathfield NSW 2135";
        String phone = "(02) 9747 2800";
        String website = "https://jangtabal.com.au/";
        return new Restaurant(name, ivId, rating, cuisine, suburb, desc, address, phone, website);
    }

    private static Restaurant getPorkRoll() {
        String name = "Marrickville Pork Roll";
        int ivId = R.drawable.porkroll;
        float rating = 4.7f;
        ArrayList<String> cuisine = new ArrayList<>();
        cuisine.add("$");
        cuisine.add("Vietnamese");
        cuisine.add("Bread");
        String suburb = "Marrickville NSW 2204";
        String desc = "Popular counter-service nook, specialising in Vietnamese rolls filled " +
                "with pork and other meats.";
        String address = "236 Illawarra Rd, Marrickville NSW 2204";
        String phone = "0479 000 445";
        String website = "https://www.zomato.com/sydney/marrickville-pork-roll-marrickville/menu";
        return new Restaurant(name, ivId, rating, cuisine, suburb, desc, address, phone, website);
    }

    /**
     * Searches ArrayList and returns a restaurant based on name result
     *
     * @param name of a restaurant
     * @return a Restaurant object with the same and exact name of the restaurant
     */
    public static Restaurant searchRestaurant(String name) {
        ArrayList<Restaurant> restaurants = getDefaultList();
        Restaurant result = null;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(name)) {
                result = restaurant;
                break;
            }
        }
        return result;
    }

}
