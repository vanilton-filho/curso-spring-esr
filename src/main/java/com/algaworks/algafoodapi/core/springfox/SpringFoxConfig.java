package com.algaworks.algafoodapi.core.springfox;


import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import com.algaworks.algafoodapi.api.v1.model.CidadeModel;
import com.algaworks.algafoodapi.api.v1.model.CozinhaModel;
import com.algaworks.algafoodapi.api.v1.model.EstadoModel;
import com.algaworks.algafoodapi.api.v1.model.FormaPagamentoModel;
import com.algaworks.algafoodapi.api.v1.model.GrupoModel;
import com.algaworks.algafoodapi.api.v1.model.LinksModelOpenApi;
import com.algaworks.algafoodapi.api.v1.model.PedidoModel;
import com.algaworks.algafoodapi.api.v1.model.PedidoResumoModel;
import com.algaworks.algafoodapi.api.v1.model.PermissaoModel;
import com.algaworks.algafoodapi.api.v1.model.ProdutoModel;
import com.algaworks.algafoodapi.api.v1.model.RestauranteBasicModel;
import com.algaworks.algafoodapi.api.v1.model.UsuarioModel;
import com.algaworks.algafoodapi.api.v1.openapi.model.CidadesModelOpenApi;
import com.algaworks.algafoodapi.api.v1.openapi.model.CozinhasModelOpenApi;
import com.algaworks.algafoodapi.api.v1.openapi.model.EstadosModelOpenApi;
import com.algaworks.algafoodapi.api.v1.openapi.model.FormasPagamentoModelOpenApi;
import com.algaworks.algafoodapi.api.v1.openapi.model.GruposModelOpenApi;
import com.algaworks.algafoodapi.api.v1.openapi.model.PageableModelOpenApi;
import com.algaworks.algafoodapi.api.v1.openapi.model.PedidosModelOpenApi;
import com.algaworks.algafoodapi.api.v1.openapi.model.PedidosResumoModelOpenApi;
import com.algaworks.algafoodapi.api.v1.openapi.model.PermissoesModelOpenApi;
import com.algaworks.algafoodapi.api.v1.openapi.model.ProdutosModelOpenApi;
import com.algaworks.algafoodapi.api.v1.openapi.model.RestaurantesBasicoModelOpenApi;
import com.algaworks.algafoodapi.api.v1.openapi.model.UsuariosModelOpenApi;
import com.algaworks.algafoodapi.api.v2.model.CidadeModelV2;
import com.algaworks.algafoodapi.api.v2.openapi.model.CidadesModelOpenApiV2;
import com.algaworks.algafoodapi.domain.filter.PedidoFilter;
import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SpringFoxConfig {
	
	@Bean
	public Docket apiDocketV1() {
		
		var typeResolver = new TypeResolver();
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfoV1())
				.groupName("V1")
				.tags(
						new Tag("Cidades", "Gerencia as cidades"),

						new Tag("Grupos", "Gerencia os grupos de usuários"),
						new Tag("Cozinhas", "Gerencia as cozinhas"),
						new Tag("Formas Pagamento", "Gerencia formas de pagamento"),
						new Tag("Pedidos", "Gerencia os pedidos dos usuários"),
						new Tag("Restaurantes", "Gerencia os restaurantes"),
						new Tag("Estados", "Gerencia os estados"),
						new Tag("Produtos", "Gerencia produtos"),
						new Tag("Usuários", "Gerencia os usuários"),
						new Tag("Estatísticas", "Estatísticas da AlgaFood")
						
					)
					.select()
					.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
					.paths(PathSelectors.ant("/v1/**"))
				.build()
					.directModelSubstitute(OffsetDateTime.class, String.class)
					.directModelSubstitute(Pageable.class, PageableModelOpenApi.class)
					.directModelSubstitute(Links.class, LinksModelOpenApi.class)
	
					.alternateTypeRules(AlternateTypeRules.newRule(
						    typeResolver.resolve(CollectionModel.class, RestauranteBasicModel.class),
						    RestaurantesBasicoModelOpenApi.class))

					.alternateTypeRules(AlternateTypeRules.newRule(
					        typeResolver.resolve(CollectionModel.class, UsuarioModel.class),
					        UsuariosModelOpenApi.class))
						
					.alternateTypeRules(AlternateTypeRules.newRule(
						    typeResolver.resolve(CollectionModel.class, ProdutoModel.class),
						    ProdutosModelOpenApi.class))
					
					.alternateTypeRules(AlternateTypeRules.newRule(
						    typeResolver.resolve(CollectionModel.class, GrupoModel.class),
						    GruposModelOpenApi.class))
					
					.alternateTypeRules(AlternateTypeRules.newRule(
					        typeResolver.resolve(CollectionModel.class, PermissaoModel.class),
					        PermissoesModelOpenApi.class))
					
					.alternateTypeRules(AlternateTypeRules.newRule(
							typeResolver.resolve(CollectionModel.class, FormaPagamentoModel.class),
							FormasPagamentoModelOpenApi.class))
					
					.alternateTypeRules(AlternateTypeRules.newRule(
							typeResolver.resolve(PagedModel.class, CozinhaModel.class), CozinhasModelOpenApi.class))
					
					.alternateTypeRules(AlternateTypeRules.newRule(
							typeResolver.resolve(CollectionModel.class, EstadoModel.class), EstadosModelOpenApi.class))
					
					.alternateTypeRules(AlternateTypeRules.newRule(
							typeResolver.resolve(Page.class, PedidoModel.class), PedidosModelOpenApi.class))
					
					.alternateTypeRules(AlternateTypeRules.newRule(
						    typeResolver.resolve(PagedModel.class, PedidoResumoModel.class),
						    PedidosResumoModelOpenApi.class))
					
					.alternateTypeRules(AlternateTypeRules.newRule(
							typeResolver.resolve(CollectionModel.class, CidadeModel.class), 
							CidadesModelOpenApi.class))
				
					
				.securitySchemes(Arrays.asList(securityScheme()))
				.securityContexts(Arrays.asList(securityContext()))
					.additionalModels(typeResolver.resolve(PedidoFilter.class))
					.ignoredParameterTypes(ServletWebRequest.class)
					.useDefaultResponseMessages(false)
					.globalResponses(HttpMethod.GET, globalGetMessages())
					.globalResponses(HttpMethod.POST, globalPostAndPutMessages())
					.globalResponses(HttpMethod.PUT, globalPostAndPutMessages())
					.globalResponses(HttpMethod.DELETE, globalDeleteMessages());
//					.globalRequestParameters(Arrays.asList(
//							new RequestParameterBuilder()
//									.name("campos")
//									.description("Nomes das propriedades para filtrar na resposta, separados por vírgula")
//									.in("query")
//									.build()));
				
		
	}

	private SecurityScheme securityScheme() {
		return new OAuthBuilder()
				.name("AlgaFood")
				.grantTypes(grantTypes())
				.scopes(scopes())
				.build();
	}

	private List<GrantType> grantTypes() {
		return Arrays.asList(new ResourceOwnerPasswordCredentialsGrant("/oauth/token"));
	}

	private List<AuthorizationScope> scopes() {
		return Arrays.asList(
				new AuthorizationScope("READ", "Acesso de leitura"),
				new AuthorizationScope("WRITE", "Acesso de escrita"));
	}

	private SecurityContext securityContext() {
		var securityReference = SecurityReference.builder()
				.reference("AlgaFood")
				.scopes(scopes().toArray(new AuthorizationScope[0]))
				.build();

		return SecurityContext.builder().securityReferences(Arrays.asList(securityReference))
				.forPaths(PathSelectors.any()).build();
	}

	@Bean
	public Docket apiDocketV2() {
		
		var typeResolver = new TypeResolver();
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfoV2())
				.groupName("V2")
				.tags(
						new Tag("V2", "Root entry point da API"),
						new Tag("Cidades", "Gerencia as cidades")
					)
					.select()
					.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
					.paths(PathSelectors.ant("/v2/**"))
				.build()
					.alternateTypeRules(AlternateTypeRules.newRule(
					        typeResolver.resolve(CollectionModel.class, CidadeModelV2.class),
					        CidadesModelOpenApiV2.class))

					
					.ignoredParameterTypes(ServletWebRequest.class)
					.useDefaultResponseMessages(false)
					.globalResponses(HttpMethod.GET, globalGetMessages())
					.globalResponses(HttpMethod.POST, globalPostAndPutMessages())
					.globalResponses(HttpMethod.PUT, globalPostAndPutMessages())
					.globalResponses(HttpMethod.DELETE, globalDeleteMessages());
//					.globalRequestParameters(Arrays.asList(
//							new RequestParameterBuilder()
//									.name("campos")
//									.description("Nomes das propriedades para filtrar na resposta, separados por vírgula")
//									.in("query")
//									.build()));
				
		
	}
	
	private ApiInfo apiInfoV1() {
		return new ApiInfoBuilder()
					.title("AlgaFood API")
					.description("REST API para clientes e restaurantes.")
					.version("1.0")
					.contact(new Contact("AlgaWorks", "https://www.algaworks.com", "contato@algaworks.com"))
				.build();
	}
	
	private ApiInfo apiInfoV2() {
		return new ApiInfoBuilder()
					.title("AlgaFood API")
					.description("REST API para clientes e restaurantes.")
					.version("2.0")
					.contact(new Contact("AlgaWorks", "https://www.algaworks.com", "contato@algaworks.com"))
				.build();
	}
	
	private List<Response> globalGetMessages() {
		return Arrays.asList(
				new ResponseBuilder()
					.code(getHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR))
					.description("Erro interno no servidor")
					.build(),
				new ResponseBuilder()
					.code(getHttpStatusCode(HttpStatus.NOT_ACCEPTABLE))
					.description("Recurso não possui representação que poderia ser aceita pelo consumidor")
					.build()
		);
	}
	
	private List<Response> globalPostAndPutMessages() {
		return Arrays.asList(
				new ResponseBuilder()
					.code(getHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR))
					.description("Erro interno no servidor")
					.build(),
				new ResponseBuilder()
					.code(getHttpStatusCode(HttpStatus.NOT_ACCEPTABLE))
					.description("Recurso não possui representação que poderia ser aceita pelo consumidor")
					.build(),
				new ResponseBuilder()
					.code(getHttpStatusCode(HttpStatus.BAD_REQUEST))
					.description("Requisição inválida (erro do cliente)")
					.build(),
				new ResponseBuilder()
					.code(getHttpStatusCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE))
					.description("Requisição recusada porque o corpo está em um formato não suportado")
					.build()
				
		);
	}
	
	private List<Response> globalDeleteMessages() {
		return Arrays.asList(
				new ResponseBuilder()
					.code(getHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR))
					.description("Erro interno no servidor")
					.build(),
				new ResponseBuilder()
					.code(getHttpStatusCode(HttpStatus.BAD_REQUEST))
					.description("Requisição inválida (erro do cliente)")
					.build()
		);
	}
	
	private String getHttpStatusCode(HttpStatus status) {
		return String.valueOf(status.value());
	}
	
}
