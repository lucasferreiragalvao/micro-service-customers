package edu.unifacef.customersapi.gateways.outputs.mongodb;

import edu.unifacef.customersapi.domains.Customer;
import edu.unifacef.customersapi.gateways.outputs.CustomerDataGateway;
import edu.unifacef.customersapi.gateways.outputs.mongodb.documents.CustomerDocument;
import edu.unifacef.customersapi.gateways.outputs.mongodb.repositories.CustomerRepository;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerDataGatewayMongoImpl implements CustomerDataGateway {

  private final CustomerRepository customerRepository;

  @Override
  public Customer save(final Customer customer) {
    if(Objects.isNull(customer.getCreatedAt())) {
      customer.setCreatedAt(LocalDateTime.now());
    }
    return customerRepository.save(new CustomerDocument(customer)).toDomain();
  }

  @Override
  public Optional<Customer> findByCode(final String code) {
    return customerRepository.findById(code).map(CustomerDocument::toDomain);
  }

  @Override
  public Optional<Customer> findByCpf(final String cpf) {
    return customerRepository.findByCpf(cpf).map(CustomerDocument::toDomain);
  }

  @Override
  public Page<Customer> findByPage(final Pageable pageable) {
    return customerRepository.findAll(pageable).map(CustomerDocument::toDomain);
  }
}
