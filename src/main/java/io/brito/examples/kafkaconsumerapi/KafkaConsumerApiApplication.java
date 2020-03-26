package io.brito.examples.kafkaconsumerapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.net.InetAddress;

@SpringBootApplication
@EnableReactiveMongoRepositories
@Slf4j
public class KafkaConsumerApiApplication {

	private static final String ACCESS_URLS_MESSAGE_LOG =
			"\n\n Access URLs:\n----------------------------------------------------------\n\t External: \thttp://{}:{}/swagger-ui.html Profiles: {}\n----------------------------------------------------------\n";

	public static void main(final String[] args) {
		try {

			System.setProperty("spring.devtools.restart.enabled", "false");
			final SpringApplication app = new SpringApplication(KafkaConsumerApiApplication.class);
			final Environment env = app.run(args).getEnvironment();
			log.info(
					ACCESS_URLS_MESSAGE_LOG,
					InetAddress.getLocalHost().getHostAddress(),
					env.getProperty("server.port"),
					env.getActiveProfiles());

		} catch (Exception e) {
			log.error("Start Error.", e);
		}
	}
}
