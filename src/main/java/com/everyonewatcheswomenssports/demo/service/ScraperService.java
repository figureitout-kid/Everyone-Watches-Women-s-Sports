package com.everyonewatcheswomenssports.demo.service;

import com.everyonewatcheswomenssports.demo.model.SportEvent;
import com.everyonewatcheswomenssports.demo.scraper.BaseSportsScraper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScraperService {
    private final BaseSportsScraper baseSportsScraper;

    public ScraperService(BaseSportsScraper baseSportsScraper) {
        this.baseSportsScraper = baseSportsScraper;
    }

    public List<SportEvent> getSportsEvents() {
        try {
            return baseSportsScraper.scrapeSportsEvents("https://example.com");
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
