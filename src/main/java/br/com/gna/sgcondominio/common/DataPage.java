package br.com.gna.sgcondominio.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataPage<T> {

	@JsonProperty("data")
	private T data;

	@JsonProperty("total_elements")
	private Long totalElements;

	@JsonProperty("total_pages")
	private Integer totalPages;
}
