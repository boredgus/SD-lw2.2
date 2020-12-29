package base;

import java.util.*;

import DAO.BusDAO;
import DTO.BusDTO;

public class Menu {
    private BusDAO dao = new BusDAO();
    private BusDTO dto = new BusDTO();
    ArrayList<Bus> busList = new ArrayList<>();
    BusView busView = new BusView();
    BusController busController = new BusController(busList, busView);
    ResourceBundle bundle = ResourceBundle.getBundle("resources.MyMessages " + Locale.getDefault());

    public void setLanguage(){
        Scanner in = new Scanner(System.in);
        boolean check = true;
        System.out.print(bundle.getString("WelcomeKEY")+"\n");
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
        String message = "";
        while(check){
            System.out.print(message + bundle.getString("Menu1KEY"));
            message = "";
            String option = in.nextLine();
            switch(option){
                case "1":
                    addRow();
                    break;
                case "2":
                    updateRow();
                    break;
                case "3":
                    deleteRow();
                    break;
                case "4":
                    check = false;
                    break;
                default:
                    message = bundle.getString("WrongOptionKEY");
            }
        }
        in.close();
    }

    public void addRow(){
        Scanner in = new Scanner(System.in);
        System.out.print(bundle.getString("AddingMessageKEY"));
        System.out.print(bundle.getString("EnterDriverNameKEY"));
        String driverName = in.nextLine();
        System.out.print(bundle.getString("EnterRouteKEY"));
        String route = in.nextLine();
        System.out.print(bundle.getString("EnterNumKEY"));
        int num = in.nextInt();
        System.out.print(bundle.getString("EnterMileageKEY"));
        long mileage = in.nextLong();

        busList.add(new Bus(driverName, num, route, mileage));
        dto.setAll(busController.getWholeBus(busList.size() - 1));
        dao.addRow(dto);
        in.close();
    }

    public void updateRow(){
        Scanner in = new Scanner(System.in);
        System.out.print(bundle.getString("UpdatingMessageKEY"));

        in.close();
    }

    public void deleteRow(){
        Scanner in = new Scanner(System.in);
        System.out.print(bundle.getString("DeletingMessageKEY"));
        boolean check = true;
        while(check){
            System.out.print(bundle.getString("EnterIdKEY"));
            int id = in.nextInt();
            dao.deleteRow(id);
        }
        in.close();
    }
}
