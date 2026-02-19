package main;

public class DispensingState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Please wait, currently dispensing.");
    }

    @Override
    public void insertCoin(Double amount, VendingMachine machine) {
        System.out.println("Please wait, currently dispensing.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        // Decrease inventory and reset balance
        machine.setItemInventory(machine.getItemInventory() - 1);
        machine.setBalance(0.0);
        System.out.println("Item dispensed successfully!");

        // Automatic transition based on remaining inventory
        if (machine.getItemInventory() > 0) {
            machine.setState(new IdleState());
        } else {
            System.out.println("Machine is now out of stock.");
            machine.setState(new OutOfOrderState());
        }
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Setting machine out of order.");
        machine.setState(new OutOfOrderState());
    }
}