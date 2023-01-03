package garage.plug.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garage.plug.model.Customers;
import garage.plug.repository.CustomersRepository;

@Service
public class CustomersService {

	@Autowired private CustomersRepository customersRepository;
	
	public List<Customers> getAllCustomers(){
		return customersRepository.findAll();
	}
	
	public void addCustomer(Customers customers) {
		customersRepository.save(customers);
	}
	
	public void deleteById(int id) {
		customersRepository.deleteById(id);
	}
	public void updateById(Customers customers, int id) {
		customersRepository.save(customers);
	}

}
