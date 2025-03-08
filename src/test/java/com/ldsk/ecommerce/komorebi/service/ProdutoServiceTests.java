package com.ldsk.ecommerce.komorebi.service;

import com.ldsk.ecommerce.komorebi.exception.ProdutoException;
import com.ldsk.ecommerce.komorebi.model.Produto;
import com.ldsk.ecommerce.komorebi.repository.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class ProdutoServiceTests {

    private ProdutoRepository produtoRepository;
    private ProdutoService produtoService;

    private static Produto produto1, produto2;
    private static List<Produto> produtos;

    @BeforeEach
    public void setup() {

        produtoRepository = mock(ProdutoRepository.class);
        produtoService = new ProdutoService(produtoRepository);
    }

    @BeforeAll
    public static void init() {

        produto1 = Produto.builder()
                    .id(1L)
                    .nome("Vagabond")
                    .valor(new BigDecimal("32.20"))
                    .quantidade(1)
                    .categoria("Livros")
                .build();

        produto2 = Produto.builder()
                    .id(2L)
                    .nome("Mesa")
                    .valor(new BigDecimal("132.20"))
                    .quantidade(1)
                    .categoria("Móveis")
                .build();

        produtos = Arrays.asList(produto1, produto2);
    }

    @Test
    public void shouldReturnAllProductsWhenListAll() {

        when(produtoRepository.findAll()).thenReturn(produtos);

        List<Produto> produtosResult = produtoService.getProdutos();

        Assertions.assertNotNull(produtosResult);
        Assertions.assertEquals(2, produtosResult.size());

        verify(produtoRepository, times(1)).findAll();
    }

    @Test
    public void shouldReturnEmptyListWhenNoProductsExist() {

        when(produtoRepository.findAll()).thenReturn(Collections.emptyList());

        List<Produto> produtosResult = produtoService.getProdutos();

        Assertions.assertNotNull(produtosResult);
        Assertions.assertEquals(0, produtosResult.size());

        verify(produtoRepository, times(1)).findAll();
    }

    @Test
    public void shouldThrowExceptionWhenRepositoryFailsToListProducts() {

        when(produtoRepository.findAll()).thenThrow(new RuntimeException());

        ProdutoException produtoException = Assertions.assertThrows(ProdutoException.class, () -> produtoService.getProdutos());

        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, produtoException.getHttpStatus());
        Assertions.assertEquals("Erro ao consultar produtos na base de dados.", produtoException.getMessage());

        verify(produtoRepository, times(1)).findAll();
    }

}
