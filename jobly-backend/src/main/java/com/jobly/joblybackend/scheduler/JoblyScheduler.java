package com.jobly.joblybackend.scheduler;

import com.jobly.joblybackend.scraper.JoblyScraper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JoblyScheduler {

    private final JoblyScraper joblyScraper;

    public JoblyScheduler(JoblyScraper joblyScraper) {
        this.joblyScraper = joblyScraper;
    }

    @Scheduled(fixedRate = 5 * 60 * 1000)
    public void runScraper() {
        try {
            joblyScraper.scrapeVrabotuvanjeMK();
        } catch (Exception e) {
            System.err.println("Error scraping Vrabotuvanje.mk" + e.getMessage());
            e.printStackTrace();
        }
    }
}
