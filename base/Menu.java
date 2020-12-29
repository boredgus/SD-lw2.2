package base;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import DAO.BusDAO;
import DTO.BusDTO;

public class Menu {
    private BusDAO dao = new BusDAO();
    private BusDTO dto = new BusDTO();
    ResourceBundle bundle = ResourceBundle.getBundle("resources.MyMessages " + Locale.getDefault());

    public void setLanguage(){
        Scanner in = new Scanner(System.in);
        boolean check = true;
        System.out.print("ДОБРО ПОЖАЛОВАТЬ!\n");
        String message = "";
        while(check) {
            System.out.print(message + "Выберите язык:\n1. English\n2. Русский (по умолчанию)\n");
            String language = in.nextLine();
            switch (language) {
                case "1":
                    Locale.setDefault(new Locale("en", "US"));
                    check = false;
                    break;
                case "2":
                    Locale.setDefault(new Locale("ru", "RU"));
                    check = false;
                    break;
                default:
                    message = "Неправильное значение! Попробуйте ещё раз!\n";
            }
        }
    }

    public void start(){
        Scanner in = new Scanner((System.in));
        boolean check = true;
        String
        while(check){
            System.out.print(bundle.getString("MenuKEY"));
            String option = in.nextLine();
            switch(option){
                case "1":
                    boolean result = addRow();
                    if(result)
                    break;
                case "2":

                    break;
                case "3":

                    break;
                default:
                    String message = "Wrong option! Try again.";
                    message = (check) ?  "" : "0";
            }
        }
        in.close();
    }

    public boolean addRow(){
        Scanner in = new Scanner(System.in);

        in.close();
        return true;
    }

    public void updateRow(){
        Scanner in = new Scanner(System.in);

        in.close();
    }

    public void deleteRow(){
        Scanner in = new Scanner(System.in);

        in.close();
    }
}
