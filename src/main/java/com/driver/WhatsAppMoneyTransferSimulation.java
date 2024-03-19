package com.driver;

public class WhatsAppMoneyTransferSimulation {
	   public static void main(String[] args) {
	        Account account1 = new Account("User1");
	        Account account2 = new Account("User2");

	        Thread thread1 = new Thread(() -> {
	            account1.sendMoney(account2, 100);
	        });

	        Thread thread2 = new Thread(() -> {
	            account2.sendMoney(account1, 150);
	        });

	        thread1.start();
	        thread2.start();
	    }
}
