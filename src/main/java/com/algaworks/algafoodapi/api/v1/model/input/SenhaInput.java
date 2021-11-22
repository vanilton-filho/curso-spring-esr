package com.algaworks.algafoodapi.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Setter
@Getter
public class SenhaInput {

	@ApiModelProperty(required = true, example = "toor123")
    @NotBlank
    private String senhaAtual;

	@ApiModelProperty(required = true, example = "123toor")
    @NotBlank
    private String novaSenha;

}
