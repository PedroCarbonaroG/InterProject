package com.interchallange.studyplan.core.configuration;

import com.interchallange.studyplan.domain.entity.Customer;
import com.interchallange.studyplan.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BuildInitialDataBaseConfig implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        log.info("BuildInitialDataBaseConfig | Building initial system data base");
        customerRepository.deleteAll();
        customerRepository.saveAll(buildInitialCustomers());
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
                Customer.builder().name("Mariana Rocha").email("mariana.rocha@email.com").phoneNumber("(81) 91987-6543").build(),
                Customer.builder().name("Gustavo Alves").email("gustavo.alves@email.com").phoneNumber("(91) 92345-6789").build(),
                Customer.builder().name("Isabela Martins").email("isabela.martins@email.com").phoneNumber("(11) 93456-7890").build()
        );
    }

}
