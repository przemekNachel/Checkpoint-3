package src;

import java.util.Scanner;
import java.util.ArrayList;

class View {

    String getUserInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private void clearScreen() {
        System.out.print("\033\143");
    }

    void showMainMenu() {
        clearScreen();
        System.out.println("JERZY'S HUMBLE HOME LIBRARY\n\n1. Add book\n2. Edit book\n3. Delete book");
        System.out.println("4. Search\n5. See all books\n6. See books by author\n\n0. Exit");
    }

    void seeBooks(String books) {
        clearScreen();
        System.out.println(books);
        getUserInput();
    }
}
