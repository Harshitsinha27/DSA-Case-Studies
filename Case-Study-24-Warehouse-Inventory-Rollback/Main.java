import java.util.Scanner;

public class Main {

    static class Operation {
        String item;
        int quantity;
        String type;

        Operation(String item, int quantity, String type) {
            this.item = item;
            this.quantity = quantity;
            this.type = type;
        }

        public String toString() {
            return type + " | Item: " + item + " | Quantity: " + quantity;
        }
    }

    static class Stack {
        private Operation[] data;
        private int top;

        Stack(int size) {
            data = new Operation[size];
            top = -1;
        }

        void push(Operation operation) {
            if (top == data.length - 1) {
                System.out.println("Stack is full.");
                return;
            }
            data[++top] = operation;
            System.out.println("Operation added: " + operation);
        }

        Operation pop() {
            if (top == -1) {
                return null;
            }
            return data[top--];
        }

        Operation peek() {
            if (top == -1) {
                return null;
            }
            return data[top];
        }

        void display() {
            if (top == -1) {
                System.out.println("No inventory operations.");
                return;
            }

            System.out.println("\nInventory Operation History:");
            for (int i = top; i >= 0; i--) {
                System.out.println((top - i + 1) + ". " + data[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack(100);

        while (true) {
            System.out.println("\n--- Warehouse Inventory Rollback ---");
            System.out.println("1. Add Stock");
            System.out.println("2. Remove Stock");
            System.out.println("3. Rollback Latest Operation");
            System.out.println("4. View Latest Operation");
            System.out.println("5. Display History");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String addItem = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int addQty = sc.nextInt();
                    stack.push(new Operation(addItem, addQty, "ADD"));
                    break;

                case 2:
                    System.out.print("Enter item name: ");
                    String removeItem = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int removeQty = sc.nextInt();
                    stack.push(new Operation(removeItem, removeQty, "REMOVE"));
                    break;

                case 3:
                    Operation rollback = stack.pop();
                    if (rollback == null) {
                        System.out.println("Nothing to rollback.");
                    } else {
                        System.out.println("Rolled back: " + rollback);
                    }
                    break;

                case 4:
                    Operation latest = stack.peek();
                    System.out.println(latest == null
                            ? "No operations available."
                            : "Latest operation: " + latest);
                    break;

                case 5:
                    stack.display();
                    break;

                case 6:
                    System.out.println("Program ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
