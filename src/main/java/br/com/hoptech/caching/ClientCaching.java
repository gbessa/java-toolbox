package br.com.hoptech.caching;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.cache.CacheConfig;
import org.apache.http.impl.client.cache.CachingHttpClientBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class ClientCaching {

    public static void main(String[] args) {

        RestTemplate restConsumer = new RestTemplate();
        String fooResourceUrl = "https://www.swapi.tech/api/planets/1";
        ResponseEntity<String> response;

        //runRequest(restConsumer, fooResourceUrl);

        //if (true) return;

        /**
         * with caching
         * O RestTemplate não tem suporte a caching, mas ele aceita receber o HttpClient da Apache como parâmetro
         */
        long cacheExpireInSeconds = 60;
        CacheConfig cacheConfig = CacheConfig
                .custom().setHeuristicDefaultLifetime(cacheExpireInSeconds)
                .build();
        HttpClient cachingClient = CachingHttpClientBuilder
                .create()
                .setCacheConfig(cacheConfig)
                .build();
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(cachingClient);

        RestTemplate restConsumerWithCaching = new RestTemplate(requestFactory);

        runRequest(restConsumerWithCaching, fooResourceUrl);
        runRequest(restConsumerWithCaching, fooResourceUrl);
        try {
            Thread.sleep(75*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runRequest(restConsumerWithCaching, fooResourceUrl);
        //Observar que ele só vai printar <cache miss> na primeira chamada

    }

    static void runRequest(RestTemplate restConsumer, String url) {
        ResponseEntity<String> response;
        response = restConsumer.getForEntity(url, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(response.getBody());
        }
    }



}
