package com.api.gerenciamentoprodutos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DetalhesProdutoDto {
    private String nome;
    private Double valor;
}
