package com.ldsk.ecommerce.komorebi.repository;

import com.ldsk.ecommerce.komorebi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}