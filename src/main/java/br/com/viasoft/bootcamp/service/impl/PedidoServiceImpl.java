package br.com.viasoft.bootcamp.service.impl;

import br.com.viasoft.bootcamp.data.PedidoData;
import br.com.viasoft.bootcamp.event.PedidoPreSave;
import br.com.viasoft.bootcamp.framework.CrudServiceImpl;
import br.com.viasoft.bootcamp.model.Cliente;
import br.com.viasoft.bootcamp.model.Pedido;
import br.com.viasoft.bootcamp.model.PedidoItem;
import br.com.viasoft.bootcamp.model.Produto;
import br.com.viasoft.bootcamp.service.PedidoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    public static void main(String[] args) throws JsonProcessingException {
        Cliente cliente = new Cliente();
        cliente.setCpf("00000000000");
        cliente.setNome("Gaspar");
        cliente.setTelefone("000000000");
        System.out.println(new ObjectMapper().writeValueAsString(cliente));

        Produto produto = new Produto();
        produto.setDescricao("Caneta azul");
        produto.setValorUnitario(BigDecimal.valueOf(7.5));
        System.out.println(new ObjectMapper().writeValueAsString(produto));

        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente(1L));
        pedido.setDataEmissao(LocalDate.now());
        PedidoItem pedidoItem = new PedidoItem();
        pedidoItem.setDesconto(BigDecimal.valueOf(31));
        pedidoItem.setQuantidade(BigDecimal.valueOf(10));
        pedidoItem.setValorUnitario(BigDecimal.valueOf(7.5));
        pedidoItem.setProduto(new Produto(1L));
        pedidoItem.setPedido(pedido);
        pedido.getPedidoItemList().add(pedidoItem);
        System.out.println(new ObjectMapper().writeValueAsString(pedido));
    }
}
