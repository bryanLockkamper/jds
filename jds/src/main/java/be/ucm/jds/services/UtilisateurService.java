package be.ucm.jds.services;

import be.ucm.jds.DAL.DAO.Class.UtilisateurDAOimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService implements UserDetailsService {

    @Autowired
    private UtilisateurDAOimpl playerDalService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return playerDalService.findByEmail(email).orElse(null);
    }
}
