package BankingSystem.Engine.model;

public class Account {
	String id;
	int bankBalance;
	boolean hasLoan;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(int bankBalance) {
		this.bankBalance = bankBalance;
	}

	public boolean isHasLoan() {
		return hasLoan;
	}

	public void setHasLoan(boolean hasLoan) {
		this.hasLoan = hasLoan;
	}

}
