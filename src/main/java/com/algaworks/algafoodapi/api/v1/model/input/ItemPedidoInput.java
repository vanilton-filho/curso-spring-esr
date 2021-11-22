package com.algaworks.algafoodapi.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModelProperty;

@Setter
@Getter
public class ItemPedidoInput {

	@ApiModelProperty(example = "1", required = true)
    @NotNull
    private Long produtoId;

	@ApiModelProperty(example = "3", required = true)
    @NotNull
    @PositiveOrZero
    private Integer quantidade;

	@ApiModelProperty(example = "Muito acebolado por favor")
    private String observacao;

}
