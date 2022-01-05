package edu.unifacef.customersapi.domains;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private String id;
    private String name;
    private String telephone;
    private String driverLincenseNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Address> addresses;
    private String cpf;
    private String birthday;
    private String email;

}
