package br.com.viasoft.bootcamp.controller;

import br.com.viasoft.bootcamp.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoScreenController {

    @Autowired private ProdutoService produtoService;

    @GetMapping("/screen-produto")
    public String hello(Model model) {
        model.addAttribute("produtoList", produtoService.findAll());
        return "produto";
    }
}
