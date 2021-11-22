package com.algaworks.algafoodapi.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafoodapi.api.v1.model.FormaPagamentoModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("FormasPagamentoModel")
@Data
public class FormasPagamentoModelOpenApi {
	
	private FormaPagamentoEmbeddedModelOpenApi _embedded;
	private Links _links;
	
	@ApiModel("FormasPagamentoEmbeddedModel")
	@Data
	public class FormaPagamentoEmbeddedModelOpenApi {
		
		private List<FormaPagamentoModel> formasPagamento;
		
	}
	
}
