package br.com.viasoft.bootcamp.data;

import br.com.viasoft.bootcamp.model.Produto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoData extends JpaRepository<Produto, Long> {

    List<Produto> findByDescricaoContaining(String descricao, Pageable pageable);

}
