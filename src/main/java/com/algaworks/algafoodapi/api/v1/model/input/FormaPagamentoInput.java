package com.algaworks.algafoodapi.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Setter
@Getter
public class FormaPagamentoInput {

	@ApiModelProperty(example = "Bitcoin", required = true)
    @NotBlank
    private String descricao;

}
