package BankingSystem.Engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import BankingSystem.Engine.model.Borrower;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream inputStream = new FileInputStream(new File(".\\jsonFiles\\borrowers.json"));
			TypeReference<List<Borrower>> typeReference = new TypeReference<List<Borrower>>() {
			};
			List<Borrower> borrowers = mapper.readValue(inputStream, typeReference);
			for (Borrower b : borrowers) {
				System.out.println("id is" + b.getId() + "credit score is " + b.getScore());
			}
			Borrower borrower = new Borrower();
			borrower.setId();
			borrower.setScore(7);
			mapper.writeValue(new File(), borrower);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
