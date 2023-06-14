package model.service;

import model.entity.Galaxy;
import model.entity.Multiverse;
import model.entity.Planet;
import model.exception.InvalidChoiceException;
import model.ulti.FileReaderUtils;
import model.ulti.Input;
import model.ulti.WriteFileUlti;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlanetService {
    private static final PlanetService planetService = new PlanetService();

    private PlanetService() {
    }

    public static PlanetService getInstance() {
        return planetService;
    }

    private static final List<Planet> PLANET_LIST = new ArrayList<>();

    static {
        try {
            List<Planet> dataList = FileReaderUtils.fileReadingPlanet("src/model/data/planet.csv");
            PLANET_LIST.addAll(dataList);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPlanet() {
        do {
            try {
                String name = Input.prompt("Enter name of Multiverse: ");
                String detail = Input.prompt("GIVE ME A DETAIL YOU HAVE: ");
                String galaxyName = Input.prompt("NAME OF GALAXY: ");
                Integer multiverseId = Input.choiceIntegerInput("ID OF MULTIVERSE: ");
                String typeOfCreature = Input.prompt("Type of creature: ");
                String environment = Input.prompt("Environment of creature: ");
                String civilization = Input.prompt("Civilization of creature: ");
                String namePlanet = Input.prompt("Name of planet: ");


                Planet newPlanet = new Planet(name, detail, galaxyName, multiverseId, typeOfCreature, environment, civilization, namePlanet);

                boolean checkExist = false;
                for (Planet planet : PLANET_LIST) {
                    if (planet.getNamePlanet().equalsIgnoreCase(namePlanet)) {
                        checkExist = true;
                        break;
                    }
                }

                if (checkExist) {
                    System.err.println("ERROR: A Planet with the same name already exists.");
                    continue;
                }

                WriteFileUlti.writeFilePlanet("C:\\CodeGym\\module-02-java\\CS\\Multiverse\\src\\model\\data\\planet.csv", newPlanet);
                PLANET_LIST.add(newPlanet);
                System.out.println("CONGRATULATIONS!!! You have discovered a new planet.");
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public void removePlanet() {
        System.out.println("Current Planet List:");
        displayPlanetList();

        int planetId = Input.choiceIntegerInput("Enter the ID of the Galaxy to remove: ");

        boolean removed = false; //xác định Multiverse nào đã được xóa hay ko
        Iterator<Planet> iterator = PLANET_LIST.iterator();
        while (iterator.hasNext()) { //duyệt danh sách sử dụng iterator
            Planet planet = iterator.next();
            if (planet.getId() == planetId) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.err.println("The Planet has been removed ❗❗❗");
        } else {
            System.out.println(" ❌No Planet found with the provided ID❌");
        }
    }
    private void displayPlanetList() {
        System.out.println("Planet List:");
        for (Planet planet : PLANET_LIST) {
            System.out.println("ID: " + planet.getId() + " ➡ PLANET NAME: " + planet.getNamePlanet() + " ➡ GALAXY NAME: " + planet.getGalaxyName() + " ➡ MULTIVERSE NAME: " + planet.getName() );

        }
    }

    public void editPlanet() {
            while (true) {
                try {
                    PLANET_LIST.forEach(planet -> System.out.println("ID: " + planet.getId() + ". " + planet.getNamePlanet() + " | " + planet.getDetail()));
                    System.out.println("""
                        What would you like to change by using the Reality Stone?
                        (1) Name of Planet 📝
                        (2) Detail of Planet 📝
                        (3) Use Time Stone to return ⏳
                        """);
                    int choice = Input.choiceIntegerInput("Select your choice: ");
                    if (choice == 3) {
                        return;
                    }
                    int id = Input.choiceIntegerInput("Enter the ID of the Galaxy to edit: ");
                    Planet planet = PLANET_LIST.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
                    if (planet == null) {
                        System.out.println(" ❗No Galaxy found with the provided ID ❗");
                        continue;
                    }
                    switch (choice) {
                        case 1:
                            System.out.println(planet.getNamePlanet());
                            String editPlanetName = Input.prompt("Enter a new name for the Planet: ");
                            planet.setName(editPlanetName);
                            System.out.println("A Planet has been edited successfully.");
                            break;
                        case 2:
                            System.out.println(planet.getDetail());
                            String editPlanetDetail = Input.prompt("Enter a new detail for the Galaxy: ");
                            planet.setDetail(editPlanetDetail);
                            System.out.println("A Planet has been edited successfully.");
                            break;
                        default:
                            throw new InvalidChoiceException("The Reality Stone has no power for this choice.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }


