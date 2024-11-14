package com.campusdual;

import com.campusdual.Components.User;
import com.campusdual.Menu.HomeMenu;
import com.campusdual.Menu.LogMenu;

import java.util.HashMap;

import static com.campusdual.UtilsDani.TestRunner.testAll;

public class Main {
    public static HashMap<String, User> usersList = new HashMap<String, User>();

    public static void main(String[] args) {
        System.out.println("Loading social Java app...\n");


        //testAll();

        String currentUser = LogMenu.display();
        HomeMenu.display(currentUser);

    }


}