package com.algaworks.algafoodapi.api.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class PedidoModel extends RepresentationModel<PedidoModel> {

	@ApiModelProperty(example = "f9981ca4-5a5e-4da3-af04-933861df3e55")
    private String codigo;
	
	@ApiModelProperty(value = "Status em que o pedido se encontra", example = "CRIADO")
    private String status;

	@ApiModelProperty(value = "Valor sem a taxa de frete incluída", example = "12.00")
    private BigDecimal subtotal;
	
	@ApiModelProperty(value = "Taxa de frete para entrega", example = "3.00")
    private BigDecimal taxaFrete;
	
	@ApiModelProperty(value = "Valor do subtotal mais taxa de frete", example = "15.00")
    private BigDecimal valorTotal;

	
	
	@ApiModelProperty(value = "Data/hora quando o pedido foi criado", example = "2021-06-22T03:35:41Z")
    private OffsetDateTime dataCriacao;
	
	@ApiModelProperty(value = "Data/hora quando o pedido foi confirmado pelo restaurante", example = "2021-06-22T03:42:41Z")
    private OffsetDateTime dataConfirmacao;
	
	@ApiModelProperty(value = "Data/hora de cancelamento do pedido pelo usuário", example = "2021-06-22T03:54:41Z")
    private OffsetDateTime dataCancelamento;
	
	@ApiModelProperty(value = "Data/hora de entrega do pedido", example = "2021-06-22T04:35:41Z")
    private OffsetDateTime dataEntrega;

	private RestauranteBasicModel restaurante;
	private EnderecoModel enderecoEntrega;
    private UsuarioModel cliente;
    private FormaPagamentoModel formaPagamento;
    
    @ApiModelProperty(value = "Lista de itens do pedido")
    private List<ItemPedidoModel> itens;
}
