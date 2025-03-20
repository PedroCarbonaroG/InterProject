package com.interchallange.studyplan.core.configuration;

import com.interchallange.studyplan.domain.entity.Customer;
import com.interchallange.studyplan.domain.entity.Order;
import com.interchallange.studyplan.domain.entity.Product;
import com.interchallange.studyplan.domain.enums.OrderStatus;
import com.interchallange.studyplan.repository.CustomerRepository;
import com.interchallange.studyplan.repository.OrderRepository;
import com.interchallange.studyplan.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BuildInitialDataBaseConfig implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        log.info("BuildInitialDataBaseConfig | Building initial system data base");
        var customers = buildInitialCustomers();
        var products = buildInitialProducts();

        customerRepository.deleteAll();
        productRepository.deleteAll();
        orderRepository.deleteAll();

        customerRepository.saveAll(customers);
        productRepository.saveAll(products);

        var customersByDataBase = customerRepository.listAll();
        var orders = buildInitialOrders(customersByDataBase, products);
        orderRepository.saveAll(orders);
        log.info("BuildInitialDataBaseConfig | Initial database was built with success!");
    }

    private List<Customer> buildInitialCustomers() {
        return List.of(
                Customer.builder().name("João Silva").email("joao.silva@email.com").phoneNumber("(11) 91234-5678").build(),
                Customer.builder().name("Maria Oliveira").email("maria.oliveira@email.com").phoneNumber("(21) 98765-4321").build(),
                Customer.builder().name("Carlos Souza").email("carlos.souza@email.com").phoneNumber("(31) 99876-5432").build(),
                Customer.builder().name("Ana Costa").email("ana.costa@email.com").phoneNumber("(41) 92345-6789").build(),
                Customer.builder().name("Pedro Santos").email("pedro.santos@email.com").phoneNumber("(51) 91122-3344").build(),
                Customer.builder().name("Luciana Pereira").email("luciana.pereira@email.com").phoneNumber("(61) 93456-7890").build(),
                Customer.builder().name("Felipe Lima").email("felipe.lima@email.com").phoneNumber("(71) 90567-8901").build(),
                Customer.builder().name("Maria Rocha").email("mariana.rocha@email.com").phoneNumber("(81) 91987-6543").build(),
                Customer.builder().name("Gustavo Alves").email("gustavo.alves@email.com").phoneNumber("(91) 92345-6789").build(),
                Customer.builder().name("Isabela Martins").email("isabela.martins@email.com").phoneNumber("(11) 93456-7890").build()
        );
    }

    private List<Product> buildInitialProducts() {
        return List.of(
                Product.builder().description("Camisa").value(120.0).build(),
                Product.builder().description("Calça").value(200.0).build(),
                Product.builder().description("Sapato").value(350.0).build(),
                Product.builder().description("Bolsa").value(500.0).build(),
                Product.builder().description("Relógio").value(800.0).build(),
                Product.builder().description("Óculos").value(220.0).build(),
                Product.builder().description("Jaqueta").value(400.0).build(),
                Product.builder().description("Perfume").value(250.0).build(),
                Product.builder().description("Brinco").value(150.0).build(),
                Product.builder().description("Cinto").value(90.0).build()
        );
    }

    private List<Order> buildInitialOrders(List<Customer> customers, List<Product> products) {

        Random random = new Random();
        return IntStream.range(0, 30)
                .mapToObj(i -> {
                    Customer customer = customers.get(random.nextInt(customers.size()));

                    List<Product> orderProducts = IntStream.range(0, random.nextInt(1, 5))
                            .mapToObj(j -> products.get(random.nextInt(products.size())))
                            .toList();

                    double totalValue = orderProducts.stream().mapToDouble(Product::getValue).sum();

                    return Order.builder()
                            .customerId(customer.getId())
                            .orderDate(LocalDateTime.now().minusDays(random.nextInt(30)))
                            .status(OrderStatus.values()[random.nextInt(OrderStatus.values().length)])
                            .totalValue(totalValue)
                            .products(orderProducts)
                            .build();})
                .toList();
    }

}
