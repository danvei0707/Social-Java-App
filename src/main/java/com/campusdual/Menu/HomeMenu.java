package com.campusdual.Menu;

import java.util.Scanner;

public class HomeMenu implements Menu{
    public static void display(String usr) {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------\n");
        System.out.println("What do you want to do " + usr + "?\n");
        System.out.println("1 - Check latest posts");
        System.out.println("2 - Search for an user");
        System.out.println("3 - Create a new post");
        System.out.println("4 - See your posts");

        selection = input.nextInt();

        switch (selection) {
            case 1:
                System.out.println("1 - Check latest posts");
                break;
            case 2:
                System.out.println("2 - Search for an user");
                break;
            case 3:
                System.out.println("3 - Create a new post");
                break;
            case 4:
                System.out.println("4 - See your posts");
                break;
            default:
                System.out.println("Hm, invalid option");
        }
    }
}
