package com.everyonewatcheswomenssports.demo.service;

import com.everyonewatcheswomenssports.demo.model.SportEvent;
import com.everyonewatcheswomenssports.demo.scraper.SportsScraper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScraperService {
    private final SportsScraper sportsScraper;

    public ScraperService(SportsScraper sportsScraper) {
        this.sportsScraper = sportsScraper;
    }

    public List<SportEvent> getSportsEvents() {
        try {
            return sportsScraper.scrapeSportsEvents("https://example.com");
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
