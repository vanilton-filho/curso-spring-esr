package com.algaworks.algafoodapi.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Setter
@Getter
public class UsuarioInput {

	@ApiModelProperty(
			value = "Nome completo do usuário", 
			example = "Manolo Cicrano Fulano da Silva",
			required = true)
    @NotBlank
    private String nome;

	@ApiModelProperty(example = "manolo@email.com", required = true)
    @NotBlank
    @Email
    private String email;

}
