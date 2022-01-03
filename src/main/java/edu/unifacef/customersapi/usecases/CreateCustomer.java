package edu.unifacef.customersapi.usecases;

import static edu.unifacef.customersapi.exceptions.MessageKey.CUSTOMER_ALREADY_EXISTS;

import edu.unifacef.customersapi.domains.Customer;
import edu.unifacef.customersapi.gateways.outputs.CustomerDataGateway;
import edu.unifacef.customersapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateCustomer {

  private final CustomerDataGateway customerDataGateway;
  private final MessageUtils messageUtils;

  public Customer execute(final Customer customer) {

    validate(customer);
    Customer saved = customerDataGateway.save(customer);

    return saved;
  }

  private void validate(Customer customer){
    validateCpfExist(customer);
  }

  private void validateCpfExist(Customer customer){
    log.info("Create customer. Customer CPF: {}", customer.getCpf());
    if(customerDataGateway.findByCpf(customer.getCpf()).isPresent()) {
      throw new IllegalArgumentException(messageUtils.getMessage(CUSTOMER_ALREADY_EXISTS, customer.getCpf()));
    }
  }
}
