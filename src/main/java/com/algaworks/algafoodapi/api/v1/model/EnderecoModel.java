package com.algaworks.algafoodapi.api.v1.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "enderecos")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class EnderecoModel extends RepresentationModel<EnderecoModel> {
	
	@ApiModelProperty(example = "40000000")
    private String cep;

	@ApiModelProperty(example = "Rua Número Zero")
    private String logradouro;

	@ApiModelProperty(example = "42")
    private String numero;
	
	@ApiModelProperty(example = "Próximo ao centro")
    private String complemento;

	@ApiModelProperty(example = "Barro Vinicius de Morais")
    private String bairro;

    private CidadeResumoModel cidade;
}
