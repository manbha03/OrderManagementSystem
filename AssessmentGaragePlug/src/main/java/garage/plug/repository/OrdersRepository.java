package garage.plug.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import garage.plug.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	
}
