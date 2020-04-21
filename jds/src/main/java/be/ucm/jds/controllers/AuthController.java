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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "Appelé a chaque fois qu'un joueur voudrat s'enregistrer")
    @PostMapping("/inscription")
    public ResponseEntity<String> register(@RequestBody UtilisateurRegister playerDTO) {

        playerDTO.setPassword(hashConfig.getPasswordEncoder().encode(playerDTO.getPassword()));
        UtilisateurDAL playerEntity = UtilisateurMapperDAL.utilisateurRegister_To_UtilisateurDAL(playerDTO);
        utilisateurDAOimpl.save(playerEntity);

        return ResponseEntity.ok("200");
    }

    /*@PostMapping("/seConnecter")
    public ResponseEntity<Utilisateur> seConnecter(@RequestBody UtilisateurLogin utilisateur) {
        UtilisateurDAL utilisateurDAL = (UtilisateurDAL) utilisateurDAOimpl.findByEmail(utilisateur.getEmail());
        System.out.println(utilisateur);
        if (utilisateurDAL != null) {

            if (verifierMdp(utilisateur.getPassword()))
                return ResponseEntity.ok(UtilisateurMapperDAL.utilisateurDAL_To_Utilisateur(utilisateurDAL));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/seDeconnecter")
    public void seDeconnecter(@RequestBody Utilisateur utilisateur) {
        //jeuDAL.save(jeu);
        System.out.println(utilisateur);
    }

    @PostMapping("/rafraichirToken")
    public void rafraichirToken(@RequestBody Long id) {
        //jeuDAL.save(jeu);
        System.out.println(id);
    }

    @PostMapping("/inscription")
    public ResponseEntity<Utilisateur> inscription(@RequestBody UtilisateurRegister utilisateur) {
        if (utilisateurDAOimpl.findByEmail(utilisateur.getEmail()) == null
                && utilisateur.getPassword().equals(utilisateur.getConfirmpassword())
                && LocalDate.now().minusYears(18).isAfter(utilisateur.getDateNaissance())) {

            if (verifierMdp(utilisateur.getPassword()))
                return ResponseEntity.ok(UtilisateurMapperDAL.utilisateurDAL_To_Utilisateur(utilisateurDAOimpl.save(UtilisateurMapperDAL.utilisateurRegister_To_UtilisateurDAL(utilisateur))));


        }
        return ResponseEntity.notFound().build();
    }*/

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
