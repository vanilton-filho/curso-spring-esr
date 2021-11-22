package com.algaworks.algafoodapi.api.v1.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafoodapi.api.v1.model.FormaPagamentoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Restaurantes")
public interface RestauranteFormaPagControllerOpenApi {
	
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID informado inválido"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado")
	})
	@ApiOperation("Lista formas de pagamento pelo ID do restaurante")
    public CollectionModel<FormaPagamentoModel> listar(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId);
	
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Restaurante ou forma de pagamento não encontrado")
	})
	@ApiOperation("Desassociar uma forma de pagamento ao restaurante")
    public ResponseEntity<Void> desassociar(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId, 
    		@ApiParam(value = "ID da forma de pagamento", required = true)
    		Long formaPagamentoId);

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Restaurante ou forma de pagamento não encontrado")
	})
	@ApiOperation("Associa uma forma de pagamento ao restaurante")
    public ResponseEntity<Void> associar(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId, 
    		@ApiParam(value = "ID da forma de pagamento", required = true)
    		Long formaPagamentoId);
	
}
