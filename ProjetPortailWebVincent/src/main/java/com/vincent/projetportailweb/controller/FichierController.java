    package com.vincent.projetportailweb.controller;


    import com.vincent.projetportailweb.entities.Fichier;
    import com.vincent.projetportailweb.service.FichierNotFoundException;
    import com.vincent.projetportailweb.service.FichierService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.core.io.Resource;
    import org.springframework.http.HttpHeaders;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.multipart.MultipartFile;
    import org.springframework.web.servlet.mvc.support.RedirectAttributes;

    import java.io.IOException;


    @Controller
    public class FichierController {

        @Autowired
        private FichierService fichierService;
        @GetMapping("/listeProfNotes")
        public String afficher(Model model) {
            Iterable<Fichier> fileList = fichierService.affichierFichier();
            model.addAttribute("list", fileList);
            return "listeProfNotes";
        }


        @GetMapping("/listeProfNotes/download/{filename:.+}")
        @ResponseBody
        public ResponseEntity<Resource> getFile(@PathVariable String filename) {
            Resource file = fichierService.load(filename);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        }

        @PostMapping("/listeProfNotes")
        public String uploadImage(@RequestParam("file") MultipartFile file, Model model,RedirectAttributes redirectAttributes) throws IOException {
            fichierService.uploadImage(file);
            Iterable<Fichier> fileList = fichierService.affichierFichier();
            model.addAttribute("list", fileList);
            redirectAttributes.addFlashAttribute("message", "Le fichier a été ajouter avec succès");

            return "redirect:/listeProfNotes";

        }


        @GetMapping("/listeProfNotes/delete/{id}")
        public String supprimerFichier(@PathVariable(name = "id") Integer id,
                                           Model model,
                                           RedirectAttributes redirectAttributes) {
            try {
                fichierService.delete(id);
                redirectAttributes.addFlashAttribute("message", "Le fichier a été supprimé avec succès");
            } catch (FichierNotFoundException ex) {
                redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver le fichier ");
            }

            return "redirect:/listeProfNotes"; // Redirect to the upload page
        }


    }
