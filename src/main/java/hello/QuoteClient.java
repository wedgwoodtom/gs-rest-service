package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QuoteClient
{
    private static final Logger log = LoggerFactory.getLogger(QuoteClient.class);

    // TODO: get from props config
    private static final String SERVICE_URL = "http://gturnquist-quoters.cfapps.io/api/random";

    public Quote getRandomQuote()
    {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject(SERVICE_URL, Quote.class);
        log.info(quote.toString());
        return quote;
    }

}
