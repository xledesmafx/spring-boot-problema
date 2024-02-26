package principal.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data  //--> DE LOMBOK Y SIRVE PARA AGREGAR LO SETS, CONTRUCTORES, TO STRING ETC AUTOMATICAMENTE
@Entity  //PARA PONER COMO ENTIDAD
@Table(name="individuo"
)
public class Individuo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //PARA QUE SE AUTOGENERE EL ID
    private long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private int edad;


}
