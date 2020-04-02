package be.ucm.jds.BL.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UtilisateurLogin {

    private String email;
    private String password;
}
