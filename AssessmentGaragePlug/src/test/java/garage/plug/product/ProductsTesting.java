package garage.plug.product;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import garage.plug.model.Products;
import garage.plug.repository.ProductsRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ProductsTesting {

	@Autowired private ProductsRepository productsRepository;
	
	@Test
	public void getAllProductsTest() {
		Iterable<Products> products = productsRepository.findAll();
		Assertions.assertThat(products).hasSizeGreaterThan(0);
		
		for(Products product: products) {
			System.out.println(product);
		}	
	}
	
	@Test
	public void addProductTest() {
		Products products = new Products();
		products.setProductName("iPhone14 Max");
		products.setProductQuantity(1);
		
		Products saveProducts = productsRepository.save(products);

		Assertions.assertThat(saveProducts).isNotNull();
		Assertions.assertThat(saveProducts.getProductId()).isGreaterThan(0);
	}
	
	@Test
	public void updateProductsTest() {
		Integer productId = 3;
		Optional<Products> opProduct = productsRepository.findById(productId);
		
		Products settingProducts = opProduct.get();
		settingProducts.setProductName("Oppo Camera Phone");
		productsRepository.save(settingProducts);
		
		Products updateProducts = productsRepository.findById(productId).get();
		Assertions.assertThat(updateProducts.getProductName()).isEqualTo("Oppo Camera Phone");
		
	}
	
	@Test
	public void getProductByIdTest() {
		Integer productId = 3;
		Optional<Products> optionalProducts = productsRepository.findById(productId);
		Assertions.assertThat(optionalProducts).isPresent();
		System.out.println(optionalProducts.get());
		
	}
	
	@Test
	public void deleteByIdTest() {
		Integer productId = 4;
		productsRepository.deleteById(productId);
		
		Optional<Products> opProducts = productsRepository.findById(productId);
		Assertions.assertThat(opProducts).isNotPresent();
	}
	
}
