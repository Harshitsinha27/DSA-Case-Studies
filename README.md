# DSA Case Studies

## Case Studies

### Case Study 24: Warehouse Inventory Rollback (Stack)
A warehouse records inventory changes. If the latest change needs to be cancelled, the system rolls back the most recent operation first.

**Data Structure:** Stack  
**Principle:** LIFO (Last In, First Out)

Operations:
- Add an inventory operation
- Roll back the latest operation
- View the latest operation
- Display operation history

### Case Study 25: Bank Token Management (Queue)
Customers receive tokens and are served at the counter in the same order in which they received their tokens.

**Data Structure:** Queue  
**Principle:** FIFO (First In, First Out)

Operations:
- Issue a token
- Serve the next customer
- View the next customer
- Display waiting customers

### Case Study 26: Smart Parking Lot Management (Linked List)
A parking lot maintains information about parked vehicles. Vehicles can enter and leave without requiring a fixed-size array.

**Data Structure:** Singly Linked List

Operations:
- Park a vehicle
- Remove a vehicle
- Search for a vehicle
- Display parked vehicles

## How to Run

Open the required folder in a terminal and run:

```bash
javac Main.java
java Main
```
