package com.algaworks.algafoodapi.api.v2.openapi.controller;



import com.algaworks.algafoodapi.api.v2.model.CidadeModelV2;
import com.algaworks.algafoodapi.api.v2.model.input.CidadeInputV2;




import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Cidades")
public interface CidadeControllerOpenApiV2 {


    @ApiOperation("Lista as cidades")
    public CollectionModel<CidadeModelV2> getAll();

    @ApiResponses({
    	@ApiResponse(responseCode = "400", description = "ID da cidade inválido"),
    	@ApiResponse(responseCode = "404", description = "Cidade não econtrada")

    })
    @ApiOperation("Obtém uma cidade por ID")
    public CidadeModelV2 getById(
    		@ApiParam(value = "ID de uma cidade", example = "1") 
    		Long cidadeId);

    @ApiOperation("Cria uma nova cidade")
    public CidadeModelV2 add(CidadeInputV2 cidade);
    
    @ApiResponses({
    	@ApiResponse(responseCode = "404", description = "Cidade não econtrada")
    })
    @ApiOperation("Atualiza uma cidade por ID")
    public ResponseEntity<?> set(
    		@ApiParam(value = "ID de uma cidade", example = "1")  
    		Long cidadeId, CidadeInputV2 cidadeInput);

    @ApiResponses({
    	@ApiResponse(responseCode = "404", description = "Cidade não econtrada")
    })
    @ApiOperation("Remove uma cidade por ID")
    public void remove(
    	@ApiParam(value = "ID de uma cidade", example = "1") 
    	Long cidadeId);
}

