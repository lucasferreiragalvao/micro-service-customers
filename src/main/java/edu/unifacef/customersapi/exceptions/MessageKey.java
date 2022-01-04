package edu.unifacef.customersapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {

  CUSTOMER_NOT_FOUND("customer.not.found"),
  CUSTOMER_ALREADY_EXISTS("customer.already.exists");

  private String key;

}
