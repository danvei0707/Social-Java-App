package com.campusdual.UsersMenu;

import com.campusdual.AdminMenu.ManagementMenu;
import com.campusdual.UtilsDani.Menu;
import com.campusdual.UtilsDani.MockData;

import java.util.ArrayList;
import java.util.List;

import static com.campusdual.Utils.*;

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
