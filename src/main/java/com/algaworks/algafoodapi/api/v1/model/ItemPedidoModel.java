package com.algaworks.algafoodapi.api.v1.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.annotations.ApiModelProperty;

@Getter
@Setter
public class ItemPedidoModel extends RepresentationModel<ItemPedidoModel> {

	@ApiModelProperty(value = "ID do produto associado ao item", example = "1")
    private Long produtoId;
	
	@ApiModelProperty(example = "Prime Rib")
    private String produtoNome;
	
	@ApiModelProperty(example =  "3")
    private Integer quantidade;
	
	@ApiModelProperty(value = "Preço do item", example = "23.34")
    private BigDecimal precoUnitario;
	
	@ApiModelProperty(value = "Preço do item multiplicado pela quantidade", example = "70.02")
    private BigDecimal precoTotal;
	
	@ApiModelProperty(value = "Alguma observação sobre o preparo do pedido, entrega e etc.", example = "Bem acebolado por favor")
    private String observacao;

}
