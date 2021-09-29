package com.shyam.cache.domain;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyCodeResponse {
    String countryCode;
    String currencyCode;
    String country;
}
