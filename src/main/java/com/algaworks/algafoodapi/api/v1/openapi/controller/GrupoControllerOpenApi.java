package com.algaworks.algafoodapi.api.v1.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafoodapi.api.v1.model.GrupoModel;
import com.algaworks.algafoodapi.api.v1.model.input.GrupoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Grupos")
public interface GrupoControllerOpenApi {
	
	@ApiOperation("Lista os grupos")
    public CollectionModel<GrupoModel> getAll();

	@ApiOperation("Obtém um grupo por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID do grupo inválido"),
		@ApiResponse(responseCode = "404", description = "Grupo não encontrado"),
	})
    public GrupoModel getById(Long grupoId);

	@ApiOperation("Cria um novo grupo")
    public GrupoModel create(GrupoInput grupoInput);

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Grupo não encontrado"),
	})
	@ApiOperation("Atualiza um grupo por ID")
    public GrupoModel update(Long grupoId, GrupoInput grupoInput);
   
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Grupo não encontrado"),
	})
	@ApiOperation("Remove uma cidade por ID")
    public void delete(Long grupoId);
	
}
