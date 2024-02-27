package principal.servicio;

import principal.domain.Individuo;

import java.util.List;

public interface IndividuoServicio {
    //ACA VAN LOS METODS QUE UTILIZAREMOS PARA EL CRUD

    public List<Individuo> listaIndividuos();

    public void salvar(Individuo individuo);

    public void  borrar(Individuo individuo);

    public Individuo localizarIndividuo(Individuo individuo);
}
