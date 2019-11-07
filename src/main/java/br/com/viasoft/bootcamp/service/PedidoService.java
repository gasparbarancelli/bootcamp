package br.com.viasoft.bootcamp.service;

import br.com.viasoft.bootcamp.framework.CrudService;
import br.com.viasoft.bootcamp.model.Pedido;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PedidoService extends CrudService<Pedido, Long> {

    List<Pedido> findByClienteId(Long clienteId);

    List<Pedido> findByClienteIdAndDataEmissaoBetweenOrderByDataEmissaoDesc(
            Long id,
            LocalDate dataInicial,
            LocalDate dataFinal
    );


    List<Pedido> findByClienteNomeContaining(String clienteNomeNomeClienteXIXICOCO);

    List<Pedido> retornaOsPedidosQueContenhamOItemQueEuVouPassarPorParametro(Long id);
}
