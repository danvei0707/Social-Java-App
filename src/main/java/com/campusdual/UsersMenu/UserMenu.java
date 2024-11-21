package com.campusdual.UsersMenu;

import com.campusdual.AdminMenu.HomeMenu;
import com.campusdual.UtilsDani.Menu;
import com.campusdual.Components.User;

import static com.campusdual.Main.usersList;
import static com.campusdual.UtilsDani.Utils.getActionInt;
import static com.campusdual.UtilsDani.Utils.wantTo;

public class UserMenu implements Menu {
    public static void display(String usrName) {
        User myUsr = usersList.get(usrName);
        System.out.println();
        System.out.println("1. Followed users");
        System.out.println("2. User posts");
        System.out.println("3. Delete account");
        System.out.println();
        System.out.println("0. Log out");

        String msg = "\n(" + usrName + ") What do you want to do? ";
        int selection = getActionInt(0, 3, msg);

        switch (selection) {
            case 0:
                System.out.println("Logging out...");
                HomeMenu.display();
                break;
            case 1:
                FollowedMenu.display(myUsr);
                break;
            case 2:
                YourPostsMenu.display(myUsr);
                break;
            case 3:
                if(wantTo("delete this user")) {
                    myUsr.removeAccount(usersList);
                    HomeMenu.display();
                }
                else display(usrName);
                break;
        }
    }
}
