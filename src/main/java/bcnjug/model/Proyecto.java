package bcnjug.model;

import io.mateu.mdd.core.annotations.MainSearchFilter;
import io.mateu.mdd.core.util.Helper;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity@Getter@Setter
public class Proyecto {

    @Id@GeneratedValue
    private long id;

    @NotEmpty@MainSearchFilter
    private String nombre;

    private LocalDate creado = LocalDate.now();

    @NotNull
    private TipoProyecto tipo;

    private boolean hecho;


    @PostPersist
    public void postPersist() throws Throwable {
        Helper.notransact(em -> {
          em.createQuery(
         "select s from " +
                 Suscriptor.class.getName() + " s")
          .getResultList()
          .forEach(s ->
            System.out.println(
                    "Enviando email a " + s));
        });
    }

}
