package com.campusdual.UsersMenu;

/*
    (USUARIO) MENU DE ACCIONES DE SEGUIDORES
    Te permite seguir o dejar de seguir a otros usuarios

    Extras:
    - No te deja seguirte o dejar de seguirte a ti mismo
    - Puedes repetir la acción
    - Si tú eres el único usuario de la app, te lanza un aviso
 */


import com.campusdual.UtilsDani.Menu;
import com.campusdual.Components.User;

import java.util.*;

import static com.campusdual.SocialJavaApp.getActiveUser;
import static com.campusdual.SocialJavaApp.usersList;
import static com.campusdual.Utils.showAndSelectFromList;
import static com.campusdual.Utils.string;
import static com.campusdual.UtilsDani.Utils.*;

public class FollowedMenu implements Menu {
    public static void display(){
        User user = getActiveUser();
        System.out.println("\n---" + user.getUsername() + "'s following list:----------------------");
        user.showFollowedUsersList();
        System.out.println();

        String msg = "\n1.Follow user | 2.Unfollow User | 0-Prev Menu \nChoose an action: ";
        int selection = getActionInt(0,2, msg);

        switch (selection){
            case 1:
                if (usersList.isEmpty() || usersList.size() == 1) {
                    System.out.println("There are not enough users. Currently: " + usersList.size());
                    display();
                }
                else followLogics(user);
                break;
            case 2:
                if (usersList.isEmpty() || usersList.size() == 1) {
                    System.out.println("There are not enough users. Currently: " + usersList.size());
                    display();
                }
                unfollowLogics(user);
                break;
            case 0:
                UserMenu.display();
                break;
            default:
                System.out.println("Invalid action");
                UserMenu.display();
                break;

        }
    }

    public static void followLogics(User user) {
        List<String> usernameList = new ArrayList<>(usersList.keySet());
        List<String> selection = showAndSelectFromList(usernameList, true, false, user.getFollowedUsersList());
        if (!selection.isEmpty()){
            String toFollow = selection.get(0);
            user.followUser(toFollow); // Follow user
            boolean repeat = wantTo("follow another user");
            if (repeat) followLogics(user);
            else display(); // Exit
        }
        else display(); // Exit
    }

    public static void unfollowLogics(User user) {
        List<String> excludedValues = new ArrayList<>();
        excludedValues.add(user.getUsername());

        List<String> selection = showAndSelectFromList(user.getFollowedUsersList(), true, false, excludedValues);
        if (!selection.isEmpty()){
            String toUnfollow = selection.get(0);
            user.unfollowUser(toUnfollow); // Unfollow user
            boolean repeat = wantTo("unfollow another user");
            if (repeat) unfollowLogics(user);
            else display(); // Exit
        }
        else display(); // Exit
    }
}

