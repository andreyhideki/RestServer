package br.unicesumar.restserver.pessoa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
@Transactional //usado para criar transacoes
public class PessoaController {
    
    @Autowired
    private EntityManager em; //para persistir a pessoa
    
    @RequestMapping(value = "/fisicas", method = RequestMethod.POST)
    public void criarFisica(@RequestParam String nome, @RequestParam String cpf){
        Pessoa nova = new Fisica(cpf, nome);
        em.persist(nova);
    }
    
    @RequestMapping(value = "/juridicas", method = RequestMethod.POST)
    public void criarJuridica(@RequestParam String nome, @RequestParam String cnpj){
        Pessoa nova = new Juridica(cnpj, nome);
        em.persist(nova);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Pessoa> recuperarPessoa(){
        return em.createQuery("from Pessoa p").getResultList();
    }
    
    @RequestMapping(value = "/fisicas", method = RequestMethod.GET)
    public List<Fisica> recuperarFisicas(){
        return em.createQuery("from Fisica p").getResultList();
    }
    
    @RequestMapping(value = "/juridicas", method = RequestMethod.GET)
    public List<Juridica> recuperarJuridicas(){
        return em.createQuery("from Juridica p").getResultList();
    }
}
