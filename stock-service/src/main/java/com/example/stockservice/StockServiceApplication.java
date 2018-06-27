package com.example.stockservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
*/


//@EnableHystrix
//@EnableHystrixDashboard
//@EnableCircuitBreaker
//@EnableEurekaClient
@SpringBootApplication
public class StockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}
	/*@RestController
	@RefreshScope
	class MessageSource {

		@Value("${message}")
		String message;

		@RequestMapping(value="/message")
		public String messsage() {
			return message;
		}
	}*/
}
