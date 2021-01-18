package BankingSystem.Engine.worker;

import java.util.concurrent.BlockingQueue;

import BankingSystem.Engine.model.Account;

public class DisplayScore implements Runnable {
	private BlockingQueue<Account> messages;

	public DisplayScore(BlockingQueue<Account> messages) {
		this.messages = messages;
	}

	@Override
	public void run() {
		try {
			System.out.println("Waiting for the ProcessingData thread getting data...");
			Account jsonData = messages.take();
			System.out.println("Getting data to display: " + jsonData);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
