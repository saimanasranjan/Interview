package com.agilisium.interview.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.agilisium.interview.vo.Product;

@Repository
public class ProductDao {
   /**
    * This method is used to set the hard coded products.
    * It should be db/soa call.
    * 
    * @return listP
    */
	public List<Product> getProductDao(){
		List<Product> listP = new ArrayList<Product>();
		Product Product1 = new Product("Lux", "Hindustan co.");
		Product Product2 = new Product("Vim", "Abc");
		listP.add(Product1);listP.add(Product2);
		
		return listP;
	}
	
}
