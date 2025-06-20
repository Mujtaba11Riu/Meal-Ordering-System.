

package meal.ordering.system;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {

  
    private class OrderItem 
    {
        private MenuItem item;
        private int quantity;

        public OrderItem(MenuItem item, int quantity)
        {
            this.item = item;
            this.quantity = quantity;
        }

        public void display() 
        {
            System.out.println("- " + item.getName() + " x" + quantity + " Rs. " + (item.getPrice() * quantity));
        }

        public double getTotalPrice() 
        {
            return item.getPrice() * quantity;
        }
    }

    
    
    
    private ArrayList<OrderItem> orderItems;
    private String status;

    
    public Order() 
    {
        this.orderItems = new ArrayList<>();
        this.status = "Pending";
    }

    
    
    public void addItem(MenuItem item, int quantity) 
    {
        orderItems.add(new OrderItem(item, quantity));
    }

    
    //  View current order
    public void viewOrder() 
    {
        System.out.println("\n\n\n===============================");
        System.out.println("         Your Order    ");
        System.out.println("===============================");
        if (orderItems.isEmpty()) {
            System.out.println("No items in order.");
            return;
        }

        double subtotal = 0;
        for (OrderItem orderItem : orderItems) {
            orderItem.display();
            subtotal += orderItem.getTotalPrice();
        }

        System.out.println("Subtotal: Rs. " + subtotal);
    }

    
    
    public void cancelOrder()
    {
        if (orderItems.isEmpty()) {
            System.out.println("You have no items in your order to cancel.");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("\n\n\n====================================");
        System.out.println("         Order Cancelling "     );
        System.out.println("====================================");
        System.out.print("Are you sure you want to cancel your order? (y/n): ");
        String confirm = input.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            orderItems.clear();
            status = "Cancelled";
            System.out.println("Order has been cancelled.");
        } else {
            System.out.println("Order not cancelled.");
        }

        System.out.println("Press any key to go back to main menu...");
        input.nextLine();
    }

    
    
    public void generateBill() 
    {
        if (orderItems.isEmpty()) 
        {
            System.out.println("No items to bill.");
            return;
        }

        double subtotal = 0;
        for (OrderItem orderItem : orderItems) 
        {
            subtotal += orderItem.getTotalPrice();
        }

        double gst = subtotal * 0.15;
        double serviceCharge = subtotal * 0.05;
        double total = subtotal + gst + serviceCharge;

        System.out.println("\n\n\n===============================");
        System.out.println("         Finall Bill    ");
        System.out.println("===============================");
        System.out.println("\n\nSubtotal: Rs: " + subtotal);
        System.out.println("GST (15%): Rs: " + gst);
        System.out.println("Service Charge (5%): Rs: " + serviceCharge);
        System.out.println("Total Payable: Rs: " + total);

        System.out.println("\n\n\n============================================");
        System.out.println("         Thank you for shopping with us!    ");
        System.out.println("============================================");
        System.out.println("Press any key to go back to main menu...");
        new Scanner(System.in).nextLine();
        
        orderItems.clear();
    }

    public String getStatus()
    {
        return status;
    }
}
