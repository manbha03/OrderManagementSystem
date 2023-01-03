package garage.plug.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import garage.plug.model.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}

