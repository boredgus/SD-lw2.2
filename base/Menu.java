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
        bundle = ResourceBundle.getBundle("resources.MyMessages " + Locale.getDefault());
    }

    public void start(){
        Scanner in = new Scanner(System.in);
        boolean check = true;
        String message = "";
        while(check){
            System.out.print(message + bundle.getString("Menu1KEY"));
            message = "";
            int option = in.nextInt();
            switch(option){
                case 1:
                    addRow();
                    break;
                case 2:
                    updateRow();
                    break;
                case 3:
                    deleteRow();
                    break;
                case 4:
                    check = false;
                    break;
                default:
                    message = bundle.getString("WrongOptionKEY");
            }
        }
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
    }

    public void updateRow(){
        Scanner in = new Scanner(System.in);
        System.out.print(bundle.getString("UpdatingMessageKEY"));
        System.out.print(bundle.getString("EnterIdKEY"));
        int id = in.nextInt();

        boolean check = true;
        while(check) {
            System.out.print(bundle.getString("Menu2KEY"));
            String option = in.nextLine();
            switch (option) {
                case "1":
                    System.out.print(bundle.getString("EnterDriverNameKEY"));
                    String driverName = in.nextLine();
                    busController.getWholeBus(id - 1).setDriverName(driverName);
                    dto.setAll(busController.getWholeBus(id - 1));
                    dao.updateRow(dto, id);
                    check = false;
                    break;
                case "2":
                    System.out.print(bundle.getString("EnterNumKEY"));
                    int num = in.nextInt();
                    busController.getWholeBus(id - 1).setNum(num);
                    dto.setAll(busController.getWholeBus(id - 1));
                    dao.updateRow(dto, id);
                    check = false;
                    break;
                case "3":
                    System.out.print(bundle.getString("EnterRouteKEY"));
                    String route = in.nextLine();
                    busController.getWholeBus(id - 1).setRoute(route);
                    dto.setAll(busController.getWholeBus(id - 1));
                    dao.updateRow(dto, id);
                    check = false;
                    break;
                case "4":
                    System.out.print(bundle.getString("EnterMileageKEY"));
                    long mileage = in.nextLong();
                    busController.getWholeBus(id - 1).setMileage(mileage);
                    dto.setAll(busController.getWholeBus(id - 1));
                    dao.updateRow(dto, id);
                    check = false;
                    break;
                case "5":
                    check = false;
                    break;
                default:
                    System.out.print(bundle.getString("WrongOptionKEY"));
            }
        }
    }

    public void deleteRow(){
        Scanner in = new Scanner(System.in);
        System.out.print(bundle.getString("DeletingMessageKEY"));
        System.out.print(bundle.getString("EnterIdKEY"));
        int id = in.nextInt();
        dao.deleteRow(id);
    }
}
