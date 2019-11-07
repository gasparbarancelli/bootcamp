package br.com.viasoft.bootcamp.service.impl;

import br.com.viasoft.bootcamp.data.ProdutoData;
import br.com.viasoft.bootcamp.framework.CrudServiceImpl;
import br.com.viasoft.bootcamp.model.Produto;
import br.com.viasoft.bootcamp.service.ProdutoService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl extends CrudServiceImpl<Produto, Long> implements ProdutoService {

    private final ProdutoData produtoData;

    public ProdutoServiceImpl(ProdutoData produtoData) {
        this.produtoData = produtoData;
    }

    @Override
    public JpaRepository<Produto, Long> getRepository() {
        return produtoData;
    }

    @Override
    public List<Produto> complete(String descricao) {
        return produtoData.findByDescricaoContaining(descricao, PageRequest.of(0, 20));
    }

    @Override
    public Produto produtosMaisVendidos() {
        return produtoData.produtosMaisVendidos();
    }
}
