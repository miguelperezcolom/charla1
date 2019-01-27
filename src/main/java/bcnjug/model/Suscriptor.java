package bcnjug.model;

import io.mateu.mdd.core.annotations.Action;
import io.mateu.mdd.core.annotations.TextArea;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Set;

@Entity@Getter@Setter
public class Suscriptor {

    @Id
    private String email;

    private String nombre;

    private boolean activo = true;

    private LocalDateTime creado = LocalDateTime.now();


    public Suscriptor() {

    }

    public Suscriptor(String email, String nombre) {
        this.email = email;
        this.nombre = nombre;
    }


    @Action
    public static void enviarEmails(
            @NotEmpty String asunto,
            @NotEmpty@TextArea String texto,
            Set<Suscriptor> seleccion) {
        seleccion.forEach(s -> System.out.println("Enviar email a " + s.getNombre()));
    }

}
