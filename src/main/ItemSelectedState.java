package main;

public class ItemSelectedState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Item already selected.");
    }

    @Override
    public void insertCoin(Double amount, VendingMachine machine) {
        machine.setBalance(machine.getBalance() + amount);
        System.out.println("Coin inserted. Current balance: $" + machine.getBalance());
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Starting dispensing process...");
        machine.setState(new DispensingState()); // Transition to Dispensing
        machine.dispenseItem(); // Automatically trigger the dispense action
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Setting machine out of order.");
        machine.setState(new OutOfOrderState());
    }
}