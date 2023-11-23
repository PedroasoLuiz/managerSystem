package com.bodyHealth.managerSystem.controller;
import com.bodyHealth.managerSystem.model.bodySystem.DadosAlterarProfessor;
import com.bodyHealth.managerSystem.model.bodySystem.DadosProfessor;
import com.bodyHealth.managerSystem.model.bodySystem.Professor;
import com.bodyHealth.managerSystem.model.bodySystem.ProfessorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professor")
public class professorController {
    @Autowired
    private ProfessorRepository repository;

    @GetMapping("/cadastro")
    public String getView(Long professorId, Model model) {
        if(professorId != null)
        {
            Professor professor = repository.getReferenceById(professorId);
            model.addAttribute("professor",professor);
        }

        return "professor/cadastro";
    }

    @PostMapping
    public String cadastraProfesssor(DadosProfessor dados) {
       Professor professor = new Professor(dados);
       repository.save(professor);
       return "redirect:/professor/listagem";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model)
    {
        model.addAttribute("lista",repository.getAll());
        return "professor/listagem";
    }

    @DeleteMapping
    @Transactional
    public String delete(Long id){
        repository.deleteById(id);
        return "redirect:/professor/listagem";
    }

    @PutMapping
    @Transactional
    public String alterar(DadosAlterarProfessor dados){
        Professor professor = repository.getReferenceById(dados.id());
        professor.AtualizarProfessor(dados);
        return "redirect:/professor/listagem";
    }

    @GetMapping("/professor")
    public String viewCategoria(String categoria, Model model){
        if (categoria != ""){
            model.addAttribute("lista",repository.findByCategoria(categoria));
        }else {
            return "redirect:/professor/listagem";
        }

        return "professor/listagem";
    }
}
