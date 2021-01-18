package BankingSystem.Engine.worker;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import BankingSystem.Engine.model.Account;

public class ProcessingData implements Runnable {

	private Account account;
	private BlockingQueue<Account> messages;

	public ProcessingData(BlockingQueue<Account> messages) {
		this.messages = messages;
	}

	@Override
	public void run() {
		Account jsonData;
		try {
			jsonData = ProcessData();
			messages.put(jsonData);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void assignScore(int bankBalance, boolean hasLoan) {
		boolean hasLoan = true;
		if (account.getBankBalance() < 2000 && hasLoan) {
			System.out.println("score is" + 1);
		} else if (account.getBankBalance() >= 5000 && hasLoan) {
			System.out.println("score is" + 3);
		} else {
			System.out.println("score is" + 5);
		}
	}

	private Account ProcessData() throws IOException, ParseException, InterruptedException {
		Thread.sleep(5000);

		JSONParser jsonData = new JSONParser();
		FileReader reader = new FileReader(".\\jsonFiles\\Clients.json");

		Object obj = jsonData.parse(reader);

		JSONObject clientjsonob = (JSONObject) obj;

		JSONArray array = (JSONArray) clientjsonob.get("clients");

		for (int i = 0; i < array.size(); i++) {

			JSONObject clients = (JSONObject) array.get(i);

			int id = (int) clients.get("id");
			int bankBalance = (int) clients.get("bankBalance");
			boolean hasLoan = (boolean) clients.get("hasLoan");

		}
	}

}
