package exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;

public class Prob4 {

	public static void main(String[] args) throws IOException {
		Product[] prodList = { new Product("NT450R5E-K24S", 500000, "삼성전자"),
				new Product("15UD340-LX2CK", 400000, "LG전자"), new Product("G2-K3T32AV", 600000, "HP") };
		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();
	}

	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		System.out.println("특정 금액 이상의 상품 결과입니다*********************");
		HashSet<Product> set = new HashSet<Product>();
		for (Product p : prodList) {
			if (p.getPrice() >= price) {
				set.add(p);
				System.out.println(p);
			}
		}
		return set;
	}

	private static void makeFile(HashSet<Product> resultList) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
			for (Product product : resultList) {
				writer.write(product.toString() + "\n");
			}
			System.out.println("data.txt 파일이 생성되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
			while(true) {
				reader.readLine();
//					System.out.println("data.txt 파일이 생성되었습니다.");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Product implements Serializable {
	private String model_name;
	private int price;
	private String company;

	public Product(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price + ", company=" + company + "]";
	}
}