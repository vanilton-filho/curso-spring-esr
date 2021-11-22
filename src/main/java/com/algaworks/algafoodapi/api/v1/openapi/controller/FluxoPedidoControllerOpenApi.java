package com.algaworks.algafoodapi.api.v1.openapi.controller;


import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Pedidos")
public interface FluxoPedidoControllerOpenApi {

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Pedido não encontrado")
	})
	@ApiOperation("Confirma um pedido pelo código")
    public ResponseEntity<Void> confirmar(
    		@ApiParam(value = "Código do pedido", required = true)
    		String codigo);

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Pedido não encontrado")
	})
	@ApiOperation("Cancela um pedido pelo código")
    public ResponseEntity<Void> cancelar(
    		@ApiParam(value = "Código do pedido", required = true)
    		String codigo);

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Pedido não encontrado")
	})
	@ApiOperation("Registra a entrega do pedido pelo código")
    public ResponseEntity<Void> entregar(
    		@ApiParam(value = "Código do pedido", required = true)
    		String codigo);
	
}
