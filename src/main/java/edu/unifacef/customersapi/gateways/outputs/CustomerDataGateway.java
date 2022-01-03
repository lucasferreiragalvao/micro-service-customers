package edu.unifacef.customersapi.gateways.outputs;

import java.util.Optional;

import edu.unifacef.customersapi.domains.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerDataGateway {

  Customer save(Customer customer);

  Optional<Customer> findByCode(String code);

  Optional<Customer> findByCpf(String cpf);

  Page<Customer> findByPage(Pageable pageable);
}
