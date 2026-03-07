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
import java.time.format.DateTimeParseException;

@Component
public class JoblyScraper {

    private final JobService jobService;

    public JoblyScraper(JobService jobService) {
        this.jobService = jobService;
    }

    public void scrapeVrabotuvanjeMK() throws IOException {
        String url = "https://www.vrabotuvanje.mk/";
        Document doc = Jsoup.connect(url).get();

        Elements jobElements = doc.select(".job-card");
        System.out.println("Total jobs found: " + jobElements.size());

        for (Element jobEl : jobElements) {
            String title = jobEl.select("h3[data-test=job-card-content-title]").text();
            String company = jobEl.select(".logo-container__image").attr("alt");
            String location = jobEl.select(".content__info .info__child").first().text();
            String jobUrl = "https://www.vrabotuvanje.mk" + jobEl.select("a").attr("href");

            Element timeElement = jobEl.selectFirst("span.info__child.info__end-date time");
            LocalDate validUntil = null;

            if (timeElement != null) {
                String datetime = timeElement.attr("datetime"); // "2026-03-10T22:59:59.000Z"
                validUntil = OffsetDateTime.parse(datetime).toLocalDate();
            } else {
                System.out.println("No validUntil date for job: " + title);
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

            System.out.println("Saving job: " + job.getTitle() + " | " + job.getCompany() + " | " + job.getUrl());

            if (!jobService.existsByUrl(jobUrl)) {
                jobService.save(job);
            }
        }
    }
}
