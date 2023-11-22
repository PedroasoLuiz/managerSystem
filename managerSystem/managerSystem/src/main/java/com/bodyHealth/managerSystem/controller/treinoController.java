package com.bodyHealth.managerSystem.controller;
import com.bodyHealth.managerSystem.model.bodySystem.DadosAlterarTreino;
import com.bodyHealth.managerSystem.model.bodySystem.DadosTreino;
import com.bodyHealth.managerSystem.model.bodySystem.Treino;
import com.bodyHealth.managerSystem.model.bodySystem.TreinoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/treino")
public class treinoController {
    @Autowired
    private TreinoRepository repository;

    @GetMapping("/treino")
    public String getView(Long treinoId, Model model) {
        if(treinoId != null)
        {
            Treino treino = repository.getReferenceById(treinoId);
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
    public String delete(Long treinoId){
        repository.deleteById(treinoId);
        return "redirect:/treino/listagem";
    }

    @PutMapping
    @Transactional
    public String alterar(DadosAlterarTreino dados){
        Treino treino = repository.getReferenceById(dados.treinoId());
        treino.atualizaDados(dados);
        return "redirect:/treino/cadastro";
    }
}
