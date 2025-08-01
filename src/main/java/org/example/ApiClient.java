package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    public ApiResponse getExchangeRates(String baseCurrency) throws IOException, InterruptedException {
        String apiKey = System.getenv("API_KEY");
        URI address = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("API response error: " + response.statusCode() + " " + response.body());
        }
        return new Gson().fromJson(response.body(), ApiResponse.class);
    }
}
