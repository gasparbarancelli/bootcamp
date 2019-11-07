package br.com.viasoft.bootcamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("novo-pedido")
public class NovoPedidoController {

    @GetMapping
    public String asoidjasidiajda() {
        return "novo-pedido";
    }

    @GetMapping("para-o-cliente")
    public String asoidjasidiajda(
            @RequestParam("nomeDoCliente") String nome,
            Model model) {
        model.addAttribute("titulo", "O pedido sera feito para o cliente " + nome);
        return "novo-pedido";
    }

}
