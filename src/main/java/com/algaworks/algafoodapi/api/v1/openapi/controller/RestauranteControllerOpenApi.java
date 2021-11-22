package com.algaworks.algafoodapi.api.v1.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafoodapi.api.v1.model.RestauranteApenasNomeModel;
import com.algaworks.algafoodapi.api.v1.model.RestauranteBasicModel;
import com.algaworks.algafoodapi.api.v1.model.RestauranteModel;
import com.algaworks.algafoodapi.api.v1.model.input.RestauranteInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "Restaurantes")
public interface RestauranteControllerOpenApi {
	
    public CollectionModel<RestauranteBasicModel> listar();

   
	@ApiOperation(value = "Lista restaurantes", hidden = true)
    public CollectionModel<RestauranteApenasNomeModel> listarApenasNome();

	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID informado inválido"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado")
	})
	@ApiOperation("Busca um restaurante por ID")
    public RestauranteModel buscar(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId);

	@ApiOperation("Cria um novo restaurante")
    public RestauranteModel adicionar(RestauranteInput restauranteInput);

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado")
	})
	@ApiOperation("Atualiza um restaurante por ID")
    public RestauranteModel atualizar(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId, RestauranteInput restauranteInput);

	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID informado inválido"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado")
	})
	@ApiOperation("Remove um restaurante")
    public void remover(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId);

	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID informado inválido"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado")
	})
	@ApiOperation("Ativa um restaurante por ID")
    public ResponseEntity<Void> ativar(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId);
 
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID informado inválido"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado")
	})
	@ApiOperation("Desativa um restaurante por ID")
    public ResponseEntity<Void> inativar(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId);

	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID informado inválido"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado")
	})
	@ApiOperation("Abre um retaurante por ID")
    public ResponseEntity<Void> abertura(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId);
    
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID informado inválido"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado")
	})
	@ApiOperation("Fecha um restaurante por ID")
    public ResponseEntity<Void> fechamento(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId);

	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID informado inválido"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado")
	})
	@ApiOperation("Ativa múltiplos restaurantes por ID")
    public void ativarMultiplos(
    		@ApiParam(example = "[2, 3, 7]")
    		List<Long> restauranteIds);

	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID informado inválido"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado")
	})
	@ApiOperation("Inativa múltiplos restaurantes por ID")
    public void inativarMultiplos(
    		@ApiParam(example = "[2, 3, 7]")
    		List<Long> restauranteIds);

}
