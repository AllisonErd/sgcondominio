package br.com.gna.sgcondominio.configuration.feign;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import feign.Logger;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CoreFeignConfiguration {

	private final ObjectFactory<HttpMessageConverters> messageConverters;

	@Bean
	@Primary
	public Encoder feignFormEncoder() {
		return new FormEncoder(new SpringEncoder(this.messageConverters));
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
