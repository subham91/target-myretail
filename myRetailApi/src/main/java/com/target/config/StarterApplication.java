package com.target.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

import com.target.domain.ProductPrice;
import com.target.repository.ProductPriceRepository;

@SpringBootApplication
@EnableMongoRepositories("com.target.repository")
@ComponentScan(basePackages = "com.target")
public class StarterApplication implements CommandLineRunner {

	@Autowired
	ProductPriceRepository priceRepository;

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public void run(String... arg0) throws Exception {
		ProductPrice productPrice = new ProductPrice(13860428L, 13.89D, "USD");
		priceRepository.save(productPrice);

	}

}
