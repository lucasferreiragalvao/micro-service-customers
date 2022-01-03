package edu.unifacef.customersapi.gateways.inputs.http.requests;

import edu.unifacef.customersapi.domains.Address;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class AddressRequest implements Serializable {

  private static final long serialVersionUID = -6834094997433764356L;

  @ApiModelProperty(position = 1)
  private String id;

  @ApiModelProperty(position = 2)
  private String street;

  @ApiModelProperty(position = 3)
  private String district;

  @ApiModelProperty(position = 4)
  private String zip;

  @ApiModelProperty(position = 5)
  private String city;

  @ApiModelProperty(position = 6)
  private String complement;

  @ApiModelProperty(position = 7)
  private String uf;

  public Address toDomain() {
    return Address.builder()
        .id(this.id)
        .street(this.street)
        .district(this.district)
        .zip(this.zip)
        .city(this.city)
        .complement(this.complement)
        .uf(this.uf)
        .build();
  }
}
