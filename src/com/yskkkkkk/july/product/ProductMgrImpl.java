package com.yskkkkkk.july.product;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductMgrImpl implements IProductMgr{

	List<Product> products = new ArrayList<>();
	
	// 싱글톤 객체 생성
	private static ProductMgrImpl instance = new ProductMgrImpl();
	private ProductMgrImpl() {}
	public static ProductMgrImpl getInstance(){
    	return instance;
	}
	
	@Override
	public void add(Product product) {
		products.add(product);
	}
	
	@Override
	public void getAllList() {
		for (Product product : products) {
			System.out.println(product);
		}
	}
	
	@Override
	public Product selectByNo(int productNo) {
		Product product = new Product();
		for (Product p : products) {
			if (p.getProductNo() == productNo) {
				product = p;
				break;
			}
		}
		return product;
	}
	
	@Override
	public ArrayList<Product> selectByName(String productName) {
		ArrayList<Product> result = new ArrayList<>();
		for (Product product : products) {
			if (product.getName().contains(productName)) {
				result.add(product);
			}
		}
		return result;
	}
	
	@Override
	public ArrayList<Tv> selectTv() {
		ArrayList<Tv> result = new ArrayList<>();
		for (Product product : products) {
			if (product instanceof Tv) {
				result.add((Tv)product);
			}
		}
		return result;
	}
	
	@Override
	public ArrayList<Refrigerator> selectRefrigerator() {
		ArrayList<Refrigerator> result = new ArrayList<>();
		for (Product product : products) {
			if (product instanceof Refrigerator) {
				result.add((Refrigerator)product);
			}
		}
		return result;
	}
	
	@Override
	public void remove(int productNo) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductNo() == productNo) {
				products.remove(i);
			}
		}
	}
	
	@Override
	public String getTotalPrice() {
		BigDecimal total = BigDecimal.ZERO;
		for (Product product : products) {
			BigDecimal inventoryPrice = product.getPrice().multiply(new BigDecimal(product.getAmount()));
			total = total.add(inventoryPrice);
		}
		DecimalFormat decimalFormat = new DecimalFormat("###,###");
		return decimalFormat.format(total);
	}
}
