package com.empresa.gestor_vendas.produto.application.api;

import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoDetalhadoResponse;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoListResponse;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoRequest;
import com.empresa.gestor_vendas.produto.application.api.dto.ProdutoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public interface ProdutoAPI {

    @PostMapping("/cadastraProduto")
    @ResponseStatus(code = HttpStatus.CREATED)
    ProdutoResponse cadastraProduto (@Valid @RequestBody ProdutoRequest produtoRequest);

    @GetMapping("/buscaProduto/{idProduto}")
    @ResponseStatus(code = HttpStatus.OK)
    ProdutoDetalhadoResponse buscaProduto (@PathVariable Integer idProduto);

    @GetMapping("/buscaTodosProduto")
    @ResponseStatus(code = HttpStatus.OK)
    List<ProdutoListResponse> buscaTodosProduto();

    @DeleteMapping(value = "/deletaProduto/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaProduto(@PathVariable Integer idProduto);

}
