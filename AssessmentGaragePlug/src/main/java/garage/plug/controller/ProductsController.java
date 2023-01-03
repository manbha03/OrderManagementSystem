package garage.plug.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import garage.plug.model.Products;
import garage.plug.service.ProductsService;

@RestController
public class ProductsController {

	@Autowired private ProductsService productsService;
	
	@GetMapping("/products")
	public List<Products> getAllProducts(){
		return productsService.getAllProducts();
	}
	@PostMapping("/products")
	public void addProducts(@RequestBody Products products) {
		productsService.addProducts(products);
	}
	@PutMapping("/products/{id}")
	public void updateById(@RequestBody Products products, @PathVariable int id ) {
		productsService.updateProducts(products, id);
	}
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable("id") int id) {
		productsService.deleteById(id);
	}
}
