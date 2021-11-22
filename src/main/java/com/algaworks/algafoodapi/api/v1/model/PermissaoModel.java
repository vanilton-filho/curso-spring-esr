package com.algaworks.algafoodapi.api.v1.model;

import lombok.Getter;
import lombok.Setter;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;

@Relation(collectionRelation = "permissoes")
@Setter
@Getter
public class PermissaoModel extends RepresentationModel<PermissaoModel> {
	
	@ApiModelProperty(value = "id", example = "1")
    private Long id;
	@ApiModelProperty(value = "nome", example = "EDITAR_RESTAURANTE")
    private String nome;
	@ApiModelProperty(value = "descricao", example = "Permite editar dados do restaurante")
    private String descricao;

}
