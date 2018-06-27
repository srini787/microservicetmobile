package com.example.stockservice.resource;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.stockservice.model.Stock;
/*import yahoofinance.Stock;
 import yahoofinance.YahooFinance;*/
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

//import org.springframework.web.bind.annotation.GetMapping;

@Component
@RestController
@RequestMapping("/rest/stock")
public class StockResource {
	
	@Autowired
	RestTemplate restTemplate;
	
	/*@Value("${message}")
	String message;

	@RequestMapping(value = "/{message}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getConfigMessage() {
		
		return message;
	}*/

	//@HystrixCommand(fallbackMethod = "defaultCallForGetStock")
	/*@RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Quote> getStock(@PathVariable("username") final String username) {

		ResponseEntity<List<String>> quoteResponse = restTemplate.exchange(

		"http://localhost:8761/api/db-service/rest/db/" + username,
				HttpMethod.GET, null,
				new ParameterizedTypeReference<List<String>>() {
				});
		List<String> quotes = quoteResponse.getBody();
		return quotes.stream().map(quote -> {
			Stock stock = getStockPrice(quote);
			return new Quote(quote, stock.getPrice());
		}).collect(Collectors.toList());
	}*/

	public List<Quote> defaultCallForGetStock(
			@PathVariable("username") final String username) {
		System.out
				.println("In the fall back method..connecting to the other server which is up and running::::");
		return new ArrayList<Quote>();
	}

	private Stock getStockPrice(String quote) {
		Stock st = null;
		try {
			BigInteger bigInt = new BigInteger("233233233233");
			int scale = 2;
			BigDecimal bigDecimal = new BigDecimal(bigInt, scale);
			st = new Stock("GOOGLE", bigDecimal);
			return st;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}

	private class Quote {
		String quote;

		public String getQuote() {
			return quote;
		}

		public void setQuote(String quote) {
			this.quote = quote;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		BigDecimal price;

		public Quote(String quote, BigDecimal price) {
			this.quote = quote;
			this.price = price;
		}

	}
}
