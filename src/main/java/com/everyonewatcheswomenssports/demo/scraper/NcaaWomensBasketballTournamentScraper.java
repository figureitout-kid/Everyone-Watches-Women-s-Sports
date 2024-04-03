package com.everyonewatcheswomenssports.demo.scraper;

import org.springframework.stereotype.Component;

@Component
public class NcaaWomensBasketballTournamentScraper extends BaseSportsScraper {
    @Override
    protected  String getUrl() {
        return "https://www.ncaa.com/news/basketball-women/article/2024-04-01/2024-march-madness-womens-ncaa-tournament-schedule-dates-times";
    }

    @Override
    protected String getEventContainerSelector() {
        return ".event-container";
    }

    @Override
    protected String getEventNameSelector() {
        return "h4.event-name";
    }

    @Override
    protected String getEventTimeSelector() {
        return ".event-time";
    }

    @Override
    protected String getEventNetworkSelector() {
        return ".event-network";
    }

    @Override
    protected String getEventUrlSelector() {
        return "a.event-link";
    }
}
