package com.bodyHealth.managerSystem.controller;
import com.bodyHealth.managerSystem.model.bodySystem.DadosAlterarTreino;
import com.bodyHealth.managerSystem.model.bodySystem.DadosTreino;
import com.bodyHealth.managerSystem.model.bodySystem.Treino;
import com.bodyHealth.managerSystem.model.bodySystem.TreinoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/treino")
public class treinoController {
    @Autowired
    private TreinoRepository repository;

    @GetMapping("/cadastro")
    public String getView(Long id, Model model) {
        if(id != null)
        {
            Treino treino = repository.getReferenceById(id);
            model.addAttribute("treino",treino);
        }

        return "treino/cadastro";
    }

    @PostMapping
    public String cadastraTreino(DadosTreino dados) {
        Treino treino = new Treino(dados);
        repository.save(treino);
        return "redirect:/treino/cadastro";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model)
    {
        model.addAttribute("lista",repository.getAll());
        return "treino/listagem";
    }

    @DeleteMapping
    @Transactional
    public String delete(Long id){
        repository.deleteById(id);
        return "redirect:/treino/listagem";
    }

    @PutMapping
    @Transactional
    public String alterar(DadosAlterarTreino dados){
        Treino treino = repository.getReferenceById(dados.id());
        treino.AtualizarTreino(dados);
        return "redirect:/treino/listagem";
    }
}
