package com.campusdual.AdminMenu;

import com.campusdual.Components.User;
import com.campusdual.Main;
import com.campusdual.UsersMenu.FollowedMenu;
import com.campusdual.UsersMenu.LogMenu;
import com.campusdual.UsersMenu.NewPostMenu;
import com.campusdual.UsersMenu.YourPostsMenu;
import com.campusdual.UtilsDani.Menu;
import com.campusdual.UtilsDani.MockData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.campusdual.Main.usersList;
import static com.campusdual.Utils.*;
import static com.campusdual.UtilsDani.InputScanner.input;

public class HomeMenu implements Menu {
    public static boolean isMockCreated = false;
    public static void display() {
        List<String> actions = new ArrayList<>();
        actions.add("Admin management");
        actions.add("User actions");
        actions.add("Create Mock data");

        showFromList(actions, false); // Just show elements

        // Validation logics
        int selection;
        boolean valid = false;
        do {
            selection = integer("\nChoose an action (0 to exit):  ");
            if (selection < 0 || selection > 3) System.out.println("Select a valid option");
            else valid = true;
        } while (!valid);

        switch (selection) {
            case 0:
                System.out.println("Exiting the app...");
                break;
            case 1:
                ManagementMenu.display();
                break;
            case 2:
                LogMenu.display();
                break;
            case 3:
                if (!isMockCreated){
                    MockData.build();
                    isMockCreated = true;
                    HomeMenu.display();
                    break;
                }
            default:
                System.out.println("Invalid option");
                display();
        }
    }
}
