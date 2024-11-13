package pocKafka.bestBuy.Controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import pocKafka.bestBuy.Model.Customer;
import pocKafka.bestBuy.Model.Product;
import pocKafka.bestBuy.Service.CustomerService;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product) {

            return customerService.createProduct(product);

    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestParam String message){
        kafkaTemplate.send("product_topic",message);
    }

    @GetMapping("/customers/products")
    public List<Product> getAllProducts() {
        return customerService.getAllProducts();
    }

    @KafkaListener(topics = "ack_topic", groupId = "product_group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}