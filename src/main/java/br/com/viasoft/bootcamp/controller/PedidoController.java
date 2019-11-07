package br.com.viasoft.bootcamp.controller;

import br.com.viasoft.bootcamp.framework.CrudRestController;
import br.com.viasoft.bootcamp.framework.CrudService;
import br.com.viasoft.bootcamp.model.Pedido;
import br.com.viasoft.bootcamp.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedido")
public class PedidoController extends CrudRestController<Pedido, Long> {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Override
    public CrudService<Pedido, Long> getService() {
        return pedidoService;
    }

}
