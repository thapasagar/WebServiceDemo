package com.helloApp.app;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;

@Component
public class CountryRepo {
	public static final List<Country> countries = new ArrayList<Country>();
	
	@PostConstruct
	public void initData(){
		Country Nepal = new Country();
		Nepal.setName("Nepal");
		Nepal.setCapital("Kathmandu");
		Nepal.setCurrency(Currency.EUR);
		Nepal.setPopulation(30000000);
		
		countries.add(Nepal);
		
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setCurrency(Currency.EUR);
		spain.setPopulation(46704314);

		countries.add(spain);

		Country poland = new Country();
		poland.setName("Poland");
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setPopulation(38186860);

		countries.add(poland);

		Country uk = new Country();
		uk.setName("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setPopulation(63705000);

		countries.add(uk);
	}
	
	public Country findCountry(String Name){
		Assert.notNull(Name);
		Country result = null;
		
		for(Country country: countries){
			if(Name.equals(country.getName())){
				result = country;
			}
		}
		
		return result;
	}
	
}
