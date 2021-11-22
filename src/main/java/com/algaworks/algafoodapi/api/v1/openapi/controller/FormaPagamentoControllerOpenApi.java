package com.algaworks.algafoodapi.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import com.algaworks.algafoodapi.api.v1.model.FormaPagamentoModel;
import com.algaworks.algafoodapi.api.v1.model.input.FormaPagamentoInput;
import com.algaworks.algafoodapi.api.v1.openapi.model.FormasPagamentoModelOpenApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Formas Pagamento")
public interface FormaPagamentoControllerOpenApi {
	
	
	@ApiOperation(value = "Lista as formas de pagamento", response = FormasPagamentoModelOpenApi.class)
    public ResponseEntity<CollectionModel<FormaPagamentoModel>> getAll(ServletWebRequest request);
    
	@ApiOperation("Obtém forma de pagamento por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID informado inválido"),
		@ApiResponse(responseCode = "404", description = "Forma de pagamento não encontrada")
		
	})
    public ResponseEntity<FormaPagamentoModel> getById(
    		@ApiParam(example = "1", value = "ID de uma forma de pagamento")
    		Long formaPagamentoId, 
    		ServletWebRequest request);

	@ApiOperation("Adiciona uma nova forma de pagamento")
    public FormaPagamentoModel create(FormaPagamentoInput formaPagamentoInput);

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Forma de pagamento não encontrada")		
	})
	@ApiOperation("Atualiza uma forma de pagamento por ID")
    public FormaPagamentoModel update(
    		@ApiParam(example = "1", value = "ID de uma forma de pagamento")
    		Long formaPagamentoId, 
    		FormaPagamentoInput formaPagamentoInput);
    
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Forma de pagamento não encontrada")
	})
	@ApiOperation("Remove uma forma de pagamento por ID")
    public void delete(
    		@ApiParam(example = "1", value = "ID de uma forma de pagamento")
    		Long formaPagamentoId);
	
}
