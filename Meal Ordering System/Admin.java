

package meal.ordering.system;

import java.util.Scanner;

public class Admin extends Person {
    
    private User userAsAdmin;

    public Admin(Menu menu) {
        super(menu);
        this.userAsAdmin = new User(menu);
    }

    @Override
    public void showDashboard() 
    {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            
            System.out.println("\n===============================");
            System.out.println("        Admin Dashboard        ");
            System.out.println("===============================");
            System.out.println("1. View Categories");
            System.out.println("2. Add Category");
            System.out.println("3. Delete Category");
            System.out.println("4. Add Item to Category");
            System.out.println("5. Delete Item from Category");
            System.out.println("6. Update Item");
            System.out.println("7. Manage User Orders");//User Adnim 
            System.out.println("8. Logout");
            System.out.print("Enter your choice: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    menu.displayCategories();
                    break;
                case "2":
                    menu.addCategory();
                    break;
                case "3":
                    menu.deleteCategory();
                    break;
                case "4":
                    menu.addMenuItemToCategory();
                    break;
                case "5":
                    menu.deleteMenuItemFromCategory();
                    break;
                case "6":
                    menu.updateMenuItemInCategory();
                    break;
                case "7":
                    userAsAdmin.showDashboard(); // User ki functionality
                    break;
                case "8":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
