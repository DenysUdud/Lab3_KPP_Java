import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StoreContainer storeContainer = loadStoreContainer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a new store");
            System.out.println("2. View list of stores");
            System.out.println("3. Remove a store");
            System.out.println("4. Exit program");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter store name: ");
                    String storeName = scanner.nextLine();

                    Store newStore = new Store(storeName);
                    while (true) {
                        System.out.println("Add a product to the store (Y/N)?");
                        String addProductChoice = scanner.nextLine();
                        if (!addProductChoice.equalsIgnoreCase("Y")) {
                            break;
                        }

                        System.out.print("Product name: ");
                        String productName = scanner.nextLine();
                        System.out.print("Unit: ");
                        String unit = scanner.nextLine();
                        System.out.print("Quantity: ");
                        int quantity = scanner.nextInt();
                        System.out.print("Price: ");
                        int price = scanner.nextInt();
                        System.out.print("Arrival date (YYYY-MM-DD): ");
                        String dateStr = scanner.next();
                        Date arrivalDate = parseDate(dateStr);
                        scanner.nextLine(); // Clear the buffer
                        System.out.print("Description: ");
                        String description = scanner.nextLine();

                        Product newProduct = new Product(productName, unit, quantity, price, arrivalDate, description);
                        newStore.addProduct(newProduct);
                    }

                    storeContainer.addStore(newStore);
                    System.out.println("Store added!");
                    break;

                case 2:
                    System.out.println("List of stores:");
                    int index = 0;
                    for (Store store : storeContainer) {
                        System.out.println(index + ". " + store);
                        index++;
                    }
                    break;

                case 3:
                    System.out.print("Enter the index of the store to remove: ");
                    int storeIndexToRemove = scanner.nextInt();
                    scanner.nextLine(); // Clear the buffer
                    storeContainer.removeStore(storeIndexToRemove);
                    System.out.println("Store removed (if found).");
                    break;

                case 4:
                    saveStoreContainer(storeContainer);
                    System.out.println("Program terminated.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            System.err.println("Error parsing date. Using current date.");
            return new Date();
        }
    }

    private static StoreContainer loadStoreContainer() {
        StoreContainer container;
        File file = new File("stores.dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                container = (StoreContainer) ois.readObject();
                System.out.println("Data loaded successfully from stores.dat");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading data from stores.dat. Starting with an empty container.");
                container = new StoreContainer();
            }
        } else {
            System.out.println("stores.dat not found. Starting with an empty container.");
            container = new StoreContainer();
        }
        return container;
    }

    private static void saveStoreContainer(StoreContainer storeContainer) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stores.dat"))) {
            oos.writeObject(storeContainer);
            System.out.println("Data successfully saved to file stores.dat");
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }
}