package com.bookrepository.book.restapi;
//https://dzone.com/articles/how-to-implement-get-and-post-request-through-simp
//https://javadevblog.com/primer-raboty-s-json-simple-v-java-parsing-i-sozdanie-json.html

import com.bookrepository.core.exceptions.TechnicalException;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ApiRequests {

    public RestApiData getApiRequest() {
        try {
            URL urlForGetRequest = new URL("https://programming-quotes-api.herokuapp.com/quotes/random");
            HttpURLConnection connection = null;
            connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
//        connection.setRequestProperty("userId", "a1bcdef"); // set userId in a easy way

            StringBuffer response = new StringBuffer();
            String readLine = null;
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }
                in.close();

                JSONObject getRequest = (JSONObject) JSONValue.parseWithException(String.valueOf(response));
                RestApiData apiData = new RestApiData();
                apiData.setDescription(getRequest.get("en").toString());
                return apiData;
            } else {
                throw new TechnicalException("ApiRequests does not executed. HttpURLConnection problem");
            }
        } catch (IOException | ParseException e) {
            throw new TechnicalException("ApiRequests does not executed:" + e.getMessage());
        }
    }

}
