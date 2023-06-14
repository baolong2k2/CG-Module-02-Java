package view.multiverse_view;

import model.entity.Galaxy;
import model.exception.InvalidChoiceException;
import model.service.GalaxyService;
import model.service.MultiverseService;
import model.service.PlanetService;
import model.service.UserService;
import model.ulti.Input;

public class MultiverseView {
    private static final MultiverseView multiverseView = new MultiverseView();
    private MultiverseView() {
    }
    public static MultiverseView getInstance() {
        return multiverseView;
    }


    public void customizeMultiverse() {
        do {
            try {
                System.out.println("""
                        🔱 CHOOSE ACTION 🔱
                        
                        (1) Add to Multiverse list
                        (2) Remove the Multiverse from the list
                        (3) Edit Multiverse list
                        (4) Use the Time Stone to return to the menu
                        """);
                int choice = Input.choiceIntegerInput("Choose a number of destiny: ");
                switch (choice){

                    case 1:
                        MultiverseService.getInstance().addMultiverse();
                        break;

                    case 2:
                        MultiverseService.getInstance().removeMultiverse();
                        break;

                    case 3:
                        MultiverseService.getInstance().editMultiverse();
                        break;

                    case 4:
                        return;

                    default:
                        throw new InvalidChoiceException("⛔Invalid selection⛔");
                }
            } catch (Exception e) { e.printStackTrace();}
        } while (true);
    }

    public void exploreMultiverse (){
        MultiverseService.getInstance().displayDetailOfMultiverse();
        System.out.println("""
                        💫💫💫 Which universe do you want to experience?  💫💫💫
                                                
                        """);
        int id = Input.choiceIntegerInput("GIVE ME ID: ");
        MultiverseService.getInstance().displayChoosenMultiverse(id);
    }
}
