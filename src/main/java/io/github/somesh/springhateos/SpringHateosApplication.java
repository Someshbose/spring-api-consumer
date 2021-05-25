package io.github.somesh.springhateos;

import io.github.somesh.springhateos.app.ApiConsumer;
import io.github.somesh.springhateos.app.OAuthApiConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringHateosApplication implements CommandLineRunner {

	@Autowired
	private ApiConsumer service;

	@Autowired
	private OAuthApiConsumer consumer;

	public static void main(String[] args) {
		SpringApplication.run(SpringHateosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(service.getSampleApi(sc.nextInt()));
			System.out.println(consumer.getOauthResponse().getAccesToken());
		}
	}
}
