package pocKafka.bestBuy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pocKafka.bestBuy.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
