package principal.controladora;

import principal.dao.IInviduoDao;
import principal.domain.Individuo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //CONTROLADOR
public class ControladorRest {

    //CREAMOS EL DAO
    @Autowired
    private IInviduoDao individuoRepository;


    //ESTE ES EL CONTROLADOR MVC LA CUAL NOS LLEVA AL HOLA MUNDO (ACA COMIENZA TODO)

    @GetMapping("/")
    public String comienzo(Model model){

        Iterable<Individuo> individuos = individuoRepository.findAll();
        model.addAttribute("individuos", individuos);
        return "indice";
    }
}
