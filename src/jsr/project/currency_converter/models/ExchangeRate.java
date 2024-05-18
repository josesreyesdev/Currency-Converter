package jsr.project.currency_converter.models;

import java.util.Map;

// Tipo de cambio
public record ExchangeRate(
        String result,
        String documentation,
        String terms_of_use,
        long time_last_update_unix,
        String time_last_update_utc,
        long time_next_update_unix,
        String time_next_update_utc,
        String base_code,
        Map<String, Double> conversion_rates


) {
    @Override
    public String result() {
        return result;
    }

    @Override
    public Map<String, Double> conversion_rates() {
        return conversion_rates;
    }
}
