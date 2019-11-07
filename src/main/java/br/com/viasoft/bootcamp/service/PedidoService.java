package br.com.viasoft.bootcamp.service;

import br.com.viasoft.bootcamp.framework.CrudService;
import br.com.viasoft.bootcamp.model.Pedido;

import java.util.List;

public interface PedidoService extends CrudService<Pedido, Long> {

    List<Pedido> findByClienteId(Long clienteId);

}
