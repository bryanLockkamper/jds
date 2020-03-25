package be.ucm.jds.BL.Entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurRegister {

    private String pseudo;
    private String password;
    private String confirmpassword;
    private String email;
    private LocalDate dateNaissance;

}
