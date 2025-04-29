package com.nt.cms;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("PAYMENT-SERVICE")
public interface IPaymentServiceClient {
	
	@GetMapping("/payment/options")
	public ResponseEntity<String>   getPaymentChoices();

}
