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
        return "div.game-detail";
    }

    @Override
    protected String getEventNameSelector() {
        return "span.team-names";
    }

    @Override
    protected String getEventTimeSelector() {
        return "span.game-time";
    }

    @Override
    protected String getEventNetworkSelector() {
        return "span.network-name";
    }

    @Override
    protected String getEventUrlSelector() {
        return "a.game-link";
    }
}
