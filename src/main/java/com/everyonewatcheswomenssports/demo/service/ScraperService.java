package com.everyonewatcheswomenssports.demo.service;

import com.everyonewatcheswomenssports.demo.model.SportEvent;
import com.everyonewatcheswomenssports.demo.scraper.BaseSportsScraper;
import com.everyonewatcheswomenssports.demo.scraper.NcaaWomensBasketballTournamentScraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScraperService {
    private final NcaaWomensBasketballTournamentScraper ncaaScraper;

    @Autowired
    public ScraperService(NcaaWomensBasketballTournamentScraper ncaaScraper) {
        this.ncaaScraper = ncaaScraper;
    }

    public List<SportEvent> scrapeEvents(String eventType) {
        switch (eventType) {

            case "NCAA_WOMENS_BASKETBALL" :
                return ncaaScraper.scrapeSportsEvents();

            default:
                throw new IllegalArgumentException("Unsupported event type: " + eventType);
        }
    }
}
