package com.algaworks.algafoodapi.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafoodapi.api.v1.model.GrupoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Usuários")
public interface UsuarioGrupoControllerOpenApi {

	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID do usuário inválido"),
		@ApiResponse(responseCode = "404", description = "Usuário não encontrado")
	})
	@ApiOperation(value = "Lista todos os grupos do usuário por ID")
	public CollectionModel<GrupoModel> getAll(
			@ApiParam(value = "ID do usuário", example = "1", required = true)
			Long usuarioId);

	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID do usuário ou grupo inválido"),
		@ApiResponse(responseCode = "404", description = "Usuário ou grupo não encontrado")
	})
	@ApiOperation(value = "Associa um usuário para um grupo")
    public ResponseEntity<Void> associar(
    		@ApiParam(value = "ID do usuário", example = "1", required = true)
    		Long usuarioId,
    		@ApiParam(value = "ID do grupo", example = "1", required = true)
    		Long grupoId);

	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID do usuário ou grupo inválido"),
		@ApiResponse(responseCode = "404", description = "Usuário ou grupo não encontrado")
	})
	@ApiOperation(value = "Dessasocia um usuário de um grupo")
    public ResponseEntity<Void> desassociar(
    		@ApiParam(value = "ID do usuário", example = "1", required = true)
    		Long usuarioId,
    		@ApiParam(value = "ID do grupo", example = "1", required = true)
    		Long grupoId);
}
