package com.algaworks.algafoodapi.api.v1.openapi.controller;

import javax.validation.Valid;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.algaworks.algafoodapi.api.v1.model.CidadeModel;
import com.algaworks.algafoodapi.api.v1.model.CidadeResumoModel;
import com.algaworks.algafoodapi.api.v1.model.input.CidadeInput;
import com.algaworks.algafoodapi.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafoodapi.domain.exception.NegocioException;
import com.algaworks.algafoodapi.domain.model.Cidade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Cidades")
public interface CidadeControllerOpenApi {


    @ApiOperation("Lista as cidades")
    public CollectionModel<CidadeModel> getAll();

    @ApiResponses({
    	@ApiResponse(responseCode = "400", description = "ID da cidade inválido"),
    	@ApiResponse(responseCode = "404", description = "Cidade não econtrada")

    })
    @ApiOperation("Obtém uma cidade por ID")
    public CidadeModel getById(
    		@ApiParam(value = "ID de uma cidade", example = "1") 
    		Long cidadeId);

    @ApiOperation("Cria uma nova cidade")
    public CidadeModel add(CidadeInput cidade);
    
    @ApiResponses({
    	@ApiResponse(responseCode = "404", description = "Cidade não econtrada")
    })
    @ApiOperation("Atualiza uma cidade por ID")
    public ResponseEntity<?> set(
    		@ApiParam(value = "ID de uma cidade", example = "1")  
    		Long cidadeId, CidadeInput cidadeInput);

    @ApiResponses({
    	@ApiResponse(responseCode = "404", description = "Cidade não econtrada")
    })
    @ApiOperation("Remove uma cidade por ID")
    public void remove(
    	@ApiParam(value = "ID de uma cidade", example = "1") 
    	Long cidadeId);
}
