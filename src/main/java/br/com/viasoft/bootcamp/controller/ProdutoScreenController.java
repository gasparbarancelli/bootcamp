package br.com.viasoft.bootcamp.controller;

import br.com.viasoft.bootcamp.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("screen-produto")
public class ProdutoScreenController {

    @Autowired private ProdutoService produtoService;

    @GetMapping
    public String produtoList(Model model) {
        model.addAttribute("produtoList", produtoService.findAll());
        return "produto";
    }

    @GetMapping("mais-vendido")
    public String maisVendido(Model model) {
        model.addAttribute("produto", produtoService.produtosMaisVendidos());
        return "produtoMaisVendido";
    }
}
