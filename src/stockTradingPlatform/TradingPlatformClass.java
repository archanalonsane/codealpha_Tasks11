package stockTradingPlatform;
import java.util.Scanner;

//Provides the main interface for the user to interact with the market, buy/sell stocks, and view their portfolio.

public class TradingPlatformClass {
	public static void main(String[] args) {

		Market mr = new Market();
		Portfolio pf = new Portfolio();
		Scanner sc = new Scanner(System.in);

		System.out.println("------------------------------");
		System.out.println("Simple Stock Trading Platform");
		System.out.println("------------------------------");
		System.out.println();


		while(true) {
			System.out.println("Welcome to the Stock Trading Platform: ");
			System.out.println("1. View Market Data");
			System.out.println("2. Buy Stock");
			System.out.println("3. Sell Stock");
			System.out.println("4. View Portfolio");
			System.out.println("5. Exit");
			System.out.println();
			System.out.println("Choose an Option: ");

			int choice = sc.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Market Data: ");
				for(Stock stock : mr.getAllStocks()) {
					System.out.println(stock.getName()+" ("+ stock.getSymbol()+"): $"+stock.getPrice());

				}
				break;
			case 2:
				System.out.println("Enter stock symbol to buy: ");
				String stockSymbol = sc.next().toUpperCase();
				System.out.println("Enter quantity to buy: ");
				int buyQuantity = sc.nextInt();
				Stock buyStock = mr.getStock(stockSymbol);

				if(buyStock != null) {
					pf.buyStock(buyStock, buyQuantity);
					System.out.println("Bought " + buyQuantity + " shares of " + buyStock.getName());


				}
				else {
					System.out.println("stock not found..");
				}
				break;
				
			case 3:
				System.out.println("Enter stock symbol to sell: ");
				String sellSymbol = sc.next().toUpperCase();
				System.out.println("Enter quantity to sell: ");
				int sellQuantity= sc.nextInt();
				Stock sellStock = mr.getStock(sellSymbol);
				if(sellStock!=null) {
					pf.sellStock(sellStock, sellQuantity);
					System.out.println("Sold " + sellQuantity + " shares of " + sellStock.getName());
				}
				else {
					System.out.println("Stock not found..");
				}
				break;
				
			case 4:
				pf.printPortfolio(mr);
				break;
				
			case 5:
				System.out.println("Exiting the Platform. GoodBye..!");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice, Please try again.");


			}


		}
	}

}
