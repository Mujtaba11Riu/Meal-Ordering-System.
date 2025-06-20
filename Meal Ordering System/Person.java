



package meal.ordering.system;

public abstract class Person {
    protected Menu menu;

    public Person(Menu menu) {
        
        this.menu = menu;
        
    }

    public abstract void showDashboard();
}
