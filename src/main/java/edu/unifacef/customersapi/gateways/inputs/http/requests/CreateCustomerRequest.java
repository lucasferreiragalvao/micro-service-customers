package edu.unifacef.customersapi.gateways.inputs.http.requests;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;
import edu.unifacef.customersapi.domains.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateCustomerRequest extends CustomerRequest {

  private static final long serialVersionUID = 8743997776881612716L;

  public Customer toDomain() {
    return Customer.builder()
        .name(super.getName())
        .telephone(super.getTelephone())
        .walletNumber(super.getWalletNumber())
        .addresses(emptyIfNull(super.getAddress())
            .stream().map(AddressRequest::toDomain).collect(toList()))
        .cpf(super.getCpf())
        .birthday(super.getBirthday())
        .email(super.getEmail())
        .build();
  }
}
