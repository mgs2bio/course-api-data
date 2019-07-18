package io.javabrains.profiles;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("prod")
public class ProductionDatasourceConfig implements DatasourceConfig {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@PostConstruct
	@Override
	public void setup() {
		System.out.println("Setting up datasource for PROD environment. ");

	}
}
