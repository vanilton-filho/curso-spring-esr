package com.algaworks.algafoodapi.api.v1.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;

@Relation(collectionRelation = "produtos")
@Setter
@Getter
public class ProdutoModel extends RepresentationModel<ProdutoModel> {

	@ApiModelProperty(example = "1", required = true)
    private Long id;
	
	@ApiModelProperty(example = "Prime Rib", required = true)
    private String nome;
	
	@ApiModelProperty(example = "Carne de qualidade", required = true)
    private String descricao;
	
	@ApiModelProperty(example = "42.0", required = true)
    private BigDecimal preco;
	
	@ApiModelProperty(example = "true", required = true)
    private Boolean ativo;

}
