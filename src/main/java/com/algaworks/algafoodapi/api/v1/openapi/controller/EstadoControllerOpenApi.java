package com.algaworks.algafoodapi.api.v1.openapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.RequestBody;

import com.algaworks.algafoodapi.api.v1.model.EstadoModel;
import com.algaworks.algafoodapi.api.v1.model.input.EstadoInput;
import com.algaworks.algafoodapi.domain.model.Estado;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Estados")
public interface EstadoControllerOpenApi {
	
	@ApiOperation("Lista os estados")
    public CollectionModel<EstadoModel> getAll();
    
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Estado não encontrado"),
		@ApiResponse(responseCode = "400", description = "ID informado inválido")
	})
	@ApiOperation("Busca um estado por ID")
    public EstadoModel getById(
    		@ApiParam(value = "ID do estado", required = true)
    		Long estadoId);

	@ApiOperation("Cria um novo estado")
    public EstadoModel add(EstadoInput estadoInput);
    
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Estado não encontrado")
	})
	@ApiOperation("Atualiza um estado por ID")
    public EstadoModel set(
    		@ApiParam(value = "ID do estado", required = true)
    		Long estadoId, EstadoInput estadoInput);

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Estado não encontrado")
	})
	@ApiOperation("Remove um estado por ID")
    public void remove(
    		@ApiParam(value = "ID do estado", required = true)
    		Long estadoId);
    
}
