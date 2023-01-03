package garage.plug.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garage.plug.model.Orders;
import garage.plug.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired private OrdersRepository ordersRepository;
	
	public List<Orders> getAllOrder(){
		return ordersRepository.findAll();
	}
	
	public void addOrders(Orders orders) {
		 ordersRepository.save(orders);
	}
	
	public void updateOrders(Orders orders, int id) {
		ordersRepository.save(orders);
	}
	
	public void deleteById(int id) {
		ordersRepository.deleteById(id);
	}
	
}
