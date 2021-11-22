package com.algaworks.algafoodapi.api.v1.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafoodapi.api.v1.model.UsuarioModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Restaurantes")
public interface RestauranteUsuarioRespControllerOpenApi {
	
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID informado inválido"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado")
	})
	@ApiOperation("Lista restaurantes por usuário")
    public CollectionModel<UsuarioModel> getAll(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId);

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Restaurante ou usuário não encontrado")
	})
	@ApiOperation("Associa restaurante para um usuário")
    public ResponseEntity<Void> associarResponsavel(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId, 
    		@ApiParam(value = "ID do usuário", required = true)
    		Long usuarioId);

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Restaurante ou usuário não encontrado")
	})
	@ApiOperation("Desassocia um restaurante de um usuário")
    public ResponseEntity<Void> desassociarResponsavel(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId, 
    		@ApiParam(value = "ID do usuário", required = true)
    		Long usuarioId);
	
}
