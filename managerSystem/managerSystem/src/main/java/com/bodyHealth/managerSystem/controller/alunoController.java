package com.bodyHealth.managerSystem.controller;
import com.bodyHealth.managerSystem.model.bodySystem.Aluno;
import com.bodyHealth.managerSystem.model.bodySystem.AlunoRepository;
import com.bodyHealth.managerSystem.model.bodySystem.DadosAlterarAluno;
import com.bodyHealth.managerSystem.model.bodySystem.DadosAluno;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aluno")
public class alunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping("/cadastro")
    public String getView(Long alunoId,Model model){
        if (alunoId != null)
        {
            Aluno aluno = repository.getReferenceById(alunoId);
            model.addAttribute("aluno",aluno);
        }
        return "aluno/cadastro";
    }

    @PostMapping
    public String cadastrarAluno(DadosAluno dados){
        Aluno aluno = new Aluno(dados);
        repository.save(aluno);
        return "redirect:/aluno/cadastro";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model)
    {
        model.addAttribute("lista",repository.findAllAluno(Sort.by(Sort.Direction.DESC, "alunoId")));
        return "aluno/listagem";
    }

    @DeleteMapping
    @Transactional
    public String delete(Long alunoId){
        repository.deleteById(alunoId);
        return "redirect:/aluno/listagem";
    }

    @PutMapping
    @Transactional
    public String alterar(DadosAlterarAluno dados){
        Aluno aluno = repository.getReferenceById(dados.alunoId());
        aluno.atualizaDados(dados);
        return "redirect:/aluno/cadastro";
    }
}
