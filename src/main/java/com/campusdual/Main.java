package com.campusdual;

import com.campusdual.AdminMenu.HomeMenu;
import com.campusdual.Components.User;

import java.util.HashMap;

import static com.campusdual.UtilsDani.Utils.GRAY;
import static com.campusdual.UtilsDani.Utils.colorString;

public class Main {
    public static HashMap<String, User> usersList = new HashMap<String, User>();

    public static void listUserList() {
        int i = 0;
        for (String username: usersList.keySet()){
            System.out.print(username);
            System.out.print(colorString(GRAY, " | "));
            i++;
            if (i % 10 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Loading social Java app...\n");

        //testAll();

        HomeMenu.display();
    }


}