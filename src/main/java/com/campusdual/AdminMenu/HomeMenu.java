package com.campusdual.AdminMenu;

import com.campusdual.Components.User;
import com.campusdual.Main;
import com.campusdual.UsersMenu.FollowedMenu;
import com.campusdual.UsersMenu.LogMenu;
import com.campusdual.UsersMenu.NewPostMenu;
import com.campusdual.UsersMenu.YourPostsMenu;
import com.campusdual.UtilsDani.Menu;
import com.campusdual.UtilsDani.MockData;

import static com.campusdual.Main.usersList;
import static com.campusdual.UtilsDani.InputScanner.input;

public class HomeMenu implements Menu {
    public static boolean isMockCreated = false;
    public static void display() {
        int selection;

        System.out.println("\n-------------------------");
        System.out.println("1. Admin management (beta)");
        System.out.println("2. User actions");
        if (!isMockCreated) System.out.println("3. Create Mock data");
        System.out.println();
        System.out.println("0. Exit");
        System.out.print("\nChoose an action:  ");
        selection = input.nextInt();

        switch (selection) {
            case 0:
                // Exit app
                System.out.println("Closing app... (in process)");
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
        }
    }
}
