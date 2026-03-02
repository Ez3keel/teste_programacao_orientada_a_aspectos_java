package com.testando.POA.Repository;

import com.testando.POA.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

//O JPARespository já traz o CRUD pronto
public interface ProdutoRepository extends JpaRepository<Produto, Long> { }
