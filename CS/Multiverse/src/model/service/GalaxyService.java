package model.service;

import model.entity.Galaxy;
import model.entity.Multiverse;
import model.exception.InvalidChoiceException;
import model.ulti.FileReaderUtils;
import model.ulti.Input;
import model.ulti.WriteFileUlti;
import view.multiverse_view.UserView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GalaxyService {
    private static final GalaxyService galaxyService = new GalaxyService();

    private GalaxyService() {
    }

    public static GalaxyService getInstance() {
        return galaxyService;
    }

    private static final List<Galaxy> GALAXY_LIST = new ArrayList<>();
    private static final List<Multiverse> MULTIVERSE_LIST = new ArrayList<>();

    static {
        try {
            List<Galaxy> dataList = FileReaderUtils.fileReadingGalaxy("src/model/data/galaxy.csv");
            GALAXY_LIST.addAll(dataList);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void addGalaxy() {
        do {
            try {
                String multiverseName = Input.prompt("Enter name of Multiverse: ");
                String detail = Input.prompt("GIVE ME A DETAIL OF THE GALAXY: ");
                String galaxyName = Input.prompt("Enter a name of galaxy: ");
                int multiverseId = selectMultiverseId(multiverseName, detail);

                Galaxy newGalaxy = new Galaxy(multiverseName, detail, galaxyName, multiverseId);

                boolean isGalaxyExist = false;
                for (Galaxy galaxy : GALAXY_LIST) {
                    if (galaxy.getName().equalsIgnoreCase(multiverseName)) {
                        isGalaxyExist = true;
                        break;
                    }
                }

                if (isGalaxyExist) {
                    System.err.println("ERROR: A Galaxy with the same name already exists.");
                    continue;
                }

                WriteFileUlti.writeFileMultiverse("C:\\CodeGym\\module-02-java\\CS\\Multiverse\\src\\model\\data\\galaxy.csv", newGalaxy);
                GALAXY_LIST.add(newGalaxy);
                System.out.println("CONGRATULATIONS!!! You have discovered a new Galaxy.");
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private int selectMultiverseId(String name, String detail) {
        boolean checkMultiverseExist = false;
        for (Multiverse multiverse : MULTIVERSE_LIST) {
            if (multiverse.getName().equalsIgnoreCase(name)) {
                checkMultiverseExist = true;
                return multiverse.getId();
            }
        }
        if (!checkMultiverseExist) {
            // Tạo Multiverse mới nếu không tìm thấy Multiverse với tên đã nhập
//            int newMultiverseId = generateNewMultiverseId();

            Multiverse newMultiverse = new Multiverse(name, detail);
            MultiverseService.getInstance().addMultiverse(newMultiverse);
            return newMultiverse.getId();
        }
        return 0;
    }

//    private int generateNewMultiverseId() {
//        int maxId = 0;
//        for (Multiverse multiverse : MULTIVERSE_LIST) {
//            if (multiverse.getId() > maxId) {
//                maxId = multiverse.getId();
//            }
//        }
//        return maxId + 1;
//    }

    public void removeGalaxy() {
        System.out.println("Current Galaxy List:");
        displayGalaxyList();

        int galaxyId = Input.choiceIntegerInput("Enter the ID of the Galaxy to remove: ");

        boolean removed = false; //xác định Multiverse nào đã được xóa hay ko
        Iterator<Galaxy> iterator = GALAXY_LIST.iterator();
        while (iterator.hasNext()) { //duyệt danh sách sử dụng iterator
            Galaxy galaxy = iterator.next();
            if (galaxy.getId() == galaxyId) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.err.println("The Galaxy has been removed ❗❗❗");
        } else {
            System.out.println(" ❌❌❌ No Galaxy found with the provided ID ❌❌❌");
        }
    }

    private void displayGalaxyList() {
        System.out.println("Galaxy List:");
        for (Galaxy galaxy : GALAXY_LIST) {
            System.out.println("ID: " + galaxy.getId() + " --> GALAXY NAME: " + galaxy.getGalaxyName() + " ;Multiverse ID: " + galaxy.getMultiverseId());
        }
    }

    public void editGalaxy() {
        while (true) {
            try {
                GALAXY_LIST.forEach(galaxy -> System.out.println("ID: " + galaxy.getId() + ". " + galaxy.getGalaxyName() + " | " + galaxy.getDetail()));
                System.out.println("""
                        What would you like to change by using the Reality Stone❓
                        (1) Name of Galaxy
                        (2) Detail of Galaxy
                        (3) Use Time Stone to return
                        """);
                int choice = Input.choiceIntegerInput("Select your choice: ");
                if (choice == 3) {
                    return;
                }
                int id = Input.choiceIntegerInput("Enter the ID of the Galaxy to edit: ");
                Galaxy galaxy = GALAXY_LIST.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
                if (galaxy == null) {
                    System.out.println("❌No Galaxy found with the provided ID❌");
                    continue;
                }
                switch (choice) {
                    case 1:
                        System.out.println(galaxy.getGalaxyName());
                        String editGalaxyName = Input.prompt("Enter a new name for the Galaxy: ");
                        galaxy.setGalaxyName(editGalaxyName);
                        System.out.println("✅A Galaxy has been edited successfully✅");
                        break;
                    case 2:
                        System.out.println(galaxy.getDetail());
                        String editGalaxyDetail = Input.prompt("Enter a new detail for the Galaxy: ");
                        galaxy.setDetail(editGalaxyDetail);
                        System.out.println("✅A Galaxy has been edited successfully✅");
                        break;
                    default:
                        throw new InvalidChoiceException("⛔The Reality Stone has no power for this choice⛔");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void exploreGalaxy() {
        GalaxyService.getInstance().displayDetailOfGalaxy();
        System.out.println("""
                🔸🔸🔸 Which galaxy do you want to experience ❓  🔸🔸🔸
                                        
                """);
        int id = Input.choiceIntegerInput("GIVE ME ID: ");
        GalaxyService.getInstance().displayChoosenGalaxy(id);
    }

    private void displayDetailOfGalaxy() {
        do {
            try {
                for (Galaxy galaxy : GALAXY_LIST) {
                    System.out.println(galaxy);
                }

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private void displayChoosenGalaxy(int id) {
        boolean found = false;
        for (Galaxy galaxy : GALAXY_LIST) {
            if (galaxy.getId() == id) {
                System.out.println("*** Galaxy Information *** ");
                System.out.println("(1) ID: " + galaxy.getId());
                System.out.println("(2) Multiverse name: " + galaxy.getName());
                System.out.println("(3) Galaxy Name: " + galaxy.getGalaxyName());
                System.out.println("(4) Multiverse id: " + galaxy.getMultiverseId());
                System.out.println("(5) Detail: " + galaxy.getDetail());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(" ❌❌❌ No Galaxy found with the provided ID ❌❌❌ ");
        }
    }
}



