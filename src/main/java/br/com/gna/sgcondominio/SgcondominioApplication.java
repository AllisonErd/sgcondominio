package br.com.gna.sgcondominio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "br.com.gna.sgcondominio")
@EnableFeignClients
public class SgcondominioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgcondominioApplication.class, args);
	}

}
