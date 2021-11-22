package com.algaworks.algafoodapi.api.v1.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafoodapi.api.v1.model.ProdutoModel;
import com.algaworks.algafoodapi.api.v1.model.input.ProdutoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Produtos")
public interface RestauranteProdutoControllerOpenApi {
	

	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID informado inválido"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(
				value = "Incluir ou não produtos ativos",
				name = "incluirInativos",
				paramType = "query",
				dataTypeClass = Boolean.class)
	})
	@ApiOperation("Listar produtos dos restaurantes")
    public CollectionModel<ProdutoModel> getAll(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId, 
    		Boolean incluirInativos);

	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID do restaurante ou produto informado inválido"),
		@ApiResponse(responseCode = "404", description = "Restaurante ou produto não encontrado")
	})
	@ApiOperation("Buscar produto por restaurante")
    public ProdutoModel getById(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId, 
    		@ApiParam(value = "ID do produto", required = true)
    		Long produtoId);

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado")
	})
	@ApiOperation("Cria um novo produto para o restaurante")
    public ProdutoModel create(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId, 
    		ProdutoInput produtoInput);

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Restaurante ou produto não encontrado")
	})
	@ApiOperation("Atualiza um produto do restaurante")
    public ProdutoModel update(
    		@ApiParam(value = "ID do restaurante", required = true)
    		Long restauranteId, 
    		@ApiParam(value = "ID do produto", required = true)
    		Long produtoId, ProdutoInput produtoInput);
	
}
