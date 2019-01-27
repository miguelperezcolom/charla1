package bcnjug;

import bcnjug.model.Perfil;
import bcnjug.model.Proyecto;
import bcnjug.model.Suscriptor;
import io.mateu.mdd.core.annotations.Action;
import io.mateu.mdd.core.annotations.Private;
import io.mateu.mdd.core.app.AbstractAction;
import io.mateu.mdd.core.app.MDDOpenCRUDAction;
import io.mateu.mdd.core.app.SimpleMDDApplication;
import io.mateu.mdd.core.util.Helper;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class MyApp extends SimpleMDDApplication {

    @Action(order = 1)
    public Perfil perfil() {
        return new Perfil();
    }

    @Action(order = 3)
    public void suscribirme(@NotEmpty String nombre,
      @NotEmpty String email) throws Throwable {
        Helper.transact(em -> {
            em.persist(new Suscriptor(email, nombre));
        });
    }

    @Action(order = 2)
    public List<Proyecto> proyectos() throws Throwable {
        return Helper.selectObjects(
                "select x from " +
                        Proyecto.class.getName() +
                        " x order by x.nombre");
    }

    @Action(value = "Proyectos", order = 4)
    @Private
    public AbstractAction misProyectos() {
        return new MDDOpenCRUDAction(Proyecto.class);
    }

    @Action(order = 5)
    @Private
    public AbstractAction suscriptores() {
        return new MDDOpenCRUDAction(Suscriptor.class);
    }

}