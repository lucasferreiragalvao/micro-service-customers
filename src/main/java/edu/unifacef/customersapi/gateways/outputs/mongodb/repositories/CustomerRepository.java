package edu.unifacef.customersapi.gateways.outputs.mongodb.repositories;

import edu.unifacef.customersapi.gateways.outputs.mongodb.documents.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerDocument, String> {

    Optional<CustomerDocument> findByCpf(String cpf);

    Optional<CustomerDocument> findByEmail(String email);
}
