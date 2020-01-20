package aplication;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		List <Product> list = new ArrayList<>();
		
		
		System.out.print("wellcome \n\nEnter the number of product: ");
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.print("Cummon, used or imported (c/u/i)? ");
			char awnser = sc.next().charAt(0);
			System.out.print("name: ");
			sc.nextLine();
			String name_product = sc.nextLine();
			System.out.print("Price: ");
			Double price_product = sc.nextDouble();
			if(awnser == 'i') {
				System.out.print("Customs fee: ");
				Double fee_product = sc.nextDouble();
				Product product = new ImportProduct(name_product, price_product, fee_product);
				list.add(product);
			}
			else if (awnser == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());	
				Product product = new UsedProduct(name_product, price_product, date);
			    list.add(product);
			}
			else if (awnser == 'c') {
				Product product = new Product(name_product, price_product);
				list.add(product);
			}	
		}

		System.out.println("\n PRICE TAGS: ");
		for(Product c : list) {
			System.out.println(c.priceTag());
		}
		
		sc.close();

	}

}
