package edu.unifacef.customersapi.gateways.inputs.http;

import edu.unifacef.customersapi.domains.Customer;
import edu.unifacef.customersapi.gateways.inputs.http.requests.CreateCustomerRequest;
import edu.unifacef.customersapi.gateways.inputs.http.requests.UpdateCustomerRequest;
import edu.unifacef.customersapi.gateways.inputs.http.responses.ListResponse;
import edu.unifacef.customersapi.gateways.inputs.http.responses.CustomerResponse;
import edu.unifacef.customersapi.usecases.CreateCustomer;
import edu.unifacef.customersapi.usecases.FindByCustomerCode;
import edu.unifacef.customersapi.usecases.FindCustomers;
import edu.unifacef.customersapi.usecases.UpdateCustomer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/customers")
public class CustomerController {

  private final CreateCustomer createCustomer;
  private final UpdateCustomer updateCustomer;
  private final FindByCustomerCode findByCustomerCode;
  private final FindCustomers findCustomers;

  @PostMapping
  public CustomerResponse create(@RequestBody @Validated final CreateCustomerRequest request) {
    Customer customer = createCustomer.execute(request.toDomain());
    return new CustomerResponse(customer);
  }

  @PutMapping(path = "/{code}")
  public CustomerResponse update(@PathVariable final String code,
                                 @RequestBody @Validated final UpdateCustomerRequest request) {
    Customer customer = updateCustomer.execute(request.toDomain(code));
    return new CustomerResponse(customer);
  }

  @GetMapping(path = "/{code}")
  public CustomerResponse find(@PathVariable final String code) {
    Customer customer = findByCustomerCode.execute(code);
    return new CustomerResponse(customer);
  }

  @GetMapping
  public ListResponse<CustomerResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
                                                   @RequestParam(defaultValue = "20") final Integer size) {
    Page<CustomerResponse> customerPage =
            findCustomers.execute(PageRequest.of(page, size)).map(CustomerResponse::new);
    return new ListResponse<>(customerPage);
  }
}
