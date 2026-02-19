package main;

public class VendingMachineTest {
    public static void main(String[] args) {
        
        System.out.println("=== INITIALIZING MACHINE (2 Items) ===");
        VendingMachine machine = new VendingMachine(2); 

        // ---------------------------------------------------------
        System.out.println("\n--- TESTING IDLE STATE ---");
        // EXPECTED FAILURES:
        machine.insertCoin(1.00);   // Fails: Needs item selected first
        machine.dispenseItem();     // Fails: Needs item and coin
        // EXPECTED SUCCESS:
        machine.selectItem();       // Success: Moves to ItemSelectedState
        
        // ---------------------------------------------------------
        System.out.println("\n--- TESTING ITEM SELECTED STATE ---");
        // EXPECTED FAILURES:
        machine.selectItem();       // Fails: Already selected
        // EXPECTED SUCCESS:
        machine.insertCoin(1.50);   // Success: Accepts coin
        
        // ---------------------------------------------------------
        System.out.println("\n--- TESTING DISPENSING STATE (Auto-Transitions) ---");
        // Note: Dispensing State happens instantly when we call dispenseItem().
        // EXPECTED SUCCESS:
        machine.dispenseItem();     // Success: Dispenses, drops inventory to 1, goes back to Idle
        
        // ---------------------------------------------------------
        System.out.println("\n--- TESTING SECOND PURCHASE (Drops inventory to 0) ---");
        machine.selectItem();       // Back in Idle, this works.
        machine.insertCoin(1.50);
        machine.dispenseItem();     // Dispenses last item. Inventory is now 0. State -> OutOfOrder
        
        // ---------------------------------------------------------
        System.out.println("\n--- TESTING OUT OF ORDER STATE ---");
        // EXPECTED FAILURES: Everything should fail now because it's empty.
        machine.selectItem();       // Fails: Out of order
        machine.insertCoin(1.00);   // Fails: Out of order
        machine.dispenseItem();     // Fails: Out of order
        
        System.out.println("\n=== END OF TESTS ===");
    }
}