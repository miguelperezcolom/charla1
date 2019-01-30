package bcnjug.model;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Image;
import io.mateu.mdd.core.annotations.SameLine;
import lombok.Getter;

@Getter
public class Perfil {

    private Image foto =
            new Image("",
                    new ExternalResource(
                            "https://pbs.twimg.com/" +
                            "profile_images/675496971763773440/" +
                                    "p8oE-vA8_400x400.jpg"));


    private String texto = "bwdh wehwedowe dwed wudweud " +
            "ewdiwedw ediwediwed" +
            "wudewudhwed wediwediwed wdiwdiwedwed wdiwed" +
            "wudweuduwed wdi widbw diw diw dw" +
            "wdwuendwe diw diwd wid iw ede whed ehd" +
            "wdiewidwed wied edwd i we" +
            "weduiwed wediwd w dw diwd wi di wd" +
            "weudwidw";


    @Override
    public String toString() {
        return "Yo, Donald";
    }

}
