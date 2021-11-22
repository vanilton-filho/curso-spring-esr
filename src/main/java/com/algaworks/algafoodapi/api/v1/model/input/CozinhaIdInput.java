package com.algaworks.algafoodapi.api.v1.model.input;

import com.algaworks.algafoodapi.core.validation.Groups;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class CozinhaIdInput {

	@ApiModelProperty(example = "1", required = true)
    @NotNull
    private Long id;

}
