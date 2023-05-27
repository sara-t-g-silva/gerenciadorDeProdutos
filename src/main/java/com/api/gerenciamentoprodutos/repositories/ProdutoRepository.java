package com.api.gerenciamentoprodutos.repositories;

import com.api.gerenciamentoprodutos.models.ProdutoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoModel, Integer> {


}
