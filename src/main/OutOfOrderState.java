package main;

public class OutOfOrderState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Machine is out of order.");
    }

    @Override
    public void insertCoin(Double amount, VendingMachine machine) {
        System.out.println("Machine is out of order. Cannot accept coins.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Machine is out of order. Cannot dispense.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is already out of order.");
    }
}