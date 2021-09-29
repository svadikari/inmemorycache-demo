package com.shyam.cache.service;

import com.shyam.cache.domain.CurrencyCodeResponse;
import com.shyam.cache.entity.CurrencyCode;
import com.shyam.cache.repository.CurrencyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;

@Service
@Slf4j
public class CurrencyCodeService {
    private final CurrencyRepository currencyRepository;

    public CurrencyCodeService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Cacheable(cacheNames = "currency", key = "#countryCode")
    public CurrencyCodeResponse fetchCurrencyDetails(String countryCode) throws InterruptedException, NoResultException {
        log.info("Fetching Currency code for {} country: ", countryCode);
        Thread.sleep(1000 * 5);
        try {
            CurrencyCode currencyCode = currencyRepository.getById(countryCode);
            return CurrencyCodeResponse.builder().countryCode(countryCode)
                    .currencyCode(currencyCode.getCurrencyCode())
                    .country(currencyCode.getCountry())
                    .build();
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new NoResultException("No currency available for " + countryCode + " country code");
        }
    }
}
