package com.everyonewatcheswomenssports.demo.service;

import com.everyonewatcheswomenssports.demo.model.SportEvent;
import com.everyonewatcheswomenssports.demo.scraper.CUWomensBasketballScraper;
import com.everyonewatcheswomenssports.demo.scraper.NcaaWomensBasketballTournamentScraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScraperService {
    private final NcaaWomensBasketballTournamentScraper ncaaScraper;
    private final CUWomensBasketballScraper cuScraper;

    @Autowired
    public ScraperService(NcaaWomensBasketballTournamentScraper ncaaScraper, CUWomensBasketballScraper cuScraper) {
        this.ncaaScraper = ncaaScraper;
        this.cuScraper = cuScraper;
    }

    public List<SportEvent> scrapeEvents(String eventType) {
        switch (eventType) {

            case "NCAA_WOMENS_BASKETBALL" :
                return ncaaScraper.scrapeSportsEvents();

            case "CU_WOMENS_BASKETBALL " :
                return cuScraper.scrapeSportsEvents();

            default:
                throw new IllegalArgumentException("Unsupported event type: " + eventType);
        }
    }
}
