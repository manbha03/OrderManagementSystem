package garage.plug.customers;


import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import garage.plug.model.Customers;
import garage.plug.repository.CustomersRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CustomerTesting {

	@Autowired private CustomersRepository customersRepository;
	
	@Test
	public void getAllCustomersTest() {
		Iterable<Customers> customers = customersRepository.findAll();
		Assertions.assertThat(customers).hasSizeGreaterThan(0);
		
		for(Customers customer: customers) {
			System.out.println(customer);
		}	
	}
	
	@Test
	public void addCustomerTest() {
		Customers customers = new Customers();
		customers.setCustomerName("Dakamanbha");
		customers.setAddress("Meghalaya");
		customers.setPhoneNumber("1234567890");
		
		Customers saveCustomers = customersRepository.save(customers);
		Assertions.assertThat(saveCustomers).isNotNull();
		Assertions.assertThat(saveCustomers.getCustomersId()).isGreaterThan(0);
	}
	
	@Test
	public void updateCustomersTest() {
		Integer customerId = 8;
		Optional<Customers> opCustomer = customersRepository.findById(customerId);
		
		Customers settingCustomers = opCustomer.get();
		settingCustomers.setAddress("Shillong");
		customersRepository.save(settingCustomers);
		
		Customers updateCustomers = customersRepository.findById(customerId).get();
		Assertions.assertThat(updateCustomers.getAddress()).isEqualTo("Shillong");
		
	}
	
	@Test
	public void getCustomersByIdTest() {
		Integer customersId = 9;
		Optional<Customers> optionalCustomers = customersRepository.findById(customersId);
		Assertions.assertThat(optionalCustomers).isPresent();
		System.out.println(optionalCustomers.get());
		
	}
	
	@Test
	public void deleteByIdTest() {
		Integer customerId = 7;
		customersRepository.deleteById(customerId);
		
		Optional<Customers> opCustomer = customersRepository.findById(customerId);
		Assertions.assertThat(opCustomer).isNotPresent();
	}
	
	
}
