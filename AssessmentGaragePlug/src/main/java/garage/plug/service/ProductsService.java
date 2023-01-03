package garage.plug.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garage.plug.model.Products;
import garage.plug.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired private ProductsRepository productsRepository;
	
	public List<Products> getAllProducts(){
		return productsRepository.findAll();
	}
	public void addProducts(Products products) {
		productsRepository.save(products);
	}
	public void updateProducts(Products product, int id) {
		productsRepository.save(product);
	}
	public void deleteById(int id) {
		productsRepository.deleteById(id);
	}
}
