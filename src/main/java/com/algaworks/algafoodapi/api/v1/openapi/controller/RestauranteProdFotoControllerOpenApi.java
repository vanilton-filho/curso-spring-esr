package com.algaworks.algafoodapi.api.v1.openapi.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.algafoodapi.api.v1.model.FotoProdutoModel;
import com.algaworks.algafoodapi.api.v1.model.input.FotoProdutoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Produtos")
public interface RestauranteProdFotoControllerOpenApi {


	@ApiOperation("Atualiza a foto do produto de um restaurante")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Produto de restaurante não encontrado")
	})
	FotoProdutoModel atualizarFoto(
			@ApiParam(value = "ID do restaurante", example = "1", required = true)
			Long restauranteId,
			
			@ApiParam(value = "ID do produto", example = "1", required = true)
			Long produtoId,
			
			FotoProdutoInput fotoProdutoInput,
			
			@ApiParam(value = "Arquivo da foto do produto (máximo 500KB, apenas JPG e PNG)",
				required = true)
			MultipartFile arquivo) throws IOException;

	@ApiOperation("Exclui a foto do produto de um restaurante")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID do restaurante ou produto inválido"),
		@ApiResponse(responseCode = "404", description = "Foto de produto não encontrada")
	})
	void excluir(
			@ApiParam(value = "ID do restaurante", example = "1", required = true)
			Long restauranteId,
			
			@ApiParam(value = "ID do produto", example = "1", required = true)
			Long produtoId);

	@ApiOperation(value = "Busca a foto do produto de um restaurante",
			produces = "application/json, image/jpeg, image/png")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID do restaurante ou produto inválido"),
		@ApiResponse(responseCode = "404", description = "Foto de produto não encontrada")
	})
	FotoProdutoModel buscar(
			@ApiParam(value = "ID do restaurante", example = "1", required = true)
			Long restauranteId,
			
			@ApiParam(value = "ID do produto", example = "1", required = true)
			Long produtoId);

	@ApiOperation(value = "Busca a foto do produto de um restaurante", hidden = true)
	ResponseEntity<?> servir(Long restauranteId, Long produtoId, 
			String acceptHeader) 
			throws HttpMediaTypeNotAcceptableException;
	
}
