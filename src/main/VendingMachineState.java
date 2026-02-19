package main;

public interface VendingMachineState {
    void selectItem(VendingMachine machine);
    void insertCoin(Double amount, VendingMachine machine);
    void dispenseItem(VendingMachine machine);
    void setOutOfOrder(VendingMachine machine);
}