package com.api.gerenciamentoprodutos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDto {



    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private Double valor;
    @NotNull
    private Boolean disponivel;

}
