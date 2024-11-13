package pocKafka.bestBuy.Service;

import pocKafka.bestBuy.Model.Customer;
import pocKafka.bestBuy.Model.Product;

import java.util.List;

public interface CustomerService {
    public Product createProduct(Product product);
    public List<Product> getAllProducts();
}
