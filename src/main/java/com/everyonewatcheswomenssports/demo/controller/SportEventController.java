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

    @GetMapping
    public ResponseEntity<List<SportEvent>> getAllEvents() {
        List<SportEvent> events = scraperService.getSportsEvents();

        if (events != null && !events.isEmpty()) {
            return ResponseEntity.ok(events);
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }
}
