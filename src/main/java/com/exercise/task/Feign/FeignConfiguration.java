package com.exercise.task.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.exercise.task.dto.response.CepResponse;


@FeignClient(name = "viacep", url="https://viacep.com.br")
public interface FeignConfiguration {
	@GetMapping("/ws/{cep}/json")
	public CepResponse validaCep(@PathVariable(name = "cep", required = true) String nome);

}
