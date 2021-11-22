package com.algaworks.algafoodapi.api.v1.model;

//import com.algaworks.algafoodapi.api.model.view.RestauranteViewModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation("restaurantes")
@Setter
@Getter
public class RestauranteModel extends RepresentationModel<RestauranteModel> {

	@ApiModelProperty( example = "1")
//    @JsonView({RestauranteViewModel.Resumo.class, RestauranteViewModel.ApenasNome.class})
    private Long id;

	@ApiModelProperty(example = "Thai Gourmet")
//    @JsonView({RestauranteViewModel.Resumo.class, RestauranteViewModel.ApenasNome.class})
    private String nome;

	@ApiModelProperty(example = "10.50")
//    @JsonView(RestauranteViewModel.Resumo.class)
    private BigDecimal taxaFrete;

//    @JsonView(RestauranteViewModel.Resumo.class)
    private CozinhaModel cozinha;

    @ApiModelProperty(example = "true")
    private Boolean ativo;
    
    @ApiModelProperty(example = "true")
    private Boolean aberto;
    
    private EnderecoModel endereco;
}
