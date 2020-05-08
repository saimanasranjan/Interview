package com.agilisium.interview.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agilisium.interview.dao.ProductDao;
import com.agilisium.interview.excp.AgilisiumExcp;
import com.agilisium.interview.vo.Product;

/**
 * 
 * AgilisiumController - used to get product and confi detail.
 *
 */
@RestController
@RequestMapping("{domain}/api")
public class AgilisiumController {

	@Autowired
	private ProductDao productDao;
	/**
	 * This method is retrieving product details
	 * @param domain
	 * @return list of product else throw excp.
	 */
	@GetMapping(value = "/getproductdetails", produces = "application/json")
	public ResponseEntity<?> getproductdetails(@PathVariable String domain) {
		if (domain.equals("product")) {
			List<Product> prodList = productDao.getProductDao();
			return new ResponseEntity<List<Product>>(prodList, HttpStatus.OK);
		} else {
			throw new AgilisiumExcp("domain name is not exist.It should be product");
			//here we can add bad request using @controller advice
		}

	}
	
	/**
	 * This method is retrieving product details
	 * @param domain
	 * @return list of String else throw excp 
	 */
	@GetMapping(value = "/getconfigdetails", produces = "application/json")
	public ResponseEntity<?> getconfigdetails(@PathVariable String domain) {
		if (domain.equals("config")) {
			List<String> configList = new ArrayList<String>();
			configList.add("Jdk 7"); configList.add("spring boot");configList.add("basic security");
			return new ResponseEntity<List<String>>(configList, HttpStatus.OK);
		} else {
			throw new AgilisiumExcp("domain name is not exist.It should be config");
			//here we can add bad request using @controller advice
		}

	}

}
