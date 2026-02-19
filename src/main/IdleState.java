package main;

public class IdleState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Item selected.");
        machine.setState(new ItemSelectedState()); // Transition
    }

    @Override
    public void insertCoin(Double amount, VendingMachine machine) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Please select an item and insert coins first.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Setting machine out of order.");
        machine.setState(new OutOfOrderState());
    }
}