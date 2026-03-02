package com.testando.POA.Controller;

import com.testando.POA.Service.ProdutoService;
import com.testando.POA.model.Produto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    //Vai receber o service
    //Declara que é uma dependencia que o controller precisa para funcionar
    //O controller lida com as req HTTP
    //O Service tem a lógica de negocio
    //O controller delega o trabalho para o service
    private final ProdutoService service;

    //Constructor para receber o service
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    //Cria o POST
    //Pega o produto do body via JSON E salva na DB
    @PostMapping
    public Produto criar(@RequestBody Produto produto){
        return service.salvarProduto(produto);
    }





}

