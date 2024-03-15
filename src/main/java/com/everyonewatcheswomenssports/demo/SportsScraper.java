package com.everyonewatcheswomenssports.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SportsScraper {
    //todo implement website/s url to scrape from. These are base outlines for setting things up for the scraper
    //todo do we need multiple scrapers to utilize multiple websites? what is best practice here?

    public void scrapeSportsEvents() {
        try {
            Document doc = Jsoup.connect("").get();
            //selecting elements using a css query
            Elements events = doc.select(".event-details");

            for (Element event : events) {
                String eventName = event.select(".event-name").text();
                String eventTime = event.select(".event-time").text();
                String eventNetwork = event.select(".event-network").text();

                System.out.println(eventName + " at " + eventTime);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
