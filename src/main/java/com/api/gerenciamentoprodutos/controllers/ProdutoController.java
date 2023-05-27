package com.api.gerenciamentoprodutos.controllers;

import com.api.gerenciamentoprodutos.dto.DetalhesProdutoDto;
import com.api.gerenciamentoprodutos.dto.ProdutoDto;
import com.api.gerenciamentoprodutos.models.ProdutoModel;
import com.api.gerenciamentoprodutos.services.IProdutoService;
import jakarta.validation.Valid;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private IProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDto produtoDto){
        var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDto, produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoModel));
    }

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<Object> buscarProdutoDetalhe(@PathVariable UUID id){
        ProdutoModel produtoModel = produtoService.findById(id);

        DetalhesProdutoDto detalhesProdutoDto = new DetalhesProdutoDto();
        detalhesProdutoDto.setNome(produtoModel.getNome());
        detalhesProdutoDto.setValor(produtoModel.getValor());

        return ResponseEntity.ok(detalhesProdutoDto);
    }

    @GetMapping("/listagem")
    public ResponseEntity<List<ProdutoDto>> buscarProdutosOrdenados(@RequestParam(value = "sort", defaultValue = "asc") String sort){
        List<ProdutoModel> produtos = produtoService.findAll();
        if (sort.equalsIgnoreCase("asc")) {
            produtos.sort(Comparator.comparingDouble(ProdutoModel::getValor));
        } else if (sort.equalsIgnoreCase("desc")) {
            produtos.sort(Comparator.comparingDouble(ProdutoModel::getValor).reversed());
        }
        List<ProdutoDto> produtosDto = produtos.stream()
                .map(produtoModel -> {
                    ProdutoDto produtoDto = new ProdutoDto();
                    BeanUtils.copyProperties(produtoModel, produtoDto);
                    return produtoDto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(produtosDto);
    }









}
