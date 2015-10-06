package com.helloApp.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

@Endpoint
public class CountryEndPoint {
	
	private static final String NAMESPACE_URI="http://spring.io/guides/gs-producing-web-service";
	private CountryRepo countryRepo;
	@Autowired
	public CountryEndPoint(CountryRepo countryRepo){
		this.countryRepo =countryRepo;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request){
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepo.findCountry(request.getName()));
		return response;
	}
}
