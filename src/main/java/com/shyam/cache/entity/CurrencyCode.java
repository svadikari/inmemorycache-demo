package com.shyam.cache.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="CURRENCY")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyCode {
    @Id
    @Column(name="COUNTRY_CODE")
    String countryCode;
    @Column(name="COUNTRY")
    String country;
    @Column(name="CURRENCY_CODE")
    String currencyCode;

}
