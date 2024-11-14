package com.campusdual.UsersMenu;

import com.campusdual.Components.Post;
import com.campusdual.Components.PostsContent.ImageContent;
import com.campusdual.Components.PostsContent.TextContent;
import com.campusdual.Components.PostsContent.VideoContent;
import com.campusdual.Components.User;

import java.util.Objects;
import java.util.Scanner;

import static com.campusdual.UtilsDani.InputScanner.input;

public class NewPostMenu implements Menu{
    public static void display(User myUsr){
        System.out.println("-------------------------\n");
        System.out.println("New post creation\n");

        int selection;
        do {
            System.out.println("1.Video | 2.Image | 3.Text | 0.Cancel");
            System.out.print("Select post type:");
            selection = input.nextInt();
        } while (selection > 3 || selection < 0);

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
                YourPostsMenu.display(myUsr);
                break;
            default:
                System.out.println("Invalid option");
                HomeMenu.display(myUsr.getUsername());
        }

        System.out.println("Do you want to create another post? (y/n): ");
        String restartCreation = input.next();
        if (Objects.equals(restartCreation, "y")){
            NewPostMenu.display(myUsr);
        }
        else {
            YourPostsMenu.display(myUsr);
        }
    }

    static void newVideo(User myUsr){
        String title;
        int resolution;
        int lengthSeconds;

        Scanner videoInput = new Scanner(System.in);

        do{
            System.out.print("Video title: ");
            title = videoInput.nextLine();
        }while (title.length() < 3);

        do{
            System.out.print("Video resolution (just numbers, eg 720): ");
            resolution = input.nextInt();
        }while (resolution < 122 || resolution > 10000);

        do {
            System.out.print("Video length (seconds): ");
            lengthSeconds=input.nextInt();
        }while (lengthSeconds < 0);

        System.out.print("Posting video... ");
        VideoContent vc = new VideoContent(title, resolution, lengthSeconds);
        myUsr.createPost(new Post(vc));
    }

    static void newImage(User myUsr){
        String title;
        String aspectRatio;

        Scanner imageInput = new Scanner(System.in);

        do{
            System.out.print("Image title: ");
            title = imageInput.nextLine();
        }while (title.length() < 3);

        do{
            System.out.print("Image aspect ratio (format 'xx/xx'): ");
            aspectRatio = input.nextLine();
        }while (aspectRatio.isEmpty());

        System.out.print("Posting image... ");
        ImageContent ic = new ImageContent(title, aspectRatio);
        myUsr.createPost(new Post(ic));
    }

    static void newText(User myUsr){
        String title;

        Scanner textInput = new Scanner(System.in);

        do{
            System.out.print("Text: ");
            title = textInput.nextLine(); // ERROR
        }while (title.length() < 3);

        System.out.print("Posting text... ");
        TextContent tc = new TextContent(title);
        myUsr.createPost(new Post(tc));
    }
}
