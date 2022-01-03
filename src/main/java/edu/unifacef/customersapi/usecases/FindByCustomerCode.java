package edu.unifacef.customersapi.usecases;

import static edu.unifacef.customersapi.exceptions.MessageKey.CUSTOMER_NOT_FOUND;

import edu.unifacef.customersapi.domains.Customer;
import edu.unifacef.customersapi.exceptions.NotFoundException;
import edu.unifacef.customersapi.gateways.outputs.CustomerDataGateway;
import edu.unifacef.customersapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByCustomerCode {

  private final CustomerDataGateway customerDataGateway;
  private final MessageUtils messageUtils;

  public Customer execute(final String code) {
    log.info("Find customer. Customer code: {}", code);
    return customerDataGateway.findByCode(code).orElseThrow(
        () -> new NotFoundException(messageUtils.getMessage(CUSTOMER_NOT_FOUND, code)));
  }
}
