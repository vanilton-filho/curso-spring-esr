package com.algaworks.algafoodapi.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafoodapi.api.v1.model.CozinhaModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("CozinhasModel")
@Data
public class CozinhasModelOpenApi {

	private CozinhaEmbeddedModelOpenApi _embedded;
	private Links _links;
	private PageModelOpenApi page;
	
	@ApiModel("CozinhasEmbeddedModel")
	@Data
	private class CozinhaEmbeddedModelOpenApi {
		
		private List<CozinhaModel> cozinhas;
	}
	
}
