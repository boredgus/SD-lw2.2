package base;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
//            Scanner in = new Scanner(System.in);
            menu.setLanguage();
            menu.start();
//            in.close();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
}
