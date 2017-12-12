package PersistenceVacunas;

import PersistenceHijos.Hijos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-12T15:09:04")
@StaticMetamodel(Vacunas.class)
public class Vacunas_ { 

    public static volatile SingularAttribute<Vacunas, String> nombreVacuna;
    public static volatile SingularAttribute<Vacunas, Hijos> idHijo;
    public static volatile SingularAttribute<Vacunas, Date> fechaAplicacion;
    public static volatile SingularAttribute<Vacunas, Character> aplicada;
    public static volatile SingularAttribute<Vacunas, Integer> idVacuna;

}