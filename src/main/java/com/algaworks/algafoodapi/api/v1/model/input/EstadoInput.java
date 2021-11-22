package com.algaworks.algafoodapi.api.v1.model.input;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class EstadoInput {

	@ApiModelProperty(example = "Sergipe", required = true)
    @NotBlank
    private String nome;

}
