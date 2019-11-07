package br.com.viasoft.bootcamp.service;

import br.com.viasoft.bootcamp.framework.CrudService;
import br.com.viasoft.bootcamp.model.Produto;

import java.util.List;

public interface ProdutoService extends CrudService<Produto, Long> {

    List<Produto> complete(String descricao);

    Produto produtosMaisVendidos();


}
