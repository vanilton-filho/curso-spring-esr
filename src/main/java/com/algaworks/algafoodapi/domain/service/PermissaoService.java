package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.PermissaoNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Permissao;
import com.algaworks.algafoodapi.domain.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public Permissao findOrFail(Long id) {
        return permissaoRepository.findById(id)
                .orElseThrow(() -> new PermissaoNaoEncontradaException(id));
    }

}
