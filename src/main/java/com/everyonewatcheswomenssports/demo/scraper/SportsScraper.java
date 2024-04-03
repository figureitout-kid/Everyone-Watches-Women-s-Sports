package com.everyonewatcheswomenssports.demo.scraper;

import com.everyonewatcheswomenssports.demo.model.SportEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
public class SportsScraper {
    //todo potential check on the formatted time later on, may need updating if mismatched
    private static final Logger log = LoggerFactory.getLogger(SportsScraper.class);

    @Value("${scraper.event-container-selector}")
    private String eventContainerSelector;

    @Value("${scraper.event-name-selector}")
    private String eventNameSelector;

    @Value("${scraper.event-time-selector}")
    private String eventTimeSelector;

    @Value("${scraper.event-network-selector}")
    private String eventNetworkSelector;

    @Value("${scraper.event-url-selector}")
    private String eventUrlSelector;


    public List<SportEvent> scrapeSportsEvents(String url) {
        List<SportEvent> events = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();

            //select the container elements that include the events
            //adjust the css query to match the structure of your target website
            Elements eventElements = doc.select(".event-container");

            for (Element eventElement : eventElements) {
                //extract event details
                String eventName = eventElement.select(eventNameSelector).text();
                String eventTime = eventElement.select(eventTimeSelector).text();
                String eventNetwork = eventElement.select(eventNetworkSelector).text();
                String eventUrl = eventElement.select(eventUrlSelector).attr("href");

                //create a new SportEvent object and add it to the list
                events.add(new SportEvent(eventName, eventTime, eventNetwork, eventUrl));
            }
        }
        catch (IOException e) {
            log.error("An error occurred while trying to connect to " + url, e);
        }

        return events;

    }
}
