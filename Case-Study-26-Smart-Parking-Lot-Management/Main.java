import java.util.Scanner;

public class Main {

    static class Vehicle {
        String number;
        String type;

        Vehicle(String number, String type) {
            this.number = number;
            this.type = type;
        }

        public String toString() {
            return "Vehicle No: " + number + " | Type: " + type;
        }
    }

    static class Node {
        Vehicle vehicle;
        Node next;

        Node(Vehicle vehicle) {
            this.vehicle = vehicle;
        }
    }

    static class ParkingList {
        private Node head;
        private int count;
        private final int capacity;

        ParkingList(int capacity) {
            this.capacity = capacity;
        }

        void park(Vehicle vehicle) {
            if (count == capacity) {
                System.out.println("Parking lot is full.");
                return;
            }

            Node newNode = new Node(vehicle);

            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }

            count++;
            System.out.println("Vehicle parked successfully: " + vehicle);
        }

        void remove(String number) {
            if (head == null) {
                System.out.println("Parking lot is empty.");
                return;
            }

            if (head.vehicle.number.equalsIgnoreCase(number)) {
                head = head.next;
                count--;
                System.out.println("Vehicle removed: " + number);
                return;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.vehicle.number.equalsIgnoreCase(number)) {
                    current.next = current.next.next;
                    count--;
                    System.out.println("Vehicle removed: " + number);
                    return;
                }
                current = current.next;
            }

            System.out.println("Vehicle not found.");
        }

        void search(String number) {
            Node current = head;

            while (current != null) {
                if (current.vehicle.number.equalsIgnoreCase(number)) {
                    System.out.println("Vehicle found: " + current.vehicle);
                    return;
                }
                current = current.next;
            }

            System.out.println("Vehicle not found.");
        }

        void display() {
            if (head == null) {
                System.out.println("Parking lot is empty.");
                return;
            }

            System.out.println("\nParked Vehicles:");
            Node current = head;
            int slot = 1;

            while (current != null) {
                System.out.println("Slot " + slot + " -> " + current.vehicle);
                current = current.next;
                slot++;
            }

            System.out.println("Occupied slots: " + count + "/" + capacity);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingList parkingLot = new ParkingList(10);

        while (true) {
            System.out.println("\n--- Smart Parking Lot Management ---");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Display Parking Lot");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle number: ");
                    String number = sc.nextLine();
                    System.out.print("Enter vehicle type (Car/Bike/Other): ");
                    String type = sc.nextLine();

                    parkingLot.park(new Vehicle(number, type));
                    break;

                case 2:
                    System.out.print("Enter vehicle number to remove: ");
                    String removeNumber = sc.nextLine();
                    parkingLot.remove(removeNumber);
                    break;

                case 3:
                    System.out.print("Enter vehicle number to search: ");
                    String searchNumber = sc.nextLine();
                    parkingLot.search(searchNumber);
                    break;

                case 4:
                    parkingLot.display();
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
