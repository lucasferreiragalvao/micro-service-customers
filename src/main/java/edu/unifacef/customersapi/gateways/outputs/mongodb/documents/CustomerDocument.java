package edu.unifacef.customersapi.gateways.outputs.mongodb.documents;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;
import java.time.LocalDateTime;
import java.util.List;
import edu.unifacef.customersapi.domains.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("customers")
public class CustomerDocument {

  @Id
  private String id;
  private String name;
  private String telephone;
  private String driverLincenseNumber;
  private List<AddressDocument> addresses;
  private LocalDateTime createdAt;
  private String cpf;
  private String birthday;
  private String email;
  @LastModifiedDate
  private LocalDateTime updatedAt;

  public CustomerDocument(final Customer customer) {
    this.id = customer.getId();
    this.name = customer.getName();
    this.telephone = customer.getTelephone();
    this.driverLincenseNumber = customer.getDriverLincenseNumber();
    this.addresses = emptyIfNull(customer.getAddresses())
            .stream().map(AddressDocument::new).collect(toList());
    this.cpf = customer.getCpf();
    this.birthday = customer.getBirthday();
    this.email = customer.getEmail();
    this.createdAt = customer.getCreatedAt();
    this.updatedAt = customer.getUpdatedAt();

  }

  public Customer toDomain() {
    return Customer.builder()
        .id(this.id)
        .name(this.name)
        .telephone(this.telephone)
        .driverLincenseNumber(this.driverLincenseNumber)
        .addresses(emptyIfNull(this.addresses)
            .stream().map(AddressDocument::toDomain).collect(toList()))
        .createdAt(this.createdAt)
        .updatedAt(this.updatedAt)
        .cpf(this.cpf)
        .birthday(this.birthday)
        .email(this.email)
        .build();
  }

}
