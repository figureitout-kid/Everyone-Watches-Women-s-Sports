package com.everyonewatcheswomenssports.demo.scraper;

import org.springframework.stereotype.Component;
@Component
public class CUWomensBasketballScraper extends BaseSportsScraper {

    @Override
    protected  String getUrl() {
        return "https://cubuffs.com/sports/womens-basketball/schedule";
    }

    @Override
    protected String getEventContainerSelector() {
        return "div.game-card";
    }

    @Override
    protected String getEventNameSelector() {
        return "a[title]";
    }

    @Override
    protected String getEventTimeSelector() {
        return "svg + span";
    }

    @Override
    protected String getEventNetworkSelector() {
        return "div.game-card_header_tv";
    }

//    @Override
//    protected String getEventUrlSelector() {
//        return "";
//    }
}
