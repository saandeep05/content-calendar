package com.saandeep.contentcalendar;

import com.saandeep.contentcalendar.model.Content;
import com.saandeep.contentcalendar.model.Status;
import com.saandeep.contentcalendar.model.Type;
import com.saandeep.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ContentCalendarApplication.class, args);
		System.out.println("Server is running...");
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repo) {
		return args -> {
			// Insert data into database
			Content content = new Content(
					null,
					"ChatGPT",
					"Info about chatGPT",
					Status.IDEA,
					Type.ARTICLE,
					LocalDateTime.now(),
					null,
					null
			);
			repo.save(content);
		};
	}

}
