package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JSONreader {

	File file = new File("src/sample.json");
	Scanner sc;
	
//Printing JSON
	public String printJSON() {
		try {
			sc = new Scanner(file);
			String line = "";
			while(sc.hasNext()) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(sc.nextLine());
				for(var order : row) {
					order.toString();
					line += order + "\n";
				}
			}
			
			return line;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> getOrderDate() {
		try {
			sc = new Scanner(file);
			ArrayList<String>Orderdate = new ArrayList<String>();
			while(sc.hasNext()) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(sc.nextLine());
				for(var order : row) {
					if(order.contains("\"OrderDate\": \"")) {
					String[] arr = order.split(": \"");
					String orderDate = arr[1].replaceAll("\",", "");
					Orderdate.add(orderDate);
					}
				}
				
			}
			return Orderdate;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> getRegion() {
		try {
			sc = new Scanner(file);
			ArrayList<String>Region = new ArrayList<String>();
			while(sc.hasNext()) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(sc.nextLine());
				for(var order : row) {
					if(order.contains("\"Region\": \"")) {
					String[] arr = order.split(": \"");
					String region = arr[1].replaceAll("\",", "");
					Region.add(region);
					}
				}
				
			}
			return Region;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> getRep1() {
		try {
			sc = new Scanner(file);
			ArrayList<String>Rep1 = new ArrayList<String>();
			while(sc.hasNext()) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(sc.nextLine());
				for(var order : row) {
					if(order.contains("\"Rep1\": \"")) {
					String[] arr = order.split(": \"");
					String rep1 = arr[1].replaceAll("\",", "");
					Rep1.add(rep1);
					}
				}
				
			}
			return Rep1;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> getRep2() {
		try {
			sc = new Scanner(file);
			ArrayList<String>Rep2 = new ArrayList<String>();
			while(sc.hasNext()) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(sc.nextLine());
				for(var order : row) {
					if(order.contains("\"Rep2\": \"")) {
					String[] arr = order.split(": \"");
					String rep2 = arr[1].replaceAll("\",", "");
					Rep2.add(rep2);
					}
				}
				
			}
			return Rep2;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> getItem() {
		try {
			sc = new Scanner(file);
			ArrayList<String>Item = new ArrayList<String>();
			while(sc.hasNext()) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(sc.nextLine());
				for(var order : row) {
					if(order.contains("\"Item\": \"")) {
					String[] arr = order.split(": \"");
					String item = arr[1].replaceAll(",", "");
					item = item.replaceAll("\"", "");
					
					Item.add(item);
					}
				}
				
			}
			return Item;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> getUnits() {
		try {
			sc = new Scanner(file);
			ArrayList<String>Units = new ArrayList<String>();
			while(sc.hasNext()) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(sc.nextLine());
				for(var order : row) {
					if(order.contains("\"Units\": ")) {
					String[] arr = order.split(": ");
					String units = arr[1].replace(",", "");
					Units.add(units);
					}
				}
				
			}
			return Units;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> getUnitCost() {
		try {
			sc = new Scanner(file);
			ArrayList<String>UnitCost = new ArrayList<String>();
			while(sc.hasNext()) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(sc.nextLine());
				for(var order : row) {
					if(order.contains("\"UnitCost\": \"")) {
					String[] arr = order.split(": \"");
					String unitCost = arr[1].replaceAll("\",", "");
					UnitCost.add(unitCost);
					}
				}
				
			}
			return UnitCost;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> getTotal() {
		try {
			sc = new Scanner(file);
			ArrayList<String>Total = new ArrayList<String>();
			while(sc.hasNext()) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(sc.nextLine());
				for(var order : row) {
					if(order.contains("\"Total\": \"")) {
					String[] arr = order.split(": \"");
					String total = arr[1].replaceAll("\",", "");
					total = total.replaceAll("\"", "");
					total = total.replaceAll(",", ".");
					Total.add(total);
					}
				}
				
			}
			return Total;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}