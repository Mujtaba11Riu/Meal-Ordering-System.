



package meal.ordering.system;

import java.util.Scanner;

public class User extends Person {
    private Order order;

    public User(Menu menu) {
        
        super(menu);
        this.order = new Order();
    }

    @Override
    public void showDashboard() {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===============================");
            System.out.println("         User Dashboard        ");
            System.out.println("===============================");
            System.out.println("1. Place Order");
            System.out.println("2. View Orders");
            System.out.println("3. Cancel Order");
            System.out.println("4. Generate Bill");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            String choice = input.nextLine();

            switch (choice) {
                
                case "1":
                    
                   MenuItem selected = menu.selectItem(); //item ko store karna ka laia 
                   
                   if (selected != null) // koi valid item ha ya ni 
                   {
                   System.out.print("Enter quantity for " + selected.getName() + ": ");

                     if (input.hasNextInt()) //number enter kia ha ya ni 
                     {
                     int qty = input.nextInt();//qnty store karna ka laia variable me 
                     input.nextLine(); // consume newline

                      if (qty <= 0) //check validation 
                      {
                        System.out.println("Invalid quantity! Please enter a value greater than 0.");
                     } 
                      
                  else 
                 {
                  order.addItem(selected, qty);//item ar quantity store
                  System.out.println(selected.getName() + " x" + qty + " added to your order.");
                  }
                } 
                     
                     else 
                     {
                  System.out.println(" Invalid input! Enter numbers only.");
                    input.nextLine(); // consume the characters
                    
        }
    }
                    break;

                case "2":
                    order.viewOrder();
                    break;

                case "3":
                    order.cancelOrder();
                    break;

                case "4":
                    order.generateBill();
                    break;

                case "5":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
