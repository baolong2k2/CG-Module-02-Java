package view.multiverse_view;

import model.exception.InvalidChoiceException;
import model.service.GalaxyService;
import model.service.PlanetService;
import model.ulti.Input;

public class PlanetView {
    private static final PlanetView planetView = new PlanetView();
    private PlanetView() {
    }
    public static PlanetView getInstance() {
        return planetView;
    }

    public void customizePlanet() {
        do {
            try {
                System.out.println("""
                        *** USE POWER STONE FOR ***
                        
                        (1) Add to planet list
                        (2) Remove the planet from the list
                        (3) Edit planet list
                        (4) Use the Time Stone to return to the menu
                        """);
                int choice = Input.choiceIntegerInput("Choose a number of destiny: ");
                switch (choice){

                    case 1:
                        PlanetService.getInstance().addPlanet();
                        break;

                    case 2:
                        PlanetService.getInstance().removePlanet();
                        break;

                    case 3:
                        PlanetService.getInstance().editPlanet();
                        break;

                    case 4:
                        return;

                    default:
                        throw new InvalidChoiceException("Invalid selection");
                }
            } catch (Exception e) { e.printStackTrace();}
        } while (true);
    }
    }


