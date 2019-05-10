package com.isaachambers.demo.services;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isaachambers.demo.domain.*;
import com.isaachambers.demo.model.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.isaachambers.demo.repository.ProductRepository;

@Service
public class ProductsService {

    private static final Logger logger  = LoggerFactory.getLogger(ProductsService.class);
	@Autowired
	private ProductRepository productRepository;

    @Value("${search.products.topic}")
    private String productTopic;

	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
    private ObjectMapper mapper;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(String id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product saveNewProduct(Product product) {


        Product p =  productRepository.save(product);
        KafkaMessage kfm = new KafkaMessage(MessageType.NEW_PRODUCT, "New Product",
                p.getId() + "");
       try {
           kafkaTemplate.send(productTopic,  mapper.writeValueAsString(kfm));
       }catch (Exception ex){
           logger.error(ex.getMessage(), ex.fillInStackTrace());
       }
        return p;

	}

	public void deleteProductById(String id){
	    productRepository.deleteById(id);
        KafkaMessage kfm = new KafkaMessage(MessageType.DELETE_PRODUCT, "Product Deleted",
                id + "");
        try {
            kafkaTemplate.send(productTopic,  mapper.writeValueAsString(kfm));
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex.fillInStackTrace());
        }
    }

	public Product addReview(Product product, Review review) {
		product.getReviews().add(review);
		return productRepository.save(product);
	}

	public Product addCategory(Product product, Category category) {
		product.getCategories().add(category);
		return productRepository.save(product);
	}

	public Product addSupplier(Product product, Supplier supplier) {
		product.getSuppliers().add(supplier);
		return productRepository.save(product);
	}

	public  List<Product> findByAmountLessThan(double amount) {
		return productRepository.findByAmountLessThan(amount);
	}

    public  List<Product> findBySupplierName(String name) {
        return productRepository.findBySupplierName(name);
    }
}
