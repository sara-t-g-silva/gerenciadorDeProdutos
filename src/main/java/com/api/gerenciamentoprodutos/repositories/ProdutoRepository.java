package com.api.gerenciamentoprodutos.repositories;

import com.api.gerenciamentoprodutos.models.ProdutoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoModel, Integer> {


    ProdutoModel findById(UUID id);
}
