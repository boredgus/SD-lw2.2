package base;


import DAO.BusDAO;
import DTO.BusDTO;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
//        Locale.setDefault(new Locale("en", "US"));
//        ResourceBundle myMessages = ResourceBundle.getBundle("resources.MyMessages en US");
//        System.out.print(myMessages.getString("ErrorKEY"));
//        ResourceBundle.getBundle("resources.MyMessages en US").getString("ErrorKEY");
//        System.out.println(Locale.getDefault());
        try {
            Menu menu = new Menu();
            menu.setLanguage();
            menu.start();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }




//        Scanner in = new Scanner(System.in);
//        boolean check = true;
//        System.out.print("ДОБРО ПОЖАЛОВАТЬ!\nВыберите язык:\n1. English\n2. Русский (по умолчанию)");
//        String language = in.nextLine();
//        String message = "";
//        while(check) {
//            System.out.print(message + "\nChoose appropriate option:\n" +
//                    "1. Add row\n2. Update row\n3. Delete row\4. Exit database\n");
//            String option = in.nextLine();
//            switch(option){
//                case "1":
//                    boolean result = menu.addRow();
//                    if(result)
//                    break;
//                case "2":
//
//                    break;
//                case "3":
//
//                    break;
//                default:
//                    message = "Wrong option! Try again.";
//            }
//        }

//Locale.setDefault(new Locale("en", "US"));
//    BusDAO dao = new BusDAO();
//     BusDTO dto = new BusDTO();
//        // створюю список елементів, вигляд та контролер елементів
//        ArrayList<Bus> busList = new ArrayList<>();
//        busList.add(new Bus("Petro",1,"453a", 38789));
//        busList.add(new Bus("Ivan",2,"787",22767));
//        busList.add(new Bus("Vasyliy",3,"121c",12908));
//        busList.add(new Bus("Pavlo",4,"11",121909));
//        busList.add(new Bus("Serhii",5,"90r",87999));
//        busList.add(new Bus("Oleksii",6,"434",565656));
//        BusView busView = new BusView();
//        BusController busController = new BusController(busList, busView);
//
//        // записую елементи до БД
//        for (int i = 0; i < busList.size(); i++){
//            dto.setAll(busController.getWholeBus(i));
//            dao.addRow(dto);
//        }
//
//        // змінюю деякі значення елементів
//        busController.getWholeBus(0).setDriverName("Mykola");
//        busController.getWholeBus(1).setMileage(12000);
//        busController.getWholeBus(2).setRoute("622n");
//
//        // вношу зміни до БД
//        for(int i = 0; i < 3; i++) {
//            dto.setAll(busController.getWholeBus(i));
//            dao.updateRow(dto, i + 1);
//        }
//
//        // видаляю деякі елементи з БД
//        dao.deleteRow(4);
//        dao.deleteRow(6);

    }
}
