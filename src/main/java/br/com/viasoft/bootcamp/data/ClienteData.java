package br.com.viasoft.bootcamp.data;

import br.com.viasoft.bootcamp.model.Cliente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteData extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeContaining(String nome, Pageable pageable);

    List<Cliente> findByNomeStartingWith(String nome, Pageable pageable);

    @Query(value = "select distinct CLIENTE.* from PEDIDO\n" +
            "inner join PEDIDO_ITEM ON PEDIDO_ITEM.ID_PEDIDO = PEDIDO.ID_PEDIDO\n" +
            "inner join CLIENTE on CLIENTE.ID_CLIENTE = PEDIDO.ID_CLIENTE\n" +
            "where PEDIDO_ITEM.ID_PRODUTO = :idProduto", nativeQuery = true)
    List<Cliente> clientesQueCompraramProduto(@Param("idProduto") Long idProduto);
}
