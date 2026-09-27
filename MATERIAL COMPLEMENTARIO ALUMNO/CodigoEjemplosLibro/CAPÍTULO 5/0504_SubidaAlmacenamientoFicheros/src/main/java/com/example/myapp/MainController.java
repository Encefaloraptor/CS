package com.example.myapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

    @Autowired
    public FileStorageService fileStorageService;

    List <FormInfo> forms = new ArrayList<>();

    @GetMapping("/")
    public String showList(@RequestParam (required=false) Integer err, Model model) {
        if (err!=null) model.addAttribute("txtErr","Error en ficheros");
        model.addAttribute("forms", forms);
        return "indexView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("form", new FormInfo());
        return "newFormView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(FormInfo formInfo, @RequestParam MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                formInfo.setImagen(fileStorageService.store(file));
                forms.add(formInfo);
            } catch (Exception e) {
                return "redirect:/?err=1";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable int id) {
        id--;
        if (id<0 || id >=forms.size())return "redirect:/?err=1";;
        try { 
           fileStorageService.delete(forms.get(id).getImagen());
           forms.remove(id);
        }
        catch (RuntimeException e) {return "redirect:/?err=1";}
        return "redirect:/";
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = fileStorageService.loadAsResource(filename);
        return ResponseEntity.ok().body(file);
    }

}
