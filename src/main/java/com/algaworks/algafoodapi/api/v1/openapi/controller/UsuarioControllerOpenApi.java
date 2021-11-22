package com.algaworks.algafoodapi.api.v1.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafoodapi.api.v1.model.UsuarioModel;
import com.algaworks.algafoodapi.api.v1.model.input.SenhaInput;
import com.algaworks.algafoodapi.api.v1.model.input.UsuarioComSenhaInput;
import com.algaworks.algafoodapi.api.v1.model.input.UsuarioInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@Api(tags = "Usuários")
public interface UsuarioControllerOpenApi {
	

    @ApiOperation("Lista os usuários")
    CollectionModel<UsuarioModel> getAll();

    @ApiResponses({
        @ApiResponse(responseCode = "400", description = "ID do usuário inválido"),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @ApiOperation("Busca um usuário por ID")
    UsuarioModel getById(
            @ApiParam(value = "ID do usuário", example = "1", required = true)
            Long usuarioId);

    @ApiOperation("Cadastra um usuário")
    UsuarioModel create(
            @ApiParam(name = "corpo", value = "Representação de um novo usuário", required = true)
            UsuarioComSenhaInput usuarioInput);
    
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuário atualizado"),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @ApiOperation("Atualiza um usuário por ID")
    UsuarioModel update(
            @ApiParam(value = "ID do usuário", example = "1", required = true)
            Long usuarioId,
            
            @ApiParam(name = "corpo", value = "Representação de um usuário com os novos dados",
                required = true)
            UsuarioInput usuarioInput);

    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Senha alterada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @ApiOperation(value = "Atualiza a senha de um usuário")
    void updateSenha(
            @ApiParam(value = "ID do usuário", example = "1", required = true)
            Long usuarioId,
            @ApiParam(name = "corpo", value = "Representação de uma nova senha", 
                required = true)
            SenhaInput senha);
}
