package br.com.viasoft.bootcamp.service.impl;

import br.com.viasoft.bootcamp.data.PedidoData;
import br.com.viasoft.bootcamp.event.PedidoPreSave;
import br.com.viasoft.bootcamp.framework.CrudServiceImpl;
import br.com.viasoft.bootcamp.model.Pedido;
import br.com.viasoft.bootcamp.service.PedidoService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoServiceImpl extends CrudServiceImpl<Pedido, Long> implements PedidoService {

    private final PedidoData pedidoData;

    private final ApplicationEventPublisher applicationEventPublisher;

    public PedidoServiceImpl(PedidoData pedidoData, ApplicationEventPublisher applicationEventPublisher) {
        this.pedidoData = pedidoData;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public JpaRepository<Pedido, Long> getRepository() {
        return pedidoData;
    }

    @Override
    public void preSave(Pedido entity) {
        applicationEventPublisher.publishEvent(new PedidoPreSave(this, entity));
    }

    @Override
    public List<Pedido> findByClienteId(Long clienteId) {
        return pedidoData.findByClienteId(clienteId);
    }

    @Override
    public List<Pedido> findByClienteNomeContaining(String clienteNomeNomeClienteXIXICOCO) {
        return pedidoData.findByClienteNomeContaining(clienteNomeNomeClienteXIXICOCO);
    }

    @Override
    public List<Pedido> retornaOsPedidosQueContenhamOItemQueEuVouPassarPorParametro(Long id) {
        return pedidoData.retornaOsPedidosQueContenhamOItemQueEuVouPassarPorParametro(id);
    }

    @Override
    public List<Pedido> findByClienteIdAndDataEmissaoBetweenOrderByDataEmissaoDesc(Long id, LocalDate dataInicial, LocalDate dataFinal) {
        return pedidoData.findByClienteIdAndDataEmissaoBetweenOrderByDataEmissaoDesc(id, dataInicial, dataFinal);
    }
}
