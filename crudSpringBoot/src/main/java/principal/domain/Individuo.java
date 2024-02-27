package principal.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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


    //PARA QUE NO PERMITA CAMPOS VACIOS (DPENDENCIA VALIDATION)

    @NotEmpty //--> QUE NO SEA VACIO ( SE RECOMIENDA PARA CADENAS)
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    private String telefono;
    @NotEmpty
    @Email
    private String correo;
    @NotNull
    private int edad;


}
