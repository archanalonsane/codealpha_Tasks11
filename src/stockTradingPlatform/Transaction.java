package stockTradingPlatform;

//Represents a buy/sell transaction.

public class Transaction {
	private Stock stock;
	private int quantity;
	private double price;
	private boolean isBuy;


	public Transaction(Stock stock, int quantity, double price, boolean isBuy) {
		this.stock = stock;
		this.quantity = quantity;
		this.price = price;
		this.isBuy = isBuy;
	}

	public Stock getStock() {
		return stock;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public boolean isBuy() {
		return isBuy;
	}

	public double getTotalValue() {
		return quantity * price;
	}



}
