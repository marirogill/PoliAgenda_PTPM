package PersistenceHijos;

import PersistenceUsuario.Usuario;
import PersistenceVacunas.Vacunas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-28T14:54:53")
@StaticMetamodel(Hijos.class)
public class Hijos_ { 

    public static volatile SingularAttribute<Hijos, Integer> idHijo;
    public static volatile SingularAttribute<Hijos, String> apellidoHijo;
    public static volatile SingularAttribute<Hijos, Date> fechaNacimiento;
    public static volatile SingularAttribute<Hijos, Usuario> idUsuario;
    public static volatile SingularAttribute<Hijos, String> nombreHijo;
    public static volatile CollectionAttribute<Hijos, Vacunas> vacunasCollection;

}