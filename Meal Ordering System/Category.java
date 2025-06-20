



package meal.ordering.system;
import meal.ordering.system.MenuItem;
import java.util.ArrayList;

public class Category {
    
    private String name;
    private ArrayList<MenuItem> items;

    public Category(String name) {
        
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void displayItems() {
        
        System.out.println("\n\n\n====================================");
        System.out.println("         Select From "+name     );
        System.out.println("====================================");
        
        for (int i = 0; i < items.size(); i++) {
            System.out.print((i + 1) + ". ");
            items.get(i).display();
        }
    }

    public String getName() {
        return name;
    }

    public MenuItem getItem(int index) {
        return items.get(index);
    }

    public int getItemCount() {
        return items.size();
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }
}