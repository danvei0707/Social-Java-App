package com.campusdual.UsersMenu;

/*
    (USUARIO) MENU DE GESTIÓN DE POSTS
    Este menú permite acceder al menú de creación de nuevos posts, así como a las funcionalidades de eliminar posts propios o comentarios en los mismos

    EXTRA:
    - Acceso rápido a eliminar varios comentarios
    - Selección de los post por ID
    - Diferentes visualizaciones del menú según haya posts o no
 */

import com.campusdual.Components.Comment;
import com.campusdual.Components.Post;
import com.campusdual.UtilsDani.Menu;
import com.campusdual.Components.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.campusdual.Utils.showAndSelectFromList;
import static com.campusdual.Utils.string;
import static com.campusdual.UtilsDani.InputScanner.input;
import static com.campusdual.UtilsDani.Utils.getActionInt;
import static com.campusdual.UtilsDani.Utils.wantTo;

public class YourPostsMenu implements Menu {
    public static void display(User myUsr){
        System.out.println("\n---" + myUsr.getUsername() + "'s posts: -------");
        myUsr.listMyPosts(100);
        System.out.println();

        // When the user has 0 posts
        if (myUsr.getMyPosts().isEmpty()){
            System.out.println("There are no posts yet\n\n");
            String msg = "1.Create Post | 0.Prev Menu";
            int selection = getActionInt(0,1, msg);

            switch (selection) {
                case 1: // Create a post
                    NewPostMenu.display(myUsr, false);
                    break;
                case 0: // Go back
                    UserMenu.display(myUsr.getUsername());
                    break;
                default:
                    System.out.println("Invalid action");
                    UserMenu.display(myUsr.getUsername());
            }
        }

        // When the user already has posts
        else {
            String msg = "1.Create Post | 2.Delete Post | 3.Delete Comment | 0.Prev Menu\n";
            int selection = getActionInt(0,3,msg);

            switch (selection) {
                case 1: // Open creation menu
                    NewPostMenu.display(myUsr, false);
                    break;
                case 2: // Delete and reset posts menu
                    deletePost(myUsr);
                    break;
                case 3: // Select post, then comment, then delete and reset posts menu
                    deleteComment(myUsr);
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

    // Delete post function

    protected static void deletePost(User myUsr){
        Post post = null;
        do {
            String postId = string("Id of the post to delete: ");
            if (postId.equals("0")) break; // Start cancel...
            post = myUsr.getSpecificPost(postId);
            if (post == null) System.out.println("Invalid post ID");;
        }while (post == null);

        if (post != null){ // If not exit
            myUsr.deletePostById(post.getId());
            boolean repeat = wantTo("delete another post");
            if (repeat) deleteComment(myUsr);
            else display(myUsr); // No repeat
        }
        else display(myUsr); // Cancel
    }

    // Delete comments variants

    protected static void deleteComment(User myUsr){
        Post post = null;

        do {
            String postId = string("Id of the related post: ");
            if (postId.equals("0")) break; // Exit
            post = myUsr.getSpecificPost(postId);
            if (post == null) System.out.println("Invalid post ID");;
        }while (post == null);

        if (post != null){ // If not exit
            List<String> commentsList = new ArrayList<>(); // Get the comments content into a list
            for (Comment c: post.getComments()){
                commentsList.add(c.getContent());
            }
            List<String> selectedList = showAndSelectFromList(commentsList, true); // Select from comments list
            if (!selectedList.isEmpty()) {
                post.deleteComment(selectedList.get(0)); // Delete
                boolean repeat = wantTo("delete another comment");
                if (repeat) deleteComment(myUsr, post);
                else display(myUsr); // No repeat
            }
        }
        else display(myUsr); // Cancel
    }

    // Shortcut for repeat version
    protected static void deleteComment(User myUsr, Post post){
            List<String> commentsList = new ArrayList<>(); // Get the comments content into a list
            for (Comment c: post.getComments()){
                commentsList.add(c.getContent());
            }
            List<String> selectedList = showAndSelectFromList(commentsList, true); // Select from comments list
            if (!selectedList.isEmpty()) {
                post.deleteComment(selectedList.get(0)); // Delete
                boolean repeat = wantTo("delete another comment");
                if (repeat) deleteComment(myUsr, post);
                else display(myUsr); // No repeat
            }
            else display(myUsr); // Cancel
    }
}
