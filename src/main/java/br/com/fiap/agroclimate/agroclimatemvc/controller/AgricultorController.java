package br.com.fiap.agroclimate.agroclimatemvc.controller;

import br.com.fiap.agroclimate.agroclimatemvc.model.Agricultor;
import br.com.fiap.agroclimate.agroclimatemvc.repositories.AgricultorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("agricultor")
public class AgricultorController {

    @Autowired
    private AgricultorRepository agricultorRepository;


    @GetMapping("home")
    public String home(){
        return "agricultor/home";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Agricultor agricultor) {
        return "agricultor/cadastro";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid Agricultor agricultor,
                            BindingResult result,
                            RedirectAttributes redirect) {
        if(result.hasErrors()){
            return "agricultor/cadastro";
        }
        agricultorRepository.save(agricultor);
        redirect.addFlashAttribute("mensagem", "Cadastrado com sucesso!");
        return "redirect:/agricultor/cadastrar";
    }

    @GetMapping("listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("agricultores", agricultorRepository.findAll());
        return "agricultor/listar";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("agricultor", agricultorRepository.findById(id));
        return "agricultor/editar";
    }

    @PostMapping("editar")
    public String editar(@Valid Agricultor agricultor, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "agricultor/editar";
        }
        agricultorRepository.save(agricultor);
        redirectAttributes.addFlashAttribute("mensagem", "Atualizado com sucesso");
        return "redirect:/agricultor/listar";
    }

    @PostMapping("remover")
    @Transactional
    public String remover(Long id, RedirectAttributes redirectAttributes) {
        agricultorRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Agricultor removido");
        return "redirect:/agricultor/listar";
    }
}
