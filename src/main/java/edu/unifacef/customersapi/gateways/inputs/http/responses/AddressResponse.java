package edu.unifacef.customersapi.gateways.inputs.http.responses;

import edu.unifacef.customersapi.domains.Address;
import java.io.Serializable;
import lombok.Data;

@Data
public class AddressResponse implements Serializable {

  private static final long serialVersionUID = 7808546186559340341L;

  private String id;
  private String street;
  private String district;
  private String zip;
  private String city;
  private String complement;
  private String uf;

  public AddressResponse(final Address address) {

    this.id = address.getId();
    this.street = address.getStreet();
    this.district = address.getDistrict();
    this.zip = address.getZip();
    this.city = address.getCity();
    this.complement = address.getComplement();
    this.uf = address.getUf();

  }

}
