package com.campusdual;

import com.campusdual.Components.User;
import com.campusdual.UsersMenu.HomeMenu;
import com.campusdual.UsersMenu.LogMenu;
import com.campusdual.UtilsDani.MockData;

import java.util.HashMap;

public class Main {
    public static HashMap<String, User> usersList = new HashMap<String, User>();

    public static void main(String[] args) {
        System.out.println("Loading social Java app...\n");


        //testAll();

        MockData.build();



//        String currentUser = LogMenu.display();
//        HomeMenu.display(currentUser);

    }


}