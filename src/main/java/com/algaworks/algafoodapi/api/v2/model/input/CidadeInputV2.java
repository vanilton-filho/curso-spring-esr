package com.algaworks.algafoodapi.api.v2.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("CidadeInput")
@Setter
@Getter
public class CidadeInputV2 {

	@ApiModelProperty(example = "Uberlândia", required = true)
    @NotBlank
    private String nomeCidade;

	@ApiModelProperty(example = "1", required = true)
	@NotNull
	private Long idEstado;

}
