package edu.unifacef.customersapi.gateways.outputs.mongodb.documents;

import edu.unifacef.customersapi.domains.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDocument {

  private String id;
  private String street;
  private String district;
  private String zip;
  private String city;
  private String complement;
  private String uf;

  public AddressDocument(final Address address) {

    this.id = address.getId();
    this.street = address.getStreet();
    this.district = address.getDistrict();
    this.zip = address.getZip();
    this.city = address.getCity();
    this.complement = address.getComplement();
    this.uf = address.getUf();

  }

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
