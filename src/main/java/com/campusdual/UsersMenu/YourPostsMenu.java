package com.campusdual.UsersMenu;

import com.campusdual.UtilsDani.Menu;
import com.campusdual.Components.User;

import java.util.Scanner;

import static com.campusdual.UtilsDani.InputScanner.input;

public class YourPostsMenu implements Menu {
    static int selection;

    public static void display(User myUsr){
        System.out.println("\n---" + myUsr.getUsername() + "'s posts: -------");
        myUsr.listMyPosts(100);
        System.out.println();
        if (myUsr.getMyPosts().isEmpty()){
            do {
                System.out.println("1.Create Post | 0.Prev Menu");
                selection = input.nextInt();
            } while (!(selection == 0 | selection == 1));

            switch (selection) {
                case 1:
                    NewPostMenu.display(myUsr, false);
                    break;
                case 0:
                    UserMenu.display(myUsr.getUsername());
                    break;
                default:
                    System.out.println("Invalid option");
                    UserMenu.display(myUsr.getUsername());
            }
        }
        else {
            do {
                System.out.println("1.Create Post | 2.Delete Post | 3.Delete Comment | 0.Prev Menu");
                selection = input.nextInt();
            } while (selection < 0 | selection > 3);

            switch (selection) {
                case 1:
                    NewPostMenu.display(myUsr, false);
                    break;
                case 2:
                    Scanner sc1 = new Scanner(System.in);
                    System.out.print("\nId of the post to delete: ");
                    String idToDelete = sc1.nextLine();
                    myUsr.deletePostById(idToDelete);

                    YourPostsMenu.display(myUsr); // Reset menu
                    break;
                case 3:
                    Scanner sc2 = new Scanner(System.in);
                    System.out.print("\nId of the related post: ");
                    String relatedPost = sc2.nextLine();

                    System.out.print("\nLiteral text of the comment: ");
                    String commentToDelete = sc2.nextLine();
                    myUsr.getSpecificPost(relatedPost).deleteComment(commentToDelete);

                    YourPostsMenu.display(myUsr); // Reset menu
                    break;
                case 0:
                    UserMenu.display(myUsr.getUsername()); // Prev menu
                    break;
                default:
                    System.out.println("Invalid option");
                    UserMenu.display(myUsr.getUsername());
            }
        }


    }

}
