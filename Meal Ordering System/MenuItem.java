

package meal.ordering.system;

public class MenuItem 
{
    private String name;
    private String description;
    private double price;

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void display() 
    {
        System.out.println(name + " - " + description + " (RS:" + price + ")");
    }

    public String getName()
    {
        return name;
    }

    public String getDescription() 
    {
        return description;
    }

    public double getPrice() 
    {
        return price;
    }

    public void updateDetails(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
