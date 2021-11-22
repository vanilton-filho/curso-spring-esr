package com.algaworks.algafoodapi.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@Setter
@Getter
public class ProdutoInput {

    @ApiModelProperty(example = "Prime Rib", required = true)
    @NotBlank
    private String nome;

    @ApiModelProperty(example = "Especialidade da casa", required = true)
    @NotBlank
    private String descricao;

    @ApiModelProperty(example = "42.0", required = true)
    @NotNull
    @PositiveOrZero
    private BigDecimal preco;

    @ApiModelProperty(example = "true", required = true)
    @NotNull
    private Boolean ativo;
}
