package br.com.viasoft.bootcamp.data;

import br.com.viasoft.bootcamp.model.Produto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoData extends JpaRepository<Produto, Long> {

    List<Produto> findByDescricaoContaining(String descricao, Pageable pageable);

    @Query(value = "SELECT PRODUTO.* FROM (\n" +
            "select COUNT(*) AS MAISVENDIDO, PEDIDO_ITEM.ID_PRODUTO AS SEILA from PEDIDO\n" +
            "INNER JOIN PEDIDO_ITEM ON PEDIDO_ITEM.ID_PEDIDO = PEDIDO.ID_PEDIDO\n" +
            "GROUP BY PEDIDO_ITEM.ID_PRODUTO\n" +
            "ORDER BY MAISVENDIDO DESC\n" +
            "LIMIT 1\n" +
            ") AS X\n" +
            "INNER JOIN PRODUTO ON PRODUTO.ID_PRODUTO = X.SEILA", nativeQuery = true)
    Produto produtosMaisVendidos();

}
