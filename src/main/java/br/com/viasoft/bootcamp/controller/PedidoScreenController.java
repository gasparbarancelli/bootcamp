package br.com.viasoft.bootcamp.controller;

import br.com.viasoft.bootcamp.service.ClienteService;
import br.com.viasoft.bootcamp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("screen-pedido")
public class PedidoScreenController {

    @Autowired private PedidoService pedidoService;

    @Autowired private ClienteService clienteService;

    @GetMapping
    public String finddfByClienteId(@RequestParam("clienteId") Long id, Model model) {
        model.addAttribute("pedidoList", pedidoService.findByClienteId(id));
        return "pedidoCliente";
    }

    @GetMapping("por-nome-do-cliente")
    public String findByClienteNomeContaining(@RequestParam("nome") String nome, Model model) {
        model.addAttribute("pedidoList", pedidoService.findByClienteNomeContaining(nome));
        return "pedidoCliente";
    }

    @GetMapping("pedidos-que-contenha-o-item")
    public String retornaOsPedidosQueContenhamOItemQueEuVouPassarPorParametro(@RequestParam("idItem") Long idItem, Model model) {
        model.addAttribute("pedidoList", pedidoService.retornaOsPedidosQueContenhamOItemQueEuVouPassarPorParametro(idItem));
        return "pedidoCliente";
    }

    @GetMapping("todos")
    public String todos(Model model) {
        model.addAttribute("pedidoList", pedidoService.findAll());
        return "pedidoCliente";
    }

    @GetMapping("por-id/{id}")
    public String porId(@PathVariable("id") Long id, Model model) {
        var pedido = pedidoService.findOne(id).get();
        model.addAttribute("pedido", pedido);
        model.addAttribute("cliente", clienteService.findOne(pedido.getCliente().getId()).get());
        return "pedido";
    }

    @GetMapping("por-cliente-e-data")
    public String porClienteEData(
            @RequestParam("clienteId") Long id,
            @RequestParam("dataInicial") LocalDate dataInicial,
            @RequestParam("dataFinal") LocalDate dataFinal,
            Model model) {
        model.addAttribute(
                "pedidoList",
                pedidoService.findByClienteIdAndDataEmissaoBetweenOrderByDataEmissaoDesc(id, dataInicial, dataFinal));
        return "pedidoCliente";
    }

}
