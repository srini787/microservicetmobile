package com.example.eurekaservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
/*import yahoofinance.Stock;
 import yahoofinance.YahooFinance;*/

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
@RestController
@RequestMapping("/rest/stock")
public class TestResource {

	@Autowired
	RestTemplate restTemplate;
	//@HystrixCommand(fallbackMethod="fallBackHello",commandKey="hello",groupKey="hello" )
	@RequestMapping( value ="test32", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getTest() {
	System.out.println("We are here::::::");
	return "hello:::";
	}
	public String fallBackHello(){
		return "Falling back::::::";
	}
    }
