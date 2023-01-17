package com.groupeisi.pointage.web;

import com.groupeisi.pointage.entities.Professeur;
import com.groupeisi.pointage.repositories.ProfesseurRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProfesseurController {

    private ProfesseurRepository professeurRepository;
    @GetMapping(path = "/index")
    public String professeurs(Model model,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "5") int size,
                              @RequestParam(name = "keyword", defaultValue = "") String keyword){
        Page<Professeur> pageProfesseurs=professeurRepository.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("ListProfesseurs",pageProfesseurs.getContent());
        model.addAttribute("pages",new int[pageProfesseurs.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword", keyword);
        return "professeurs";
    }

    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page){
        professeurRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
    @GetMapping("/formProfesseurs")
    public String formProfesseurs(Model model){
        model.addAttribute("professeur",new Professeur());
        return "formProfesseurs";
    }
    @GetMapping(path="/save")
    public String save(Model model, Professeur professeur){
       professeurRepository.save(professeur);
        return "redirect:/index";
    }
}
