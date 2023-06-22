package com.tsti.db;

import com.tsti.entity.Client;
import com.tsti.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private ClientRepository clientRepository;

    @Autowired
    public DatabaseInitializer(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadDBClient();
    }
    public void loadDBClient() {
        List<Client> clientList = clientRepository.findAll();
        if (clientList.size() == 0) {
            dbClient();
        }
    }
    public void dbClient() {
            clientRepository.save(new Client(null, 20000000L, "juan", "gomez", "Calle 1", "juan.gomez@gmail.com", "01/01/1980"));
            clientRepository.save(new Client(null, 20000001L, "maria", "perez", "Calle 2", "maria.perez@gmail.com", "02/02/1980"));
            clientRepository.save(new Client(null, 20000002L, "jose", "garcia", "Calle 3", "jose.garcia@gmail.com", "03/03/1980"));
            clientRepository.save(new Client(null, 20000003L, "ana", "fernandez", "Calle 4", "ana.fernandez@gmail.com", "04/04/1980", "10020", "30/04/2025"));
            clientRepository.save(new Client(null, 20000004L, "pedro", "gonzalez", "Calle 5", "pedro.gonzalez@gmail.com", "05/05/1980","30060", "03/11/2028"));
    }
}