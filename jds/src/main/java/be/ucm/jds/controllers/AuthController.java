package be.ucm.jds.controllers;

import be.ucm.jds.BL.Entity.Utilisateur;
import be.ucm.jds.BL.Entity.UtilisateurDTOInfo;
import be.ucm.jds.BL.Entity.UtilisateurLogin;
import be.ucm.jds.BL.Entity.UtilisateurRegister;
import be.ucm.jds.DAL.DAO.Class.UtilisateurDAOimpl;
import be.ucm.jds.DAL.Entity.RoleDAL;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import be.ucm.jds.DAL.mappers.UtilisateurMapperDAL;
import be.ucm.jds.configuration.HashConfig;
import be.ucm.jds.configuration.JwtTokenProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class AuthController {


    private UtilisateurDAOimpl utilisateurDAOimpl;

    private AuthenticationManager authenticationManager;

    private JwtTokenProvider jwtTokenProvider;

    private HashConfig hashConfig;
    private boolean bol;

    public AuthController(UtilisateurDAOimpl utilisateurDAOimpl, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, HashConfig hashConfig) {
        this.utilisateurDAOimpl = utilisateurDAOimpl;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.hashConfig = hashConfig;
    }

    @ApiOperation(value = "Appelé a chaque fois qu'un joueur veut se connecter")
    @PostMapping("/seConnecter")
    public ResponseEntity signin(@RequestBody UtilisateurLogin data)
    {
        try {
            String login = data.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login,(data.getPassword())));
            String token = jwtTokenProvider.createToken(login,this.utilisateurDAOimpl.findByEmail(login).orElseThrow(() -> new UsernameNotFoundException("Email "+ login+ "not found")).getRoles().stream().map(RoleDAL::getAuthority).collect(Collectors.toList()),new UtilisateurDTOInfo(this.utilisateurDAOimpl.findByEmail(login).get()));
            Map model = new HashMap();
            model.put("token",token);
            model.put("username",login);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e)
        {
            throw new BadCredentialsException("Invalid login/password");
        }
    }

    @ApiOperation(value = "Appelé a chaque fois qu'un joueur voudra s'enregistrer")
    @PostMapping("/inscription")
    public ResponseEntity<String> register(@RequestBody UtilisateurRegister utilisateurRegister) {

        if (!utilisateurDAOimpl.findByEmail(utilisateurRegister.getEmail()).isPresent()
                && utilisateurRegister.getPassword().equals(utilisateurRegister.getConfirmpassword())
                && LocalDate.now().minusYears(18).isAfter(utilisateurRegister.getDateNaissance())) {

            if (verifierMdp(utilisateurRegister.getPassword())) {
                utilisateurRegister.setPassword(hashConfig.getPasswordEncoder().encode(utilisateurRegister.getPassword()));
                UtilisateurDAL playerEntity = UtilisateurMapperDAL.utilisateurRegister_To_UtilisateurDAL(utilisateurRegister);
                utilisateurDAOimpl.save(playerEntity);

                return ResponseEntity.ok("200");
            }
            return ResponseEntity.ok("Mot de passe invalide!");
        }
        return ResponseEntity.ok("Email déjà existant!");
    }

    @PostMapping("/rafraichirToken")
    public void rafraichirToken(@RequestBody Long id) {
        System.out.println(id);
    }

    private boolean verifierMdp(String mdp) {
        boolean containsMajuscule = false;
        boolean containsNumber = false;
        for (int i = 0; i < mdp.length() & (!containsMajuscule | !containsNumber); i++) {
            char c = mdp.charAt(i);
            if (c > 'A' & c < 'Z')
                containsMajuscule = true;

            if (c > '0' & c < '9')
                containsNumber = true;
        }
        return containsMajuscule & containsNumber & mdp.length() >= 8;
    }
}
