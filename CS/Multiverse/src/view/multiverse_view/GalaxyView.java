package view.multiverse_view;

import model.exception.InvalidChoiceException;
import model.service.GalaxyService;
import model.ulti.Input;

public class GalaxyView {
    private static final GalaxyView galaxyView = new GalaxyView();
    private GalaxyView(){
    }
    public static GalaxyView getInstance() {
        return galaxyView;
    }
    public void customizeGalaxy() {
        do {
            try {
                System.out.println("""
                        *** ✊ USE POWER STONE FOR ✊***
                        (1) Show all galaxy 🤩
                        (2) Add to galaxy list 🥰
                        (3) Remove the galaxy from the list 😾
                        (4) Edit galaxy list 😿
                        (5) Use the Time Stone to return to the menu ⏳
                        """);
                int choice = Input.choiceIntegerInput("Choose a number of destiny: ");
                switch (choice){

                    case 1:
                        GalaxyService.getInstance().exploreGalaxy();
                        break;

                    case 2:
                        GalaxyService.getInstance().addGalaxy();
                        break;

                    case 3:
                        GalaxyService.getInstance().removeGalaxy();
                        break;

                    case 4:
                        GalaxyService.getInstance().editGalaxy();
                        break;

                    case 5:
                        return;

                    default:
                        throw new InvalidChoiceException("Invalid selection");
                }
            } catch (Exception e) { e.printStackTrace();}
        } while (true);
    }

}
