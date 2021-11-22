package com.algaworks.algafoodapi.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@ApiModel("Problema")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class Problem {
 
	@ApiModelProperty(example = "400", position = 1)
    private Integer status;
	
	@ApiModelProperty(example = "2021-06-20T18:47:52.190955Z", position = 2)
	private OffsetDateTime timestamp;
	
	@ApiModelProperty(example = "https://algafood.com.br/dados-invalidos", position = 3)
    private String type;
	
	@ApiModelProperty(example = "Dados inválidos", position = 3)
    private String title;
	
	@ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente", position = 4)
    private String detail;
	
	@ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente", position = 5)
    private String userMessage;
  
    @ApiModelProperty(value = "Objetos ou campos que geraram os erros", position = 6)
    private List<Object> objects;

    @ApiModel("ObjetoProblema")
    @Getter
    @Builder
    public static class Object {

    	@ApiModelProperty(example = "nome")
        private String name;
    	
    	@ApiModelProperty(example = "Nome do restaurante é obrigatório")
        private String userMessage;
        
    }

}
