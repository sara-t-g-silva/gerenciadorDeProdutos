package com.api.gerenciamentoprodutos.services.Impl;

import com.api.gerenciamentoprodutos.models.ProdutoModel;
import com.api.gerenciamentoprodutos.repositories.ProdutoRepository;
import com.api.gerenciamentoprodutos.services.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Override
    public ProdutoModel save(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);



    }


}
