package br.com.viasoft.bootcamp.data;

import br.com.viasoft.bootcamp.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PedidoData extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId(Long clienteId);

    List<Pedido> findByClienteIdAndDataEmissaoBetweenOrderByDataEmissaoDesc(
            Long id,
            LocalDate dataInicial,
            LocalDate dataFinal
    );

    List<Pedido> findByClienteNomeContaining(String clienteNomeNomeClienteXIXICOCO);

    @Query("select distinct p from Pedido p inner join p.pedidoItemList pl inner join pl.produto pp where pp.id = :idDoProduto")
    List<Pedido> retornaOsPedidosQueContenhamOItemQueEuVouPassarPorParametro(
            @Param("idDoProduto") Long id
    );

}
