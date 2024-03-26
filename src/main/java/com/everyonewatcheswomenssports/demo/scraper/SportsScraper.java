package com.everyonewatcheswomenssports.demo.scraper;

import com.everyonewatcheswomenssports.demo.model.SportEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component
public class SportsScraper {
    //todo potential check on the formatted time later on, may need updating if mismatched

    public List<SportEvent> scrapeSportsEvents(String url) {
        List<SportEvent> events = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();

            //select the container elements that include the events
            //adjust the css query to match the structure of your target website
            Elements eventElements = doc.select(".event-container");

            for (Element eventElement : eventElements) {
                //extract event details
                String eventName = eventElement.select(".event-name").text();
                String eventTime = eventElement.select(".event-time").text();
                String eventNetwork = eventElement.select(".event-network").text();
                String eventUrl = eventElement.select(".event-url a").attr("href");

                //create a new SportEvent object and add it to the list
                events.add(new SportEvent(eventName, eventTime, eventNetwork, eventUrl));
            }
        }
        catch (IOException e) {
            System.err.println("An error occurred while trying to connect to " + url);
            e.printStackTrace();
        }

        return events;

    }
}
