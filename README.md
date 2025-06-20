# Meal Ordering System - Java OOP Project

This is a console-based Meal Ordering System developed in Java using Object-Oriented Programming (OOP) principles. The system supports both **Admin** and **User** roles with dedicated dashboards and functionality.

---

## 🧑‍💻 Roles and Functionalities

### 👨‍💼 Admin

- Login using admin credentials
- Add, delete, and update menu categories
- Add, delete, and update menu items
- View all categories and items
- Access User dashboard for testing purposes

### 👤 User

- Login using user credentials
- Browse available categories and menu items
- Place an order
- View current order
- Cancel order
- Generate final bill with GST and service charges

---

## 📁 Project Structure

- `MealOrderingSystem.java` – Main class
- `Authentication.java` – Handles login
- `Person.java` – Abstract base class
- `Admin.java` – Admin operations
- `User.java` – User functionalities
- `Menu.java` – Manages categories and items
- `Category.java` – Holds list of menu items
- `MenuItem.java` – Represents individual item
- `Order.java` – Handles order details and billing

---

## ✅ Key Features

- Role-based login system (Admin / User)
- Dynamic category and item management
- Order placement and order tracking
- Final bill generation with:
  - GST (15%)
  - Service Charge (5%)
- Input validation for all entries
- OOP principles: Inheritance, Abstraction, Aggregation, Association
- Error handling for invalid input

---

## 💻 Technologies Used

| Component         | Details                          |
|------------------|----------------------------------|
| Language          | Java                             |
| Paradigm          | Object-Oriented Programming (OOP)|
| Platform          | Console (Command-line)           |
| IDE               | NetBeans / IntelliJ / VS Code    |

---

## 🔐 Login Credentials

| Role   | Username | Password |
|--------|----------|----------|
| Admin  | `admin`  | `1234`   |
| User   | `user`   | `abcd`   |

---

## ▶️ How to Run the Project

1. Clone/download the project.
2. Open the project in your preferred Java IDE.
3. Compile and run the main file: `MealOrderingSystem.java`
4. Login using the credentials above.

---

## 📌 Sample Console Output

```text
===============================
        User Dashboard        
===============================
1. Place Order
2. View Orders
3. Cancel Order
4. Generate Bill
5. Logout


Logout

---

## Developed By

**Syed Mujtaba Zaidi**  
BS Cyber Security – Riphah International University  
Focused on OOP, Java, and Secure Coding Practices  

