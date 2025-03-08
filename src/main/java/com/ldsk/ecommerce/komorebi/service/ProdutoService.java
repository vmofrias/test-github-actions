package com.ldsk.ecommerce.komorebi.service;

import com.ldsk.ecommerce.komorebi.exception.ProdutoException;
import com.ldsk.ecommerce.komorebi.model.Produto;
import com.ldsk.ecommerce.komorebi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private static final String REPOSITORY_FIND_ERROR_MESSAGE = "Erro ao consultar produtos na base de dados.";

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {

        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getProdutos() {


        try {

            return produtoRepository.findAll();
        } catch (Exception e) {

            throw new ProdutoException(HttpStatus.INTERNAL_SERVER_ERROR, REPOSITORY_FIND_ERROR_MESSAGE);
        }
    }

}
