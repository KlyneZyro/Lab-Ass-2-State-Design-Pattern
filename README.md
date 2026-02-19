# Lab-Ass-2-State-Design-Pattern

## Problem
A vending machine needs to manage different states, including **"Idle"**, **"ItemSelected"**, **"Dispensing"**, and **"OutOfOrder"**. Each state has specific rules and restrictions regarding allowed operations, and the vending machine has associated attributes like item inventory and balance.

## Requirements

### State Logic Summary
| State | Allowed Operations | Transitions To |
| :--- | :--- | :--- |
| **Idle** | Item Selection | ItemSelected |
| **ItemSelected** | Insert Coins, Dispense Item | Dispensing |
| **Dispensing** | None | Idle (Automatic) |
| **OutOfOrder** | None | None |

### Specific Rules
* **Idle State:** Allow item selection. Disallow dispensing items and inserting coins.
* **ItemSelected State:** Allow inserting coins and dispensing items. Disallow item selection.
* **Dispensing State:** Allow no operations. Automatically transition back to the "Idle" state after dispensing is complete.
* **OutOfOrder State:** Disallow all operations.

---

## Current System
The system currently relies on conditional statements within the `VendingMachine` class to check the machine state and determine valid actions. This approach becomes cumbersome and error-prone as the number of states and their associated logic grows.

---

## Implementation Goal: State Pattern
Implement the State Pattern to improve code maintainability and flexibility.

### 1. Define VendingMachine States
Create separate classes representing different machine states:
* `IdleState`
* `ItemSelectedState`
* `DispensingState`
* `OutOfOrderState`

### 2. Implement State Interface
Define an interface `VendingMachineState` with methods for common actions:
* `selectItem()`
* `insertCoin()`
* `dispenseItem()`
* `setOutOfOrder()`

### 3. Implement State Behaviors
Each concrete state class implements the `VendingMachineState` interface, providing specific behavior for its respective state. For example, the `IdleState` class would allow item selection, while the `OutOfOrderState` wouldn't allow any operations.

### 4. Update VendingMachine Class
* **Attributes:** Include item inventory and balance.
* **Refactor:** Remove state-specific logic from the `VendingMachine` class.
* **State Reference:** Introduce a reference to the current `VendingMachineState` object.
* **Delegation:** Delegate actions like `selectItem`, `insertCoin`, `dispenseItem`, and `setOutOfOrder` to the current state object through its corresponding methods.

  
<img width="6221" height="2951" alt="State Design Pattern UML" src="https://github.com/user-attachments/assets/6309770d-6524-4d60-b2c1-410450943336" />

