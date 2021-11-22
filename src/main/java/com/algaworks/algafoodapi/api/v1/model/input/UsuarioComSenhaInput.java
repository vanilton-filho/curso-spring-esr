package com.algaworks.algafoodapi.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Setter
@Getter
public class UsuarioComSenhaInput extends UsuarioInput {

	@ApiModelProperty(example = "toor123",required = true)
    @NotBlank
    private String senha;

}
