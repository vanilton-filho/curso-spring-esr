package com.algaworks.algafoodapi.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Setter
@Getter
public class EnderecoInput {

	@ApiModelProperty(example = "40000000", required = true)
    @NotBlank
    private String cep;

	@ApiModelProperty(example = "Rua Número Zero", required = true)
    @NotBlank
    private String logradouro;

	@ApiModelProperty(example = "42", required = true)
    @NotBlank
    private String numero;

	@ApiModelProperty(example = "Próximo ao centro")
    private String complemento;

	@ApiModelProperty(example = "Barro Vinicius de Morais", required = true)
    @NotBlank
    private String bairro;

    @Valid
    @NotNull
    private CidadeIdInput cidade;
}
