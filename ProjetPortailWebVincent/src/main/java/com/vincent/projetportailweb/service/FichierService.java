        package com.vincent.projetportailweb.service;

        import com.vincent.projetportailweb.entities.Fichier;
        import com.vincent.projetportailweb.repos.FichierRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.core.io.Resource;
        import org.springframework.core.io.ResourceLoader;
        import org.springframework.stereotype.Service;
        import org.springframework.web.multipart.MultipartFile;

        import javax.transaction.Transactional;
        import java.io.IOException;
        import java.util.List;

        @Service
        public class FichierService {

            @Autowired
            private FichierRepository fichierRepository;




            public List<Fichier> affichierFichier(){
                return ( List<Fichier>)  fichierRepository.findAll();
            }



            private final ResourceLoader resourceLoader;


            @Autowired
            public FichierService(ResourceLoader resourceLoader) {
                this.resourceLoader = resourceLoader;
            }




            public Resource load(String filename) {
                try {
                    Resource resource = resourceLoader.getResource("classpath:/uploaded-files/" + filename);

                    if (resource.exists() && resource.isReadable()) {
                        return resource;
                    } else {
                        throw new RuntimeException("Could not read the file!");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Error: " + e.getMessage());
                }
            }

            public Fichier uploadImage(MultipartFile file) throws IOException {
                Fichier fichier = new Fichier();
                fichier.setNom(file.getOriginalFilename());
                fichier.setContenu(file.getContentType());
                fichier.setData(file.getBytes());
                return fichierRepository.save(fichier);
            }


            @Transactional
            public void delete(Integer id) throws FichierNotFoundException {
                Fichier fichier =  fichierRepository.findById(id)
                        .orElseThrow(() -> new FichierNotFoundException("fichiers non trouvé " + id));

              fichierRepository.deleteById(id);
            }


        }