package com.algaworks.algafoodapi.api.v1.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafoodapi.api.v1.model.PermissaoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Grupos")
public interface GrupoPermissaoOpenApi {

	@ApiResponses({
		@ApiResponse(code = 400, message = "ID do grupo inválido"),
		@ApiResponse(code = 404, message = "Grupo não encontrado")
	})
	@ApiOperation(value = "Lista as permissões do grupo")
    public CollectionModel<PermissaoModel> getAll(
    		@ApiParam(value = "ID do grupo")
    		Long grupoId);

	@ApiResponses({
		@ApiResponse(code = 404, message = "Grupo ou permissão não encontrado")
	})
	@ApiOperation(value = "Desassocia um grupo de uma permissão")
    public void desassociar(
    		@ApiParam(value = "ID do grupo")
    		Long grupoId,
    		@ApiParam(value = "ID da permissão")
    		Long permissaoId);
  
	@ApiResponses({
		@ApiResponse(code = 404, message = "Grupo ou permissão não encontrado")
	})
	@ApiOperation(value = "Associa um grupo para uma permissão")
    public void associar(
    		@ApiParam(value = "ID do grupo")
    		Long grupoId,
    		@ApiParam(value = "ID do permissão")
    		Long permissaoId);
    
}
