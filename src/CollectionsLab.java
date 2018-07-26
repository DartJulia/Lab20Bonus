import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * @author Julia Dart
 * @author version 1.0
 * Shopping list application using collection types to store items and user's order
 */
public class CollectionsLab {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// creating menu items (grocery items)
		HashMap<String, Double> items = new HashMap<>();
		items.put("banana", 0.50);
		items.put("chocolate", 1.50);
		items.put("lettuce", 1.20);
		items.put("avocado", 0.79);
		items.put("wine", 11.99);
		items.put("yogurt", 1.25);
		items.put("milk", 3.49);
		items.put("beans", 1.60);
		items.put("juice", 4.50);
		ArrayList<String> itemsOrdered = new ArrayList<>();
		ArrayList<Double> priceOfItems = new ArrayList<>();
		ArrayList<Integer> quantity = new ArrayList<>();

		System.out.println("Welcome to Julia's Market! \n");

		String cont = "y";
		String userOrder = "";

		while (cont.equalsIgnoreCase("y")) {
			// headers that print in table format
			System.out.printf("%-15s %-10s%n", "Item", "Price");
			System.out.printf("%-10s%n", "======================");

			// retrieving the keys using keySet() and printing the values along with the
			// hashmap values
			for (String variableName : items.keySet()) {
				String variableKey = variableName;
				double variableValue = items.get(variableName);
				// formatting to print in table format
				System.out.printf("%-15s %-10s%n", variableKey, variableValue);

			}

			System.out.println("What item would you like to order?");
			String userInput = scan.nextLine();
			userOrder = userInput.toLowerCase();
			if (items.containsKey(userOrder)) {
				System.out.println("Adding " + userOrder + " to cart at $" + items.get(userOrder));
			} else {
				System.out.println("Sorry, we don't have those. Try something else. ");
			}
			itemsOrdered.add(userOrder);
			quantity.add(1);
			priceOfItems.add(items.get(userOrder));


			System.out.println("Would you like to order anything else (y/n)? ");
			cont = scan.nextLine();
			System.out.println();

		}



		System.out.println("Your total order is: ");
		System.out.printf("%-15s %-10s %-10s%n", "Item", "Price $", "Quantity");
		System.out.printf("%-10s%n", "====================================");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.printf("%-15s %-10s %-10s%n", itemsOrdered.get(i), priceOfItems.get(i), quantity.get(i));
		}

		System.out.println();
		System.out.println("Average price of your order is $" + averagePrice(priceOfItems));
		System.out.println("The highest priced item is: " + getHighIndex(priceOfItems, itemsOrdered));
		System.out.println("The lowest priced item is: " + getLowIndex(priceOfItems, itemsOrdered));

	}


	public static String averagePrice(ArrayList<Double> prices) {
		double average = 0;
		double sum = 0;
		for (int i = 0; i < prices.size(); i++) {
			sum += prices.get(i);

		}
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		average = sum / (prices.size());

		return numberFormat.format(average);
	}

	public static String getHighIndex(ArrayList<Double> prices, ArrayList<String> items) {
		double highPrice = 0;
		String highItem = "";
		for (int i = 0; i < prices.size(); i++) {
			if (prices.get(i) > highPrice) {
				highPrice = prices.get(i);
				highItem = items.get(i);
			}
		}
		return highItem;

	}

	public static String getLowIndex(ArrayList<Double> prices, ArrayList<String> items) {
		double lowPrice = prices.get(0);
		String lowItem = "";
		for (int i = 0; i < prices.size(); i++) {
			if (prices.get(i) < lowPrice) {
				lowPrice = prices.get(i);
				lowItem = items.get(i);
			}
		}
		return lowItem;

	}
}
