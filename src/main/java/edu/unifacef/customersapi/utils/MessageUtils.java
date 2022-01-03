package edu.unifacef.customersapi.utils;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

import edu.unifacef.customersapi.exceptions.MessageKey;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageUtils {

  private final MessageSource messageSource;

  public String getMessage(final MessageKey messageKey, final Object... param) {
    return messageSource.getMessage(messageKey.getCpf(), param, getLocale());
  }
}