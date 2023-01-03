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

import garage.plug.model.Customers;
import garage.plug.service.CustomersService;

@RestController
public class CustomersController {

	@Autowired
	private CustomersService customersService;

	@GetMapping("/customers")
	public List<Customers> getAllCustomers() {
		return customersService.getAllCustomers();
	}

	@PostMapping("/customers")
	public void addCustomers(@RequestBody Customers customers) {
		customersService.addCustomer(customers);
	}

	@PutMapping("/customers/{id}")
	public void updateCustomers(@RequestBody Customers customers, @PathVariable int id) {
		customersService.updateById(customers, id);
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable("id") int id) {
		customersService.deleteById(id);
	}
}
