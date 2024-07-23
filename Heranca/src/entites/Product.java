package entites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private Double price;
	private static List<Product> items = new ArrayList<>();

	public Product() {
	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void addItem(Product pd) {
		items.add(pd);
	}

	public void removeItem(Product pd) {
		items.remove(pd);
	}

	public String priceTag() {
		return name;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sb.append("\nPRICE TAGS: \n");
		for (Product c : items) {
			sb.append(c.getName());
			if (c instanceof UsedProduct) {
				sb.append(" (used)");
			}
			if (c instanceof ImportedProduct) {
				sb.append(" $ " + String.format("%.2f", ((ImportedProduct) c).totalPrice()));
			} else if (c instanceof UsedProduct) {
				sb.append(" $ " + String.format("%.2f", c.getPrice()));
			} else {
				sb.append(" $ " + String.format("%.2f", c.getPrice()) + "\n");
			}
			if (c instanceof ImportedProduct) {
				sb.append(" (Customs fee: $ " + String.format("%.2f", ((ImportedProduct) c).getCustomsFee()) + ") \n");
			}
			if (c instanceof UsedProduct) {
				sb.append(" (Manufacture date: " + sdf.format(((UsedProduct) c).getManufactureDate()) + ") \n");
			}
		}
		return sb.toString();
	}

}
