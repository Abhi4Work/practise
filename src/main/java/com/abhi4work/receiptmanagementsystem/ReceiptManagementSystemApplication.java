package com.abhi4work.receiptmanagementsystem;

import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ReceiptManagementSystemApplication
{
	@Value("${logging.config:/opt/abhi4work/conf/receipt-management/log4j2.properties}")
	private String log4j2Path;

	public static void main(String[] args)
	{

		SpringApplication.run(ReceiptManagementSystemApplication.class, args);
	}

	public void setUp(){
		Configurator.initialize(null,log4j2Path);
	}

}
