package edu.unifacef.customersapi.usecases;

import edu.unifacef.customersapi.domains.Customer;
import edu.unifacef.customersapi.gateways.outputs.CustomerDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindCustomers {

  private final CustomerDataGateway customerDataGateway;

  public Page<Customer> execute(final Pageable pageable) {
    log.info("Find customers. Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
    return customerDataGateway.findByPage(pageable);
  }
}
