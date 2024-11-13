package pocKafka.bestBuy.Service;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pocKafka.bestBuy.Model.Customer;
import pocKafka.bestBuy.Model.Product;
import pocKafka.bestBuy.Repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private RestTemplate restTemplate;

    private static final String TOPIC = "product_topic";

    @Override
    public Product createProduct(Product product) {
//        Message<Product> message = MessageBuilder
//                .withPayload(product)
//                .setHeader(KafkaHeaders.TOPIC, TOPIC)
//                .build();
      //  String message= product.toString();
        String jsonString = new Gson().toJson(product);
        kafkaTemplate.send(TOPIC, jsonString);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return restTemplate.getForObject("http://localhost:8081/products", List.class);
    }
}
