package com.jobly.joblybackend.scraper;

import com.jobly.joblybackend.models.entities.Job;
import com.jobly.joblybackend.services.domain.JobService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;


@Component
public class JoblyScraper {

    private final JobService jobService;

    public JoblyScraper(JobService jobService) {
        this.jobService = jobService;
    }

    public void scrapeVrabotuvanjeMK() throws IOException {
        String url = "https://www.vrabotuvanje.com.mk/prebaruvanje-na-rabotni-mesta?positions=%D0%98%D0%A2,+%D1%82%D0%B5%D0%BB%D0%B5%D0%BA%D0%BE%D0%BC%D1%83%D0%BD%D0%B8%D0%BA%D0%B0%D1%86%D0%B8%D0%B8&sortBy=adtype";
        Document doc = Jsoup.connect(url).get();

        Elements jobElements = doc.select(".job-card");
        System.out.println("Total jobs found: " + jobElements.size());

        for (Element jobEl : jobElements) {
            // Title
            Elements titleElements = jobEl.select("h3[data-test=job-card-content-title]");
            String title = titleElements.isEmpty() ? "Unknown" : titleElements.first().text();

            // Company
            Elements companyElements = jobEl.select(".logo-container__image");
            String company = companyElements.isEmpty() ? "Unknown" : companyElements.first().attr("alt");

            // Location
            Elements locationElements = jobEl.select(".content__info .info__child");
            String location = locationElements.isEmpty() ? "Unknown" : locationElements.first().text();

            // Job URL
            String jobUrl = "https://www.vrabotuvanje.mk" + jobEl.select("a").attr("href");

            // Valid until
            Element timeElement = jobEl.selectFirst("span.info__child.info__end-date time");
            LocalDate validUntil = null;
            if (timeElement != null) {
                String datetime = timeElement.attr("datetime"); // "2026-03-10T22:59:59.000Z"
                validUntil = OffsetDateTime.parse(datetime).toLocalDate();
            }

            Job job = new Job(
                    title,
                    company,
                    location,
                    "",
                    "Vrabotuvanje.mk",
                    validUntil,
                    jobUrl
            );

            jobService.save(job);
        }
    }
}
