package com.bodyHealth.managerSystem.controller;
import com.bodyHealth.managerSystem.model.bodySystem.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ficha")
public class fichaController {
    @Autowired
    private FichaRepository repository;
    @Autowired
    private AlunoRepository repositoryAluno;
    @GetMapping("/cadastro")
    public String getView(Long id, Model model) {
        if(id != null)
        {
            Ficha ficha = repository.getReferenceById(id);
            model.addAttribute("ficha",ficha);
        }
        model.addAttribute("listaAluno", repositoryAluno.findAll());
        return "ficha/cadastro";
    }

    @PostMapping
    public String cadastraFicha(DadosFicha dados) {
        Ficha ficha = new Ficha(dados);
        repository.save(ficha);
        return "redirect:/ficha/cadastro";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model,long id)
    {
        model.addAttribute("lista",repository.findByAluno(id));
        return "ficha/listagem";
    }

    @DeleteMapping
    @Transactional
    public String delete(Long id){
        repository.deleteById(id);
        return "redirect:/ficha/listagem";
    }

    @PutMapping
    @Transactional
    public String alterar(DadosAlterarFicha dados){
        Ficha ficha = repository.getReferenceById(dados.id());
        ficha.AtualizarFicha(dados);
        return "redirect:/ficha/listagem";
    }
}
