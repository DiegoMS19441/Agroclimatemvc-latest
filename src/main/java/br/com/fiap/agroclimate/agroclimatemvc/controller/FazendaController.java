package br.com.fiap.agroclimate.agroclimatemvc.controller;

import br.com.fiap.agroclimate.agroclimatemvc.model.*;
import br.com.fiap.agroclimate.agroclimatemvc.repositories.ColheitaRepository;
import br.com.fiap.agroclimate.agroclimatemvc.repositories.FazendaRepository;
import br.com.fiap.agroclimate.agroclimatemvc.repositories.InfoPlantacaoRepository;
import br.com.fiap.agroclimate.agroclimatemvc.repositories.SafraRepository;
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
@RequestMapping("fazenda")
public class FazendaController {

    @Autowired
    private FazendaRepository fazendaRepository;

    @Autowired
    private SafraRepository safraRepository;

    @Autowired
    private ColheitaRepository colheitaRepository;

    @Autowired
    private InfoPlantacaoRepository infoPlantacaoRepository;

    @GetMapping("home")
    public String home(){
        return "fazenda/home";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Fazenda fazenda, Model model) {
        model.addAttribute("clima", Clima.values());
        model.addAttribute("safras", safraRepository.findAll());
        return "fazenda/cadastro";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid Fazenda fazenda,
                            BindingResult result,
                            RedirectAttributes redirect, Model model) {
        if(result.hasErrors()){
            model.addAttribute("clima", Clima.values());
            model.addAttribute("safras", safraRepository.findAll());
            return "fazenda/cadastro";
        }

        fazendaRepository.save(fazenda);

        if (fazenda.getSafras() != null) {
            for (Safra safra : fazenda.getSafras()) {
                safra.setFazenda(fazenda);
                safraRepository.save(safra);

                if (safra.getColheita() != null) {
                    safra.getColheita().setSafra(safra);
                    colheitaRepository.save(safra.getColheita());
                }
                if (safra.getInfoPlantacao() != null) {
                    safra.getInfoPlantacao().setSafra(safra);
                    infoPlantacaoRepository.save(safra.getInfoPlantacao());
                }
            }
        }

        redirect.addFlashAttribute("mensagem", "Cadastrado com sucesso!");
        return "redirect:/fazenda/cadastrar";
    }

    @GetMapping("listar")
    public String listarFazendas(Model model) {
        model.addAttribute("fazendas", fazendaRepository.findAll());
        return "fazenda/listar";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("fazenda", fazendaRepository.findById(id));
        model.addAttribute("safras", safraRepository.findAll());
        model.addAttribute("clima", Clima.values());
        return "fazenda/editar";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(@Valid Fazenda fazenda, BindingResult result, RedirectAttributes redirectAttributes, Model model){
        if (result.hasErrors()) {
            model.addAttribute("clima", Clima.values());
            model.addAttribute("safras", safraRepository.findAll());
            return "fazenda/editar";
        }

        if (fazenda.getSafras() != null) {
            for (Safra safra : fazenda.getSafras()) {
                safra.setFazenda(fazenda);
                safraRepository.save(safra);

                if (safra.getColheita() != null) {
                    safra.getColheita().setSafra(safra);
                    colheitaRepository.save(safra.getColheita());
                }

                if (safra.getInfoPlantacao() != null) {
                    safra.getInfoPlantacao().setSafra(safra);
                    infoPlantacaoRepository.save(safra.getInfoPlantacao());
                }
            }
        }

        fazendaRepository.save(fazenda);
        redirectAttributes.addFlashAttribute("mensagem", "Atualizado com sucesso");
        return "redirect:/fazenda/listar";
    }

    @PostMapping("remover")
    @Transactional
    public String remover(Long id, RedirectAttributes redirectAttributes) {
        fazendaRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Fazenda removida");
        return "redirect:/fazenda/listar";
    }
}
