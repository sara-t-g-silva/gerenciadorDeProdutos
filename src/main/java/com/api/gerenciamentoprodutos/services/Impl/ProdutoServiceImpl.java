package com.api.gerenciamentoprodutos.services.Impl;

import com.api.gerenciamentoprodutos.models.ProdutoModel;
import com.api.gerenciamentoprodutos.repositories.ProdutoRepository;
import com.api.gerenciamentoprodutos.services.IProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Override
    @Transactional
    public ProdutoModel save(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    @Override
    public ProdutoModel findById(UUID id) {
        return produtoRepository.findById(id);
    }

    @Override
    public List<ProdutoModel> findAll() {
        return (List<ProdutoModel>) produtoRepository.findAll();
    }


}
