package br.com.viasoft.bootcamp.controller;

import br.com.viasoft.bootcamp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("screen-cliente")
public class ClienteScreenController {

    @Autowired private ClienteService clienteService;

    @GetMapping("{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.findOne(id).get());
        return "cliente";
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "clientes";
    }

}
