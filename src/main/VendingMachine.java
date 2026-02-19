package main;

public class VendingMachine {
    private int itemInventory;
    private Double balance;
    private VendingMachineState currentState;

    public VendingMachine(int itemInventory) {
        this.itemInventory = itemInventory;
        this.balance = 0.0;
        
        if (itemInventory > 0) {
            this.currentState = new IdleState();
        } else {
            this.currentState = new OutOfOrderState();
        }
    }

    // Getters and Setters
    public void setState(VendingMachineState state) { this.currentState = state; }
    public VendingMachineState getState() { return currentState; }
    
    public int getItemInventory() { return itemInventory; }
    public void setItemInventory(int itemInventory) { this.itemInventory = itemInventory; }
    
    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }

    // Delegated Methods
    public void selectItem() { currentState.selectItem(this); }
    public void insertCoin(Double amount) { currentState.insertCoin(amount, this); }
    public void dispenseItem() { currentState.dispenseItem(this); }
    public void setOutOfOrder() { currentState.setOutOfOrder(this); }
}