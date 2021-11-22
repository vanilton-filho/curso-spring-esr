package com.algaworks.algafoodapi.api.v1.openapi.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;

import com.algaworks.algafoodapi.api.v1.model.PedidoModel;
import com.algaworks.algafoodapi.api.v1.model.PedidoResumoModel;
import com.algaworks.algafoodapi.api.v1.model.input.PedidoInput;
import com.algaworks.algafoodapi.domain.filter.PedidoFilter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Pedidos")
public interface PedidoControllerOpenApi {
	
	 	@ApiImplicitParams({
	 		@ApiImplicitParam(
    			value = "Nomes das propriedades para filtrar na resposta, separados por vírgula",
    			name = "campos",
    			paramType = "query",
    			type = "string")
	 	})
	 	@ApiOperation("Busca os pedidos")
		public PagedModel<PedidoResumoModel> pesquisar(
				PedidoFilter filter, 
				@PageableDefault(size = 10) Pageable pageable);

	    @ApiImplicitParams({
	    	@ApiImplicitParam(
	    			value = "Nomes das propriedades para filtrar na resposta, separados por vírgula",
	    			name = "campos",
	    			paramType = "query",
	    			type = "string")
	    })
	    @ApiResponses({
	    	@ApiResponse(responseCode = "400", description = "Código inválido"),
	    	@ApiResponse(responseCode = "404", description = "Pedido com código informado não encontrado")
	 	})
	    @ApiOperation("Busca um pedido pelo código")
		public PedidoModel getById(
				@ApiParam(example = "f9981ca4-5a5e-4da3-af04-933861df3e55", value = "Código do pedido")
				String codigo);
	    
	    @ApiOperation("Emite um novo pedido")
		public PedidoModel add(PedidoInput pedidoInput);
	
}
