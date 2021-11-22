package com.algaworks.algafoodapi.api.v1.openapi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;

import com.algaworks.algafoodapi.api.v1.model.CozinhaModel;
import com.algaworks.algafoodapi.api.v1.model.input.CozinhaInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Cozinhas")
public interface CozinhaControllerOpenApi {
	
	@ApiOperation("Lista as cozinhas")
    public PagedModel<CozinhaModel> getAll(Pageable pageable);

	@ApiOperation("Obtém cozinha por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID da cozinha inválido"),
		@ApiResponse(responseCode = "404", description = "Cozinha não encontrada")
	})
    public CozinhaModel getById(
    		@ApiParam(value = "ID de uma cozinha", example = "1")
    		Long cozinhaId);

	@ApiOperation("Adiciona uma nova cozinha")
    public CozinhaModel add(CozinhaInput cozinhaInput);

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Cozinha não encontrada")
	})
	@ApiOperation("Atualiza uma cozinha por ID")
    public CozinhaModel set(
    		@ApiParam(value = "ID de uma cozinha", example = "1")
    		Long cozinhaId, 
    		CozinhaInput cozinhaInput);

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Cozinha não encontrada")
	})
	@ApiOperation("Remove uma cozinha por ID")
    public void remove(
    		@ApiParam(value = "ID de uma cozinha", example = "1")
    		Long cozinhaId);
	
}
