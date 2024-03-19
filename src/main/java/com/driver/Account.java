package com.driver;

public class Account {
	private String accountName;
    public int balance = 1000;

    public Account(String name) {
        this.accountName = name;
    }

    public void sendMoney(Account receiver, int amount) {
    	// your code goes here
        synchronized (this) {
            synchronized (receiver) {
                if (this.balance >= amount) {
                    this.balance -= amount;
                    receiver.receiveMoney(amount);
                    System.out.println(this.accountName + " sent " + amount + " to " + receiver.accountName);
                } else {
                    System.out.println("Insufficient balance in " + this.accountName + " to send " + amount);
                }
            }
        }
    }

    public void receiveMoney(int amount) {
        synchronized (this) {
        	// your code goes here
            this.balance += amount;
            System.out.println(this.accountName + " received " + amount);
        }
    }
}
