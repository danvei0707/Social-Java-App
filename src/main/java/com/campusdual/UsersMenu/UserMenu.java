package com.campusdual.UsersMenu;

import com.campusdual.UtilsDani.Menu;
import com.campusdual.Components.User;

import static com.campusdual.SocialJavaApp.*;
import static com.campusdual.UtilsDani.Utils.getActionInt;
import static com.campusdual.UtilsDani.Utils.wantTo;

public class UserMenu implements Menu {
    public static void display() {
        User user = getActiveUser();

        System.out.println();
        System.out.println("1. Followed users");
        System.out.println("2. My posts");
//        System.out.println("3. My comments");
        System.out.println("3. Delete account");
        System.out.println();
        System.out.println("0. Log out");

        String msg = "\n(" + user.getUsername() + ") What do you want to do? ";
        int selection = getActionInt(0, 4, msg);

        switch (selection) {
            case 0:
                System.out.println("Logging out...");
                setActiveUser(null);
                LogMenu.display();
                break;
            case 1:
                FollowedMenu.display();
                break;
            case 2:
                YourPostsMenu.display();
                break;
//            case 3:
//                System.out.println("Not implemented");
//                display();
//                break;
            case 3:
                if(wantTo("delete this user")) {
                    user.removeAccount(usersList);
                    LogMenu.display();
                }
                else display();
                break;
        }
    }
}
