package com.techprimers.stock.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.stock.dbservice.model.Quote;
import com.techprimers.stock.dbservice.model.Quotes;
import com.techprimers.stock.dbservice.repository.QuoteRepository;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

	private QuoteRepository quotesRepository;

	public DbServiceResource(QuoteRepository quoteRepository) {
                this.quotesRepository = quoteRepository;
	}

	@GetMapping("/{username}")
	public List<String> getQuotes(
			@PathVariable("username") final String username) {

		return quotesRepository.findByUserName(username).stream()
				.map(Quote::getQuote).collect(Collectors.toList());

	}
	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes) {
		quotes.getQuotes().stream().
		map(quote -> new Quote(quotes.getUserName(),quote)).
		forEach(quote -> quotesRepository.save(quote));
		
		return getQuotesByUserName(quotes.getUserName());
	}
    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username){
    	List<Quote> quotes = quotesRepository.findByUserName(username);
    	quotesRepository.delete(quotes);
    	return getQuotesByUserName(username);
    }
	
	private List<String> getQuotesByUserName(@PathVariable("username")String username){
		return quotesRepository.findByUserName(username).stream().map(Quote::getQuote).collect(Collectors.toList());
	}
}
