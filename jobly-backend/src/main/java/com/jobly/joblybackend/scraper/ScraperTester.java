package com.jobly.joblybackend.scraper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ScraperTester implements CommandLineRunner {

    private final JoblyScraper joblyScraper;

    public ScraperTester(JoblyScraper joblyScraper) {
        this.joblyScraper = joblyScraper;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting scraper test...");
        joblyScraper.scrapeVrabotuvanjeMK();
        System.out.println("Scraper test finished!");
    }
}
