package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class LoadController {

	@RequestMapping("/load")
	public String index() {
		return "Greetings from Sampsoftware, Spring Boot + Tanzu, again";
	}
	@RequestMapping("/loadCPU")
	public String loadCPU() {
		int N=100;
		int num1 = 0, num2 = 1;
  
        int counter = 0;
  
		StringBuffer sb = new StringBuffer();
        // Iterate till counter is N
        while (counter < N) {
  
            // Print the number
            sb.append(num1 + "\n");
  
            // Swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }
		return sb.toString();
	}
	@RequestMapping("/loadMemory")
	public String loadMemory() {
		return "Greetings from Sampsoftware, Spring Boot + Tanzu, Again";
	}

}