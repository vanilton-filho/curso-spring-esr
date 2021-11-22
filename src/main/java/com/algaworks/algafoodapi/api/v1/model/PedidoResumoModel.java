package com.algaworks.algafoodapi.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "pedidos")
@Setter
@Getter
public class PedidoResumoModel extends RepresentationModel<PedidoResumoModel> {
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

	private RestauranteBasicModel restaurante;
    private UsuarioModel cliente;
}
