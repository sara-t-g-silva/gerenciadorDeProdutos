package com.api.gerenciamentoprodutos.services;
import com.api.gerenciamentoprodutos.models.ProdutoModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProdutoService {
    ProdutoModel save(ProdutoModel produto);


    ProdutoModel findById(UUID id);

   List<ProdutoModel> findAll();
}
