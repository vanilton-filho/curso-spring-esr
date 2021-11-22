package com.algaworks.algafoodapi.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Setter
@Getter
public class RestauranteIdInput {

	@ApiModelProperty(example = "1", required = true)
    @NotNull
    private Long id;

}
