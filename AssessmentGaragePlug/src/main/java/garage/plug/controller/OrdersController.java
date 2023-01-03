package garage.plug.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import garage.plug.model.Orders;
import garage.plug.service.OrdersService;

@RestController
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@GetMapping("/orders")
	public List<Orders> getAllOrders() {
		return ordersService.getAllOrder();
	}

	@PostMapping("/orders")
	public void addOrders(@RequestBody Orders orders) {
		ordersService.addOrders(orders);
	}
}
