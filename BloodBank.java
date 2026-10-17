import java.util.Scanner;

class Blood {
    String group;
    int stock;
    Blood(String group, int stock) {
        this.group = group;
        this.stock = stock;
    }
    void display() {
        System.out.println(group + " = " + stock + " batches");
    }
}
public class BloodBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] groups = {
            "A+", "A-", "B+", "B-",
            "O+", "O-", "AB+", "AB-"};
            int[] stock = {
            5, 2, 6, 1,
            7, 3, 4, 1
        };
        Blood[] blood = new Blood[8];
        for (int i = 0; i < 8; i++) {
            blood[i] = new Blood(groups[i], stock[i]);
        }
        int choice;
        do {
            System.out.println("--- BLOOD BANK MANAGEMENT SYSTEM ---");
            System.out.println("1. Donor");
            System.out.println("2. Recipient");
            System.out.println("3. Emergency");
            System.out.println("4. View Stock");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:

                    System.out.print("Enter age: ");
                    int age = sc.nextInt();

                    System.out.println("\n1. A+  2. A-  3. B+  4. B-");
                    System.out.println("5. O+  6. O-  7. AB+  8. AB-");

                    System.out.print("Enter blood group number: ");
                    int group = sc.nextInt() - 1;

                    
                    System.out.print("Are you diabetic? (yes/no): ");
                    String diabetic = sc.next();

                    System.out.print("Recent tattoo/wound? (yes/no): ");
                    String tattoo = sc.next();

                    if (group < 0 || group >= 8) {

                        System.out.println("Wrong blood group.");

                    } else if (age < 18) {

                        System.out.println("Age must be 18 or above.");

                    } else if (diabetic.equalsIgnoreCase("yes")) {

                        System.out.println(
                            "Cannot donate due to health condition."
                        );

                    } else if (tattoo.equalsIgnoreCase("yes")) {

                        System.out.println(
                            "Cannot donate due to tattoo/wound."
                        );

                    } else {

                        stock[group]++;

                        
                        blood[group].stock = stock[group];

                        System.out.println(
                            "Blood donated successfully!"
                        );
                    }

                    break;

                
                case 2:

                    System.out.println("1. A+  2. A-  3. B+  4. B-");
                    System.out.println("5. O+  6. O-  7. AB+  8. AB-");

                    System.out.print("Enter blood group number: ");
                    group = sc.nextInt() - 1;

                    System.out.print("Enter batches needed: ");
                    int need = sc.nextInt();

                    if (group < 0 || group >= 8) {

                        System.out.println("Wrong blood group.");

                    } else if (need <= 0) {

                        System.out.println("Enter a valid number.");

                    } else if (need <= stock[group]) {

                        stock[group] = stock[group] - need;

                        
                        blood[group].stock = stock[group];

                        System.out.println(
                            "Blood given successfully!"
                        );

                    } else {

                        System.out.println(
                            "Not enough blood. Try Emergency."
                        );
                    }

                    break;

                
                case 3:

                    System.out.println("1. A+  2. A-  3. B+  4. B-");
                    System.out.println("5. O+  6. O-  7. AB+  8. AB-");

                    System.out.print("Enter blood group number: ");
                    group = sc.nextInt() - 1;

                    System.out.print("Enter batches needed: ");
                    need = sc.nextInt();

                    if (group < 0 || group >= 8) {

                        System.out.println("Wrong blood group.");

                    } else if (need <= 0) {

                        System.out.println("Enter a valid number.");

                    } else if (need <= stock[group]) {

                        stock[group] = stock[group] - need;

                        // Update object stock
                        blood[group].stock = stock[group];

                        System.out.println(
                            "Emergency blood given!"
                        );

                    } else {

                        System.out.println("Not enough blood.");
                        System.out.println(
                            "Contacting other blood banks."
                        );
                    }

                    break;

                // VIEW STOCK
                case 4:

                    System.out.println("--- AVAILABLE BLOOD ---");

                    for (int i = 0; i < 8; i++) {                       
                        blood[i].display();
                    }

                    break;
                case 5:

                    System.out.println(
                        "Thank you for using Blood Bank Management System!"
                    );

                    break;

                default:
                    System.out.println("Wrong choice.");
            }
        } while (choice != 5);
    }
}