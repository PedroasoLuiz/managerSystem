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
    public String getView(Long id,Model model){
        if (id != null)
        {
            Aluno aluno = repository.getReferenceById(id);
            model.addAttribute("aluno",aluno);
        }
        return "aluno/cadastro";
    }

    @PostMapping
    public String cadastrarAluno(DadosAluno dados){
        Aluno aluno = new Aluno(dados);
        repository.save(aluno);
        return "redirect:/aluno/listagem";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model)
    {
        model.addAttribute("lista",repository.findAllAlunos(Sort.by(Sort.Direction.DESC, "Id")));
        return "aluno/listagem";
    }

    @DeleteMapping
    @Transactional
    public String delete(Long id){
        repository.deleteById(id);
        return "redirect:/aluno/listagem";
    }

    @PutMapping
    @Transactional
    public String alterar(DadosAlterarAluno dados){
        Aluno aluno = repository.getReferenceById(dados.id());
        aluno.AtualizarAluno(dados);
        return "redirect:/aluno/listagem";
    }
}
