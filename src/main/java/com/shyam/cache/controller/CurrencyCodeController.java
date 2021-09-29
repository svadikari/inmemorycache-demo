package com.shyam.cache.controller;

import com.shyam.cache.domain.CurrencyCodeResponse;
import com.shyam.cache.service.CurrencyCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyCodeController {
    private final CurrencyCodeService currencyCodeService;

    public CurrencyCodeController(CurrencyCodeService currencyCodeService) {
        this.currencyCodeService = currencyCodeService;
    }

    @GetMapping("/{countryCode}")
    public CurrencyCodeResponse retrieveTicketPrices(@PathVariable String countryCode) throws InterruptedException {
        return currencyCodeService.fetchCurrencyDetails(countryCode);
    }
}
