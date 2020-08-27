package com.bookrepository.core.apirequests;
//https://dzone.com/articles/how-to-implement-get-and-post-request-through-simp
//https://javadevblog.com/primer-raboty-s-json-simple-v-java-parsing-i-sozdanie-json.html

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class QuoteService {

    @Value("${quote.urls.random-quote}")
    private String url;
//    @JsonProperty("en")
//    private String englishString;
//    не подскажите можно ли @JsonProperty("en") в моем случае сделать на 43 строке?

    public QuoteRequest getUrlApiRandomRequest() throws IllegalAccessException {
        try {
            URL urlForGetRequest = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();

            StringBuffer response = new StringBuffer();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String readLine = null;
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                while ((readLine = reader.readLine()) != null) {
                    response.append(readLine);
                }
                reader.close();

                JSONObject receivedJson = (JSONObject) JSONValue.parseWithException(String.valueOf(response));
                QuoteRequest quoteRequest = new QuoteRequest();
                quoteRequest.setDescription(receivedJson.get("en").toString());
                return quoteRequest;
            } else {
                throw new IllegalAccessException("Api Random Request does not executed. HttpURLConnection problem");
            }
        } catch (IOException | ParseException e) {
            throw new IllegalAccessException("Api Random Request does not executed:" + e.getMessage());
        }
    }

}
