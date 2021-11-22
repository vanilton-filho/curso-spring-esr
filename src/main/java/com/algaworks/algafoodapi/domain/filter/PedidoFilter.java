package com.algaworks.algafoodapi.domain.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@Setter
@Getter
public class PedidoFilter {

	@ApiModelProperty(value = "ID do cliente (usuário)", example = "1")
    private Long clienteId;
	
	@ApiModelProperty(value = "ID do restaurante", example = "1")
    private Long restauranteId;

	@ApiModelProperty(value = "Data de criação do pedido", example = "2021-06-20T19:48:59.167216Z")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dataCriacaoInicio;

	@ApiModelProperty(value = "Data da última atualização do pedido", example = "2021-06-20T19:48:59.167216Z")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dataCriacaoFim;

}
