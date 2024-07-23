package stockTradingPlatform;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

//Manages the user's stock holdings and tracks performance.

public class Portfolio {
	private Map<String, Integer> holdings;
	private List<Transaction> transactions;
	
	public Portfolio() {
		holdings = new HashMap<>();
		transactions = new ArrayList<>();
	}
	
	public void buyStock(Stock stock, int quantity) {
		holdings.put(stock.getSymbol(), holdings.getOrDefault(stock.getSymbol(), 0)+ quantity);
		transactions.add(new Transaction(stock, quantity, stock.getPrice(), true));
		
	}
	
	public void sellStock(Stock stock, int quantity) {
		if(holdings.getOrDefault(stock.getSymbol(), 0) >=quantity) {
			holdings.put(stock.getSymbol(), holdings.get(stock.getSymbol())-quantity);
			transactions.add(new Transaction(stock, quantity, stock.getPrice(), false));
			
		}
		else {
			System.out.println("Not enough stock to sell..");
		}
		
	}
	
	public double getPortfolioValue(Market market) {
		double totalVal = 0.0;
		for(Map.Entry<String, Integer> entry : holdings.entrySet()) {
			Stock stock = market.getStock(entry.getKey());
			totalVal += entry.getValue()*stock.getPrice();
		}
		
		return totalVal;
		
	}
	
	public void printPortfolio(Market market) {
		System.out.println("Current Portfolio: ");
		for(Map.Entry<String, Integer> entry : holdings.entrySet()) {
			Stock stock = market.getStock(entry.getKey());
			System.out.println(stock.getName()+" (" +stock.getSymbol()+ "): "+entry.getKey()+" shares at $"+ stock.getPrice()+ " each.");
			
		}
		System.out.println("TotalPortfolioValue: $"+getPortfolioValue(market));
		
	}
	

}
