package br.com.mbragariano.gobeautyapi.common.persistence.configurations;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDbConfiguration {

	@Bean
	public MongoClient mongoClient() {
		final var connectionString = new ConnectionString("mongodb://127.0.0.1:27017/go-beauty-api");
		final var mongoClientSettings = MongoClientSettings.builder()
			.applyConnectionString(connectionString)
			.build();

		return MongoClients.create(mongoClientSettings);
	}

	@Bean
	public MongoTemplate mongoTemplate(final MongoClient mongoClient) {
		return new MongoTemplate(mongoClient, "go-beauty-api");
	}

}
