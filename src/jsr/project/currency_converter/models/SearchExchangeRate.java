package jsr.project.currency_converter.models;

import com.google.gson.Gson;
import jsr.project.currency_converter.utils.config.Configuration;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchExchangeRate {

    public ExchangeRate searchCurrentExchangeRate(String currentCurrencyCode) {

        String apiKey = Configuration.API_KEY;
        String uri = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + currentCurrencyCode;

        try {
            // REQUEST
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .build();

            // RESPONSE
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println("Response => " + json);

            // JSON convert to ExchangeRate
            return new Gson().fromJson(json, ExchangeRate.class);
        } catch (Exception e) {
            System.out.println("No encontre la ");
            throw new RuntimeException(e);
        }
    }
}
