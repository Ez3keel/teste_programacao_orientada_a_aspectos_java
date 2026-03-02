package com.testando.POA.Service;

import com.testando.POA.Repository.ProdutoRepository;
import com.testando.POA.aspect.TempoUtil;
import com.testando.POA.model.Produto;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    //Injeçõa para controle DB
    private final ProdutoRepository repository;

    //Injeção de dependencia via constructor
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }


    //ROTA PARA O POST SALVAR PRODUTO
    public Produto salvarProduto(Produto produto){
        return TempoUtil.medir(() -> {

            // Simula processamento pesado
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // forma correta profissional
            }

            return repository.save(produto);
        });
    }

}
