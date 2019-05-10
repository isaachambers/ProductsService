package com.isaachambers.demo.controllers;

import com.isaachambers.demo.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaachambers.demo.domain.Product;
import com.isaachambers.demo.domain.Supplier;

@RestController
@RequestMapping(path = "product")
public class ProductsController {

	@Autowired
	private ProductsService productsService;

	@GetMapping("")
	public ResponseEntity<Object> getAll() {
		return new ResponseEntity<Object>(productsService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Object> findById(@PathVariable String productId) {
		Product p = productsService.getProductById(productId);
		if (null == p) {
			return new ResponseEntity<Object>("Product Not Found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Object>(p, HttpStatus.OK);
		}
	}

	@PostMapping("")
	public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<Object>(productsService.saveNewProduct(product), HttpStatus.OK);
	}

	@GetMapping("/{productId}/supplier")
	public ResponseEntity<Object> getSuppliers(@PathVariable String productId) {
		Product p = productsService.getProductById(productId);
		if (null == p) {
			return new ResponseEntity<Object>("Product Not Found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Object>(p.getSuppliers(), HttpStatus.OK);
		}
	}

	@PostMapping("/{productId}/supplier")
	public ResponseEntity<Object> getSuppliers(@PathVariable String productId, @RequestBody Supplier supplier) {
		Product p = productsService.getProductById(productId);
		if (null == p) {
			return new ResponseEntity<Object>("Product Not Found", HttpStatus.NOT_FOUND);
		} else {

			return new ResponseEntity<Object>(productsService.addSupplier(p, supplier), HttpStatus.OK);
		}
	}

	@GetMapping("/price/{amount}")
	public ResponseEntity<Object> findByAmountLessThan(@PathVariable double amount) {
		return new ResponseEntity<Object>(productsService.findByAmountLessThan(amount), HttpStatus.OK);
	}

	@GetMapping("/searchbysuppliername/{supplierName}")
	public ResponseEntity<Object> findByAmountLessThan(@PathVariable String supplierName) {
		return new ResponseEntity<Object>(productsService.findBySupplierName(supplierName), HttpStatus.OK);
	}

}
