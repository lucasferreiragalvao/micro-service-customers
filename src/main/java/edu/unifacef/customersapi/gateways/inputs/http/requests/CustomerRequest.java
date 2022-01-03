package edu.unifacef.customersapi.gateways.inputs.http.requests;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public abstract class CustomerRequest implements Serializable {

  private static final long serialVersionUID = 3475925051912891191L;

  @ApiModelProperty(position = 1)
  @NotNull(message = "{required.field}")
  private String name;

  @ApiModelProperty(position = 2)
  @NotNull(message = "{required.field}")
  private String telephone;

  @ApiModelProperty(position = 3)
  @NotNull(message = "{required.field}")
  private String walletNumber;

  @ApiModelProperty(position = 4)
  private List<AddressRequest> address;

  @ApiModelProperty(position = 5)
  @NotNull(message = "{required.field}")
  private String cpf;

  @ApiModelProperty(position = 6)
  @NotNull(message = "{required.field}")
  private String birthday;

  @ApiModelProperty(position = 7)
  @NotNull(message = "{required.field}")
  private String email;

}
