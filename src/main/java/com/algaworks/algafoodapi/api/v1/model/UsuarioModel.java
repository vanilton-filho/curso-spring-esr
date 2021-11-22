package com.algaworks.algafoodapi.api.v1.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "usuarios")
@Setter
@Getter
public class UsuarioModel extends RepresentationModel<UsuarioModel> {

	@ApiModelProperty(example = "1")
    private Long id;
	
	@ApiModelProperty(example = "Manolo")
    private String nome;
	
	@ApiModelProperty(example = "manolo@email.com")
    private String email;

}
