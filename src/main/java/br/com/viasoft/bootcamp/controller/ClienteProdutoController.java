package br.com.viasoft.bootcamp.controller;

import br.com.viasoft.bootcamp.service.ClienteService;
import br.com.viasoft.bootcamp.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("comprador-produto")
public class ClienteProdutoController {

    @Autowired private ClienteService clienteService;

    @Autowired private ProdutoService produtoService;

    @GetMapping
    public String clientePorProduto(@RequestParam("idProduto") Long idProduto, Model model) {
        model.addAttribute("clientes", clienteService.clientesQueCompraramProduto(idProduto));
        model.addAttribute("nomeProduto", produtoService.findOne(idProduto).get().getDescricao());
        return "clientes-produto";
    }

}
