import java.util.HashMap;
import java.util.Scanner;

import costCalculate.GetCost;

public class CostCalculator {
	public static void main(String[] args) {
		GetCost getCost  = new GetCost();
		HashMap orderCost = new HashMap();
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Country: ");
		String country = sc.next();
		System.out.print("\nEnter Order Quatity: ");
		int orderQuant = sc.nextInt();
		if (orderQuant <= 200 && orderQuant % 10 == 0) {
			if (country.equalsIgnoreCase("brazil") || country.equalsIgnoreCase("argentina")) {
				orderCost = country.equalsIgnoreCase("brazil") ? getCost.costBrazil(orderQuant) : getCost.costArg(orderQuant);
				System.out.print(orderCost.get("totalCost") + " : " + orderCost.get("inventoryBrazil") + " : " + orderCost.get("inventoryArgentina"));
			} else {
				System.out.print("Incorrect country selection");
			}
		} else if (orderQuant > 200) {
			System.out.println("Out of Stock!");
		} else {
			System.out.println("Inappropriate order quantity!");
		}
	}
}
