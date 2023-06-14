

import java.util.*;

public class ProductManager {
    private static final List<Product> lists;
    private static final Scanner sc= new Scanner(System.in);
    static {
        lists =new ArrayList<Product>();
        addProduct("UNIVERSE 616",5000);
        addProduct("UNIVERSE 555",1000);
    }
    public static void addProduct(String name,long price){
        lists.add(new Product(name,price));
    }
    public static void editProduct(long id,String name,long price){
        for(Product product : lists) {
            if(product.getId() == id) {
                product.setName(name);
                product.setPrice(price);
            }
        }
    }
    public static void deleteProduct(long id) {
//        for(Product product : lists) {
//            if(product.getId() == id) {
//                lists.remove(product);
//                break;
//            }
//        }
        for(int i=0;i<lists.size();i++) {
            if(lists.get(i).getId() == id) {
                lists.remove(i);
            }
        }
    }
    public static void displayProduct() {
        for (Product product : lists) {
            System.out.println(product.toString());
        }
    }
    public static void searchProduct(String name){
        for (Product product : lists) {
            if(Objects.equals(product.getName(), name)) {
                System.out.println(product);
                return;
            }
        } System.out.println("CANNOT FIND UNIVERSE");
    }
    public static void setCurrentProductByPrice(int choice) {
        switch (choice) {
            case 1:
                lists.sort(Comparator.comparingLong(Product::getPrice));
                for (Product product : lists) {
                    System.out.println(product);
                }
                break;
            case 2:
                lists.sort(Comparator.comparingLong(Product::getPrice).reversed());
                for (Product product : lists) {
                    System.out.println(product);
                }
                break;
        }
    }
    public static void nextRunProduct() {
        System.out.print("1. BACK TO MENU\n" +  "2. END\n" + "ENTER YOUR CHOICE: ");

        int newChoice = Integer.parseInt(sc.nextLine());
        switch (newChoice) {
            case 1: return;
            case 2: System.exit(0);
        }
    }
    public static void runProductProgram() {
        do {
            System.out.print("Menu:\n" +
                            "                1. ADD NEW UNIVERSE\n" +
                            "                2. DELETE\n" +
                            "                3. FIX CURRENT UNIVERSE\n" +
                            "                4. SHOW UNIVERSE LIST\n" +
                            "                5. FIND UNIVERSE\n" +
                            "                6. SORT THE UNIVERSE BY PRICE\n" +
                            "                7.CLOSED\n" +
                            "                Press the shortcut to manipulate the application:  "

                );
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("NAME OF UNIVERSE: ");
                    String addName = sc.nextLine();
                    System.out.println("PRICE: ");
                    long price = Long.parseLong(sc.nextLine());
                    addProduct(addName,price);
                    System.out.println("ADDED COMPLETE");
                    nextRunProduct();
                    break;
                case 2:
                    displayProduct();
                    System.out.println("Enter the miner ID you want to delete: ");
                    long deleteID = Long.parseLong(sc.nextLine());
                    deleteProduct(deleteID);
                    System.out.println("UNIVERSE ID " + deleteID + " removed from the list");
                    displayProduct();
                    nextRunProduct();
                    break;
                case 3:
                    displayProduct();
                    System.out.println("Enter the miner ID you want to fix: ");
                    long id = Long.parseLong(sc.nextLine());
                    System.out.println("Enter the name of the UNIVERSE you want to edit: ");
                    String newName = sc.nextLine();
                    System.out.println("Update prices for UNIVERSE");
                    long newPrice = Long.parseLong(sc.nextLine());
                    editProduct(id,newName,newPrice);
                    System.out.println("NEW DESTINY FOR YOUR UNIVERSE");
                    displayProduct();
                    nextRunProduct();
                    break;
                case 4:
                    displayProduct();
                    nextRunProduct();
                    break;
                case 5:
                    System.out.println("Enter the name of UNIVERSE you want to travel ");
                    String name = sc.nextLine();
                    searchProduct(name);
                    nextRunProduct();
                    break;
                case 6:
                    System.out.println("How would you like to arrange your UNIVERSE?\n" +
                                    "                            1. FROM STRONGEST TO WEAKEST\n" +
                                    "                            2. FROM WEAKEST TO STRONGEST "

                            );
                    int arrangeChoice = Integer.parseInt(sc.nextLine());
                    setCurrentProductByPrice(arrangeChoice);
                    nextRunProduct();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);
    }
}
