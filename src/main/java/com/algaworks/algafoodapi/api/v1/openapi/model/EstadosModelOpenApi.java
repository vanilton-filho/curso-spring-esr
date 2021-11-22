package com.algaworks.algafoodapi.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafoodapi.api.v1.model.EstadoModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("EstadosModel")
@Data
public class EstadosModelOpenApi {
	
	private EstadoEmbeddedModelOpenApi _embedded;
	private Links _links;
	private PageModelOpenApi page;

	@ApiModel("EstadosEmbeddedModelOpenApi")
	@Data
	public class EstadoEmbeddedModelOpenApi {
		
		private List<EstadoModel> estados;
		
	}
	
}
