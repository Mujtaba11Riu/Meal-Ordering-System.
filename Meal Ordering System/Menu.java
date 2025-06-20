

package meal.ordering.system;
import meal.ordering.system.Category;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu 
{
    private ArrayList<Category> categories;

    public Menu() 
    {
        categories = new ArrayList<>();
        loadDefaultMenu();
    }

    
    
   private void loadDefaultMenu() //function Hardcode Menu ka Laia
   {
    
    Category starters = new Category("Starters");
    
    //stater
    starters.addItem(new MenuItem("Mantu/Dumpling", "Afghani Style ", 1200));
    starters.addItem(new MenuItem("Fresh Salad", "Onion,Tamato,Cocumber", 400));
    starters.addItem(new MenuItem("Fatuch Salad", "Salad With Fruits", 650));
    starters.addItem(new MenuItem("Russian Salad", "Made by Russian recipe ", 550));

    //  Main Course
    Category mainCourse = new Category("Main Course");
    mainCourse.addItem(new MenuItem("Chicken Karahi", "Pure Shinwari Recipe", 1500));
    mainCourse.addItem(new MenuItem("Chicken Handi", "Made With Boneless Chicken ", 1800));
    mainCourse.addItem(new MenuItem("Dumbha Karahi", "Made With Special Shinwari Recipe ", 4400));
    mainCourse.addItem(new MenuItem("Mutton Karahi", "Made With  Shinwari Recipe", 4800));

    // Naan
    Category naans = new Category("Naans");
    naans.addItem(new MenuItem("Afg Double Naan", "Special Afghani Double naan", 230));
    naans.addItem(new MenuItem("Afg Single Naan", "Afghani Speciall Naan ", 110));
    naans.addItem(new MenuItem("Paraki Roti", "Traditional Punjabi Roti (Patir)", 80));
    naans.addItem(new MenuItem("Khanbiri Naan", "Traditional Punjabi Roti(khanber)", 40));

    //  Cold Drinks
    Category drinks = new Category("Cold Drinks");
    drinks.addItem(new MenuItem("1.5L Pepsi", "Full ", 230));
    drinks.addItem(new MenuItem("500ml Pepsi", "Small", 110));
    drinks.addItem(new MenuItem("250ml Can Pepsi", "Regular", 190));
    drinks.addItem(new MenuItem("200ml Pepsi", "Rehular", 80));

    // Add all to main list
    
    categories.add(starters);
    categories.add(mainCourse);
    categories.add(naans);
    categories.add(drinks);
}

   

    public MenuItem selectItem() {  // Function  Item Selecte Karna ka laia
        
        Scanner input = new Scanner(System.in);

        System.out.println("\n====================================");
        System.out.println("         Select From Categories ");
        System.out.println("====================================");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }

       System.out.print("Enter your choice: ");
       
        if (!input.hasNextInt())
        {
         System.out.println(" Invalid input! Please enter a number.");
         input.nextLine(); // clear invalid input
             return null;
        }
        int catChoice = input.nextInt();
        input.nextLine();


        if (catChoice < 1 || catChoice > categories.size()) {
            System.out.println("Invalid choice.");
            return null;
        }

        Category selectedCategory = categories.get(catChoice - 1);
        selectedCategory.displayItems();

        System.out.print("Select item number to order: ");
        if (!input.hasNextInt()) 
        {
            System.out.println("Invalid input! Please enter a valid item number.");
            input.nextLine();
            return null;
            }
        
        
        int itemChoice = input.nextInt();
        input.nextLine();

        
        if (itemChoice < 1 || itemChoice > selectedCategory.getItemCount()) {
            System.out.println("Invalid item selection.");
            return null;
        }

        return selectedCategory.getItem(itemChoice - 1);
    }

    
    
    public void displayCategories() //Function 
    {
        System.out.println("\n\n\n====================================");
        System.out.println("         Select From Categories "     );
        System.out.println("====================================");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }
    }

    
    
    public void addCategory() //Function 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n\n====================================");
        System.out.println("         ADD Categories "     );
        System.out.println("====================================");
        System.out.print("Enter new category name: ");
        String name = input.nextLine();
        categories.add(new Category(name));
        System.out.println("Category added successfully.");
    }

    
    
    public void deleteCategory() //Function 
    {
        displayCategories();
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n\n====================================");
        System.out.println("         Delete Categories "     );
        System.out.println("====================================");
        
        System.out.print("Enter category number to delete: ");

        if (!input.hasNextInt()) {
        System.out.println(" Invalid input! Please enter a valid number.");
        input.nextLine(); 
        return;
            }

        int choice = input.nextInt();
        input.nextLine();

        
        if (choice >= 1 && choice <= categories.size()) {
            categories.remove(choice - 1);
            System.out.println("Category deleted successfully.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    
    
    public void addMenuItemToCategory() //Function 
    {
        displayCategories();
        Scanner input = new Scanner(System.in);
        System.out.print("Select category number: ");
        if (!input.hasNextInt()) {
          System.out.println(" Invalid input! Please enter a number.");
          input.nextLine();
          return;
            }
        int catIndex = input.nextInt();
        input.nextLine();

        Category selected = categories.get(catIndex - 1);

        System.out.print("Enter item name: ");
        String name = input.nextLine();
        System.out.print("Enter item description: ");
        String desc = input.nextLine();
        System.out.print("Enter price: ");
        double price = input.nextDouble();

        selected.addItem(new MenuItem(name, desc, price));
        System.out.println("Item added.");
    }

    
    
    public void deleteMenuItemFromCategory() //Function 
    {
        displayCategories();
        Scanner input = new Scanner(System.in);
        System.out.print("Select category number: ");
         if (!input.hasNextInt()) {
          System.out.println(" Invalid input! Please enter a number.");
          input.nextLine();
          return;
            }
        int catIndex = input.nextInt();
        input.nextLine();

        Category selected = categories.get(catIndex - 1);
        selected.displayItems();

        System.out.print("Enter item number to delete: ");
        int itemIndex = input.nextInt();

        if (itemIndex < 1 || itemIndex > selected.getItemCount()) {
            System.out.println("Invalid item.");
            return;
        }

        selected.getItems().remove(itemIndex - 1);
        System.out.println("Item deleted.");
    }

    
    public void updateMenuItemInCategory()//Function 
    {
        displayCategories();
        Scanner input = new Scanner(System.in);
        System.out.print("Select category number: ");
         if (!input.hasNextInt()) {
          System.out.println(" Invalid input! Please enter a number.");
          input.nextLine();
          return;
            }
        int catIndex = input.nextInt();
        input.nextLine();

        Category selected = categories.get(catIndex - 1);
        selected.displayItems();

        System.out.print("Enter item number to update: ");
        int itemIndex = input.nextInt();
        input.nextLine();

        MenuItem item = selected.getItem(itemIndex - 1);

        System.out.print("New name: ");
        String name = input.nextLine();
        System.out.print("New description: ");
        String desc = input.nextLine();
        System.out.print("New price: ");
        double price = input.nextDouble();

        item.updateDetails(name, desc, price);
        System.out.println("Item updated.");
    }
} 
