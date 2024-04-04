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
public abstract class BaseSportsScraper {
    //todo potential check on the formatted time later on, may need updating if mismatched

    protected abstract String getUrl();
    private static final Logger log = LoggerFactory.getLogger(BaseSportsScraper.class);

    public List<SportEvent> scrapeSportsEvents() {
        List<SportEvent> events = new ArrayList<>();
        String url = getUrl();

        try {
            Document doc = Jsoup.connect(url).get();

            //select the container elements that include the events
            //adjust the css query to match the structure of your target website
            Elements eventElements = doc.select(getEventContainerSelector());

            for (Element eventElement : eventElements) {
                //extract event details
                String eventName = eventElement.select(getEventNameSelector()).attr("title");
                String eventTime = eventElement.select(getEventTimeSelector()).text();
                String eventNetwork = eventElement.select(getEventNetworkSelector()).text();
//                String eventUrl = eventElement.select(getEventUrlSelector()).attr("href");

                //create a new SportEvent object and add it to the list
                events.add(new SportEvent(eventName, eventTime, eventNetwork));
            }
        }
        catch (IOException e) {
            log.error("An error occurred while trying to connect to " + url, e);
        }

        return events;

    }

    //abstract methods for selectors that subclasses need to implement
    protected abstract String getEventContainerSelector();
    protected abstract String getEventNameSelector();
    protected abstract String getEventTimeSelector();
    protected abstract String getEventNetworkSelector();
//    protected abstract String getEventUrlSelector();

}
