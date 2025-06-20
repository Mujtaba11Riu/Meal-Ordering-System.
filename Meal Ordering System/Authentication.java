



package meal.ordering.system;

import java.util.Scanner;

public class Authentication {
    
    private String username;
    private String password;
    private boolean isLoggedIn;
    private String role;

    private Menu sharedMenu = new Menu();  

    public Authentication() 
    {
        this.isLoggedIn = false;
    }

    
    public void start() 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\n============================================");
        System.out.println("        Wellcome to Meal Ordering System "     );
        System.out.println("============================================");
        
        while (!isLoggedIn) {
            
            System.out.print("Choose Your Role  Admin Or User? ");
            role = input.nextLine();

            if (role.equalsIgnoreCase("Admin")) 
            {
                username = "admin";
                password = "1234";
                
            } 
            else if (role.equalsIgnoreCase("User")) {
                
                username = "user";
                password = "abcd";
            }
            else {
                System.out.println("Invalid role. Please type 'Admin' or 'User'.\n");
                System.out.println("Press any key to continue to login...");
                input.nextLine();
                continue;
            }

            System.out.print("Enter Username: ");
            String enteredUsername = input.nextLine();

            System.out.print("Enter Password: ");
            String enteredPassword = input.nextLine();

            if (login(enteredUsername, enteredPassword)) {
                
                Person person;
                
                if (role.equalsIgnoreCase("Admin")) {
                    person = new Admin(sharedMenu);  // Admin class extends Person
                }
                else {
                    person = new User(sharedMenu);   // User class extends Person
                }
                
                person.showDashboard();

                System.out.println("Press any key to Log out...");
                input.nextLine();
                logout();
                
                
            } else 
            
            {
                System.out.println("Login failed! Invalid credentials.\n");
                System.out.println("Press any key to continue to login...");
                input.nextLine();
            }
        }

       
    }

    
         private boolean login(String enteredUsername, String enteredPassword) {
           if (this.username.equals(enteredUsername) && this.password.equals(enteredPassword)) {
              isLoggedIn = true;
              System.out.println(role + " login successful.\n");
              return true;
        } 
        else {
            return false;
        }
    }

    
    private void logout() {
        if (isLoggedIn) {
            isLoggedIn = false;
            System.out.println(role + " logged out.");
        } else {
            System.out.println("You are not logged in.");
        }
    }
}
