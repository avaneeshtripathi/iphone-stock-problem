package costCalculate;

import java.util.HashMap;

public class GetCost {
	public static HashMap costBrazil (int orderQuant) {
		HashMap ob = new HashMap();
		try {
			HashMap additionalCost = new HashMap();
			if (orderQuant <= 100) {
				ob.put("inventoryBrazil", 100 - orderQuant);
				ob.put("inventoryArgentina", 100);
				ob.put("totalCost", orderQuant * 100);
			} else {
				ob.put("inventoryBrazil", 0);
				additionalCost = costArg (orderQuant-100);
				ob.put("totalCost", (100 * 100)+(((orderQuant-100)/10)*400) + 
					Integer.parseInt(additionalCost.get("totalCost").toString()));
				ob.put("inventoryArgentina", Integer.parseInt(additionalCost.get("inventoryArgentina").toString()));
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return ob;
	}
	
	public static HashMap costArg (int orderQuant) {
		HashMap ob = new HashMap();	
		try{
			HashMap additionalCost = new HashMap();
			if (orderQuant <= 100) {
				ob.put("inventoryBrazil", 100);
				ob.put("inventoryArgentina", 100 - orderQuant);
				ob.put("totalCost", orderQuant * 50);
			} else {
				ob.put("inventoryArgentina", 0);
				additionalCost = costBrazil (orderQuant-100);
				ob.put("totalCost", (100 * 50)+(((orderQuant-100)/10)*400) +
					Integer.parseInt(additionalCost.get("totalCost").toString()));
				ob.put("inventoryBrazil", Integer.parseInt(additionalCost.get("inventoryBrazil").toString()));
			}
		} catch(Exception e){}
		return ob;
	}
}
