package br.com.viasoft.bootcamp.controller;

import br.com.viasoft.bootcamp.framework.CrudRestController;
import br.com.viasoft.bootcamp.framework.CrudService;
import br.com.viasoft.bootcamp.model.Produto;
import br.com.viasoft.bootcamp.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController extends CrudRestController<Produto, Long> {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Override
    public CrudService<Produto, Long> getService() {
        return produtoService;
    }

    @GetMapping("complete")
    public List<Produto> complete(@RequestParam("descricao") String descricao) {
        return produtoService.complete(descricao);
    }

}

