package edu.unifacef.customersapi.gateways.inputs.http.responses;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import edu.unifacef.customersapi.domains.Customer;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CustomerResponse implements Serializable {

  private static final long serialVersionUID = 9189520552888285200L;

  @ApiModelProperty(position = 0)
  private String id;

  @ApiModelProperty(position = 1)
  private String name;

  @ApiModelProperty(position = 2)
  private String telephone;

  @ApiModelProperty(position = 3)
  private String walletNumber;

  @ApiModelProperty(position = 4)
  private List<AddressResponse> addresses;

  @ApiModelProperty(position = 5)
  private LocalDateTime createdAt;

  @ApiModelProperty(position = 6)
  private LocalDateTime updatedAt;

  @ApiModelProperty(position = 7)
  private String cpf;

  @ApiModelProperty(position = 8)
  private String birthday;

  @ApiModelProperty(position = 9)
  private String email;

  public CustomerResponse(final Customer customer) {
    this.id = customer.getId();
    this.name = customer.getName();
    this.telephone = customer.getTelephone();
    this.walletNumber = customer.getWalletNumber();
    this.addresses = emptyIfNull(customer.getAddresses())
        .stream().map(AddressResponse::new).collect(toList());
    this.createdAt = customer.getCreatedAt();
    this.updatedAt = customer.getUpdatedAt();
    this.cpf = customer.getCpf();
    this.birthday = customer.getBirthday();
    this.email = customer.getEmail();
  }

}
