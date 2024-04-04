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
                String eventName = getEventName(eventElement);
                String eventTime = getEventTime(eventElement);
                String eventNetwork = getEventNetwork(eventElement);
//                String eventUrl = eventElement.select(getEventUrlSelector()).attr("href");
                //above is commented out, pausing on grabbing network urls right now, potentially creating a database?

                //check for null or empty values and apply defaults
                if (eventName == null || eventName.isEmpty()) eventName = "Unknown Event";
                if (eventTime == null || eventTime.isEmpty()) eventName = "TBD";
                if (eventNetwork == null || eventNetwork.isEmpty()) eventName = "TBD";

                //create a new SportEvent object and add it to the list
                events.add(new SportEvent(eventName, eventTime, eventNetwork));
            }
        }
        catch (IOException e) {
            log.error("An error occurred while trying to connect to " + url, e);
        }

        return events;

    }

    //Helper methods to handle extraction and null checks
    private String getEventName(Element eventElement) {
        return eventElement.select(getEventNameSelector()).attr("title");
    }

    private String getEventTime(Element eventElement) {
        return eventElement.select(getEventTimeSelector()).text();
    }

    private String getEventNetwork(Element eventElement) {
        return eventElement.select(getEventNetworkSelector()).text();
    }

    //abstract methods for selectors that subclasses need to implement
    protected abstract String getEventContainerSelector();
    protected abstract String getEventNameSelector();
    protected abstract String getEventTimeSelector();
    protected abstract String getEventNetworkSelector();
//    protected abstract String getEventUrlSelector();

}
