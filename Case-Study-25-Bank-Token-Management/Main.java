import java.util.Scanner;

public class Main {

    static class Customer {
        int token;
        String name;
        String service;

        Customer(int token, String name, String service) {
            this.token = token;
            this.name = name;
            this.service = service;
        }

        public String toString() {
            return "Token: " + token + " | Name: " + name + " | Service: " + service;
        }
    }

    static class Queue {
        private Customer[] data;
        private int front;
        private int rear;

        Queue(int size) {
            data = new Customer[size];
            front = 0;
            rear = -1;
        }

        boolean isEmpty() {
            return rear < front;
        }

        boolean isFull() {
            return rear == data.length - 1;
        }

        void enqueue(Customer customer) {
            if (isFull()) {
                System.out.println("Queue is full.");
                return;
            }
            data[++rear] = customer;
            System.out.println("Token issued: " + customer);
        }

        Customer dequeue() {
            if (isEmpty()) {
                return null;
            }

            Customer customer = data[front];
            data[front] = null;
            front++;
            return customer;
        }

        Customer peek() {
            if (isEmpty()) {
                return null;
            }
            return data[front];
        }

        void display() {
            if (isEmpty()) {
                System.out.println("No customers are waiting.");
                return;
            }

            System.out.println("\nCustomers Waiting:");
            for (int i = front; i <= rear; i++) {
                System.out.println(data[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue(100);
        int nextToken = 1;

        while (true) {
            System.out.println("\n--- Bank Token Management ---");
            System.out.println("1. Issue Token");
            System.out.println("2. Serve Customer");
            System.out.println("3. View Next Customer");
            System.out.println("4. Display Waiting Customers");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter service required: ");
                    String service = sc.nextLine();

                    queue.enqueue(new Customer(nextToken++, name, service));
                    break;

                case 2:
                    Customer served = queue.dequeue();
                    if (served == null) {
                        System.out.println("No customer is waiting.");
                    } else {
                        System.out.println("Serving customer: " + served);
                    }
                    break;

                case 3:
                    Customer next = queue.peek();
                    System.out.println(next == null
                            ? "No customer is waiting."
                            : "Next customer: " + next);
                    break;

                case 4:
                    queue.display();
                    break;

                case 5:
                    System.out.println("Program ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
