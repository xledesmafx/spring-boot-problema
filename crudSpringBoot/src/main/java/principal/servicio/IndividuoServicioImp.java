package principal.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import principal.dao.IInviduoDao;
import principal.domain.Individuo;

import java.util.List;

@Service
public class IndividuoServicioImp implements IndividuoServicio{

    @Autowired  //EL CONTROLADOR UTILIZA LA CAPA DE INDIVIDUOSERVICIOIMP
    private IInviduoDao individuoDao;


    @Override
    @Transactional(readOnly = true)  //SOLO VA LEERR
    public List<Individuo> listaIndividuos() {
        return (List<Individuo>) individuoDao.findAll(); //RECUPERA A TODOS LOS INDIVIDUOS
    }

    @Override
    @Transactional //pq si va afectar la bd
    public void salvar(Individuo individuo) {
        individuoDao.save(individuo);    //PARA QUE NOS GUARDE EN LA BASE DE DATOS
    }

    @Override
    @Transactional
    public void borrar(Individuo individuo) {
        individuoDao.delete(individuo);  //BORRA EL INDIVIDUO DE LA BD
    }

    @Override
    @Transactional(readOnly = true)
    public Individuo localizarIndividuo(Individuo individuo) {
        return individuoDao.findById(individuo.getId()).orElse(null);
    }
}
