package com.everyonewatcheswomenssports.demo.controller;

import com.everyonewatcheswomenssports.demo.model.SportEvent;
import com.everyonewatcheswomenssports.demo.service.ScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class SportEventController {
    private final ScraperService scraperService;

    @Autowired
    public SportEventController(ScraperService scraperService) {
        this.scraperService = scraperService;
    }

    @GetMapping("/scrape/ncaa-womens-basketball")
    public ResponseEntity<List<SportEvent>> scrapeNcaaWomensBasketball() {
        List<SportEvent> events = scraperService.scrapeEvents("NCAA_WOMENS_BASKETBALL");
        if (events.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(events);
    }


}
