package com.campusdual.UsersMenu;

/*

    (USUARIO/ADMIN) MENU DE CREACION DE POSTS
    Contiene el proceso de creación de los tres tipos de post

    EXTRAS:
    - Posibilidad de crear rápidamente otro post

 */

import com.campusdual.AdminMenu.ManagementMenu;
import com.campusdual.UtilsDani.Menu;
import com.campusdual.Components.Post;
import com.campusdual.Components.PostsContent.ImageContent;
import com.campusdual.Components.PostsContent.TextContent;
import com.campusdual.Components.PostsContent.VideoContent;
import com.campusdual.Components.User;

import static com.campusdual.Utils.integer;
import static com.campusdual.Utils.string;
import static com.campusdual.UtilsDani.Utils.getActionInt;
import static com.campusdual.UtilsDani.Utils.wantTo;

public class NewPostMenu implements Menu {
    public static void display(User myUsr, boolean isAdmin){
        System.out.println("\n--- New post creation ----------------------");
        String msg = "1.Video | 2.Image | 3.Text | 0.Cancel";
        int selection = getActionInt(0,3,msg);

        switch (selection) {
            case 1:
                System.out.println();
                newVideo(myUsr);
                break;
            case 2:
                System.out.println();
                newImage(myUsr);
                break;
            case 3:
                System.out.println();
               newText(myUsr);
                break;
            case 0:
                // Go back
                if (!isAdmin) YourPostsMenu.display();
                else ManagementMenu.display();
                break;
            default:
                System.out.println("Invalid option");
                UserMenu.display();
        }

        boolean repeat = wantTo("create another post");
        if (repeat) NewPostMenu.display(myUsr,isAdmin);
        else {
            // Go back
            if (!isAdmin) YourPostsMenu.display();
            else ManagementMenu.display();
        }
    }

    static void newVideo(User myUsr){
        String title = "";
        int resolution;
        int lengthSeconds;

        do{
            title = string("Video title: ");
        }while (title.length() < 3);

        do{
            System.out.print("Video resolution (integer): ");
            resolution = integer();
        }while (resolution < 122 || resolution > 10000);

        do {
            System.out.print("Video length (seconds): ");
            lengthSeconds= integer();
        }while (lengthSeconds <= 0);

        System.out.print("Posting video... ");
        VideoContent vc = new VideoContent(title, resolution, lengthSeconds);
        myUsr.createPost(new Post(vc));
    }

    static void newImage(User myUsr){
        String title;
        String aspectRatio;

        do{
            title = string("Image title: ");
        }while (title.length() < 3);

        do{
            aspectRatio = string("Image aspect ratio (width/height): ");
        }while (aspectRatio.isEmpty());

        System.out.print("Posting image... ");
        ImageContent ic = new ImageContent(title, aspectRatio);
        myUsr.createPost(new Post(ic));
    }

    static void newText(User myUsr){
        String title;

        do{;
            title = string("Content: "); // ERROR
        }while (title.length() < 3);

        System.out.print("Posting text... ");
        TextContent tc = new TextContent(title);
        myUsr.createPost(new Post(tc));
    }
}
