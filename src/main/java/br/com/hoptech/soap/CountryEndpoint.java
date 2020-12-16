package br.com.hoptech.soap;
/*
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

// Registers the class with Spring WS as a potential candidate for processing incoming SOAP messages
@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private final CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        //System.out.println("@Autowired CountryEndpoint");
        this.countryRepository = countryRepository;
    }

    // is then used by Spring WS to pick the handler method, based on the message’s namespace and localPart
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    // makes Spring WS map the returned value to the response payload
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) { // indicates that the incoming message will be mapped to the method’s request parameter
        //System.out.println(request.toString());
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }

}

 */
