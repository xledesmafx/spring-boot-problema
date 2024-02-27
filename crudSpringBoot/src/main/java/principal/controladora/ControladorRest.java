package principal.controladora;

import jakarta.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import principal.domain.Individuo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import principal.servicio.IndividuoServicio;

import java.util.List;

@Controller //CONTROLADOR
public class ControladorRest {

    //CREAMOS EL DAO
    @Autowired
    private IndividuoServicio individuoServicio;


    //ESTE ES EL CONTROLADOR MVC LA CUAL NOS LLEVA AL HOLA MUNDO (ACA COMIENZA TODO)

    @GetMapping("/")
    public String comienzo(Model model){

        List<Individuo> individuos = individuoServicio.listaIndividuos();
        model.addAttribute("individuos", individuos);
        return "indice";
    }

    //AGREGAMO EL MAPEO PARA ALTA INDIVIDUO ANEXAR

    //MAPEOS PARA EL GUARDADO DEL INDIVIDUO
    @GetMapping("/anexar")
    public String anexar(Model model){
        Individuo individuo = new Individuo();
        model.addAttribute("individuo", individuo);
        return "cambiar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Individuo individuo, Errors error){
        if(error.hasErrors()){
            return "cambiar";
        }
        individuoServicio.salvar(individuo);
        return "cambiar";
    }

    //modificar
    @GetMapping("/cambiar/{id}")
    public String cambiar(Individuo individuo, Model model){
        individuo = individuo = individuoServicio.localizarIndividuo(individuo);
        model.addAttribute("individuo",individuo);
        return "cambiar";
    }

    //ELIMINAR
    @GetMapping("/borrar/{id}")
    public String borrar(Individuo individuo){
        individuoServicio.borrar(individuo);
        return "redirect:/";
    }

}
