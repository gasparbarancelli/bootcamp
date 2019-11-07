package br.com.viasoft.bootcamp.controller;

import br.com.viasoft.bootcamp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("screen-pedido")
public class PedidoScreenController {

    @Autowired private PedidoService pedidoService;

    @GetMapping
    public String findByClienteId(@RequestParam("clienteId") Long id, Model model) {
        model.addAttribute("pedidoList", pedidoService.findByClienteId(id));
        return "pedidoCliente";
    }
}
