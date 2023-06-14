package view.multiverse_view;

import model.entity.Customer;
import model.entity.Scientist;
import model.exception.InvalidChoiceException;
import model.service.MultiverseService;
import model.service.UserService;
import model.ulti.Input;

public class UserView {
    private static final UserView userView = new UserView();
    private UserView() {
    }
    public static UserView getInstance() {
        return userView;
    }
    public void displayMainMenu() {
        do {
            try {
                System.out.print("""
                       *** 😘 ✨WELCOME TO THE MULTIVERSE✨ 😘 ***
                       (1) ✍ REGISTER ✍
                       (2) ➡ LOGIN ⬅
                       (3) ✌ BYE BYE ✌
                        """);
                int choice = Input.choiceIntegerInput("Enter your choice: ");
                switch (choice) {

                    case 1:
                        UserService.getInstance().register();
                        break;

                    case 2:
                        UserService.getInstance().logIn();
                        if (UserService.getCurrentUser() instanceof Customer) {
                            displayUserInterface();
                            break;
                        } else if (UserService.getCurrentUser() instanceof Scientist) {
                            displayScientistInterface();
                            break;
                        }
                        break;

                    case 3:
                        System.exit(0);

                    default:
                        throw new InvalidChoiceException("Invalid Choice");
                }
            }catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }while (true);
    }
    public void displayScientistInterface() {
        do {
            try {
                System.out.println("""
                        *** MENU ***
                        (1) Show all available Multiverse 💥💥💥
                        (2) Add/Delete/Edit Multiverse 🌟🌟🌟
                        (3) Add/Delete/Edit Galaxy 🌌🌌🌌️
                        (4) Add/Delete/Edit Planet 🌍🌍🌍️
                        (5) Create Posts ❤️️
                        (6) Log out 🚪
                        (7) End Program 🎉
                        """);
                int choice = Input.choiceIntegerInput(" Choose a number of destiny: ");
                switch (choice){

                    case 1:
                        MultiverseView.getInstance().exploreMultiverse();
                        break;

                    case 2:
                        MultiverseView.getInstance().customizeMultiverse();
                        break;

                    case 3:
                        GalaxyView.getInstance().customizeGalaxy();
                        break;

                    case 4:
                        PlanetView.getInstance().customizePlanet();
                        break;

                    case 5:
                        PostView.getInstance().customizePost();
                        break;

                    case 6:
                        displayMainMenu();
                        break;

                    case 7:
                        System.exit(0);

                    default:
                        throw new InvalidChoiceException("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Syntax Error/ Invalid input/ Format Unexpected " + e.getMessage());
            }
        } while (true);
    }
    public void displayUserInterface() {
        do {
            try {
                System.out.println("""
                        *** MENU ***
                            1. Show all available Multiverse 😺😺😺
                            2. Search Scientist 
                            3. Search Galaxy 
                            4. Search Planet 
                            5. Read a new post 📑
                            6. Log out 👋👋👋
                            7. End Program 🌋
                        """);
                int choice = Input.choiceIntegerInput("Choose a number: ");
                switch (choice) {
                    case 1:
                        MultiverseView.getInstance().exploreMultiverse();
                        break;

//                    case 2:
//                        searchScientist();
//                        break;
//                    case 3:
//                        searchGalaxy();
//                        break;
//                    case 4:
//                        searchPlanet();
//                        break;
                    case 5:
                       PostView.getInstance().showAllPost();
                       break;

                    case 6:
                        displayMainMenu();
                        break;

                    case 7:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Xảy ra lỗi hệ thống/ Invalid input/ Format Unexpected " + e.getMessage());
            }
        } while (true);
    }
}
