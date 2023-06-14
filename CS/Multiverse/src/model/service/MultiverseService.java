package model.service;

import model.builder.MultiverseConcreteBuilder;
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

public class MultiverseService {
    private static final MultiverseService multiverseService = new MultiverseService();
    private static final UserView userView = UserView.getInstance();
    private static final UserService userService = UserService.getInstance();


    private MultiverseService() {
    }

    public static MultiverseService getInstance() {
        return multiverseService;
    }

    private static final List<Multiverse> MULTIVERSE_LIST = new ArrayList<>();

    static {
        try {
            List<Multiverse> dataList = FileReaderUtils.fileReadingMultiverse("src/model/data/multiverse.csv");
            MULTIVERSE_LIST.addAll(dataList);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } // khi bật lại thì nó sẽ tạo ra file MULTIVERSE_LIST và lấy dữ liệu từ file multiverse
    }

    public void displayDetailOfMultiverse() {
        do {
            try {
                for (Multiverse multiverse : MULTIVERSE_LIST) {
                    System.out.println(multiverse);
                }

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public void addMultiverse() {

        do {
            try {
                String name = Input.prompt("Enter name of Multiverse: ");
                String detail = Input.prompt("GIVE ME A DETAIL YOU HAVE: ");

                Multiverse newMultiverse = new Multiverse(name, detail);

                boolean checkExist = false;
                for (Multiverse multiverse : MULTIVERSE_LIST) {
                    if (multiverse.getName().equalsIgnoreCase(name)) {
                        checkExist = true;
                        break;
                    }
                }

                if (checkExist) {
                    System.err.println("ERROR: A Multiverse with the same name already exists.");
                    continue;
                }

                WriteFileUlti.writeFileMultiverse("C:\\CodeGym\\module-02-java\\CS\\Multiverse\\src\\model\\data\\multiverse.csv", newMultiverse);
                MULTIVERSE_LIST.add(newMultiverse);
                System.out.println("CONGRATULATIONS!!! You have discovered a new universe.");
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    public void addMultiverse(Multiverse multiverse){
        do {
            try {
                WriteFileUlti.writeFileMultiverse("C:\\CodeGym\\module-02-java\\CS\\Multiverse\\src\\model\\data\\multiverse.csv", multiverse);
                MULTIVERSE_LIST.add(multiverse);
                System.out.println("CONGRATULATIONS!!! You have discovered a new universe.");
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    public void removeMultiverse() {
        System.out.println("Current Multiverse List:");
        displayMultiverseList();

        int multiverseId = Input.choiceIntegerInput("Enter the ID of the Multiverse to remove: ");

        boolean removed = false;
        Iterator<Multiverse> iterator = MULTIVERSE_LIST.iterator();
        while (iterator.hasNext()) {
            Multiverse multiverse = iterator.next();
            if (multiverse.getId() == multiverseId) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.err.println("The Multiverse has been removed !!!");
        } else {
            System.out.println(" ❌❌❌ No Multiverse found with the provided ID ❌❌❌");
        }
    }

    private void displayMultiverseList() {
        System.out.println("Multiverse List:");
        for (Multiverse multiverse : MULTIVERSE_LIST) {
            System.out.println("ID: " + multiverse.getId() + " -->NAME: " + multiverse.getName());
        }
    }


    public void editMultiverse() {
        do {
            try {
                MULTIVERSE_LIST.forEach(multiverse -> System.out.println("ID: " + multiverse.getId() + ". " + multiverse.getName() + " | " + multiverse.getDetail()));
                System.out.println("""
                        What would you like to change by using the Reality Stone?
                        (1) Name of Multiverse 🔆
                        (2) Detail of Multiverse 📄
                        (3) Use Time Stone to return ⏳
                        """);
                int choice = Input.choiceIntegerInput("Select your choice: ");
                if (choice == 3) {
                    return;
                }
                int id = Input.choiceIntegerInput("Enter the ID of the Multiverse to edit: ");
                Multiverse multiverse = MULTIVERSE_LIST.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
                if (multiverse == null) {
                    System.out.println("❌No Multiverse found with the provided ID❌");
                    return;
                }
                switch (choice) {
                    case 1 -> {
                        System.out.println(multiverse.getName());
                        String editMultiverseName = Input.prompt("Enter a new name for the Multiverse: ");
                        multiverse.setName(editMultiverseName);
                        System.out.println("✅A Multiverse has been edited successfully✅");
                    }
                    case 2 -> {
                        System.out.println(multiverse.getDetail());
                        String editMultiverseDetail = Input.prompt("Enter a new detail for the Multiverse: ");
                        multiverse.setDetail(editMultiverseDetail);
                        System.out.println("✅A Multiverse has been edited successfully✅");
                    }
                    default -> throw new InvalidChoiceException("⛔The Reality Stone has no power for this choice⛔");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while (true);
    }

    public void displayChoosenMultiverse(int id) {
        boolean found = false;
        for (Multiverse multiverse : MULTIVERSE_LIST) {
            if (multiverse.getId() == id) {
                System.out.println("♾ Multiverse Information ♾: ");
                System.out.println("(1) ID: " + multiverse.getId());
                System.out.println("(2) Name: " + multiverse.getName());
                System.out.println("(3) Detail: " + multiverse.getDetail());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(" ❌❌❌ No Multiverse found with the provided ID ❌❌❌ ");
        }
    }
}

