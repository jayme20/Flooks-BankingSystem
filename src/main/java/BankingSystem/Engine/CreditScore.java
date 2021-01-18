package BankingSystem.Engine;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import BankingSystem.Engine.model.Account;
import BankingSystem.Engine.worker.DisplayScore;
import BankingSystem.Engine.worker.ProcessingData;

/**
 * Hello world!
 *
 */
public class CreditScore {
	public static void main(String[] args) {
		BlockingQueue<Account> messages = new ArrayBlockingQueue<Account>(1);

		ProcessingData processor = new ProcessingData(messages);
		DisplayScore displayer = new DisplayScore(messages);

		new Thread(processor).start();
		new Thread(displayer).start();
	}

}
