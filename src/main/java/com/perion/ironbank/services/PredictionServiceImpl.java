package com.perion.ironbank.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Evgeny Borisov
 */
@Component
@Transactional
public final class PredictionServiceImpl implements PredictionService {
    @Override
    public boolean willSurviveTheWinter(String name) {
        return !name.toLowerCase().contains("stark");
    }
}
