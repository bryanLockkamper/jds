package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurDAO extends JpaRepository<UtilisateurDAL, Long> {

    List<UtilisateurDAL> findByEmail(String email);
    List<UtilisateurDAL> findByPseudo(String pseudo);
    List<UtilisateurDAL> findByNom(String nom);
    List<UtilisateurDAL> findByPrenom(String prenom);
    Optional<UtilisateurDAL> findByNumTel(String numTel);
    List<UtilisateurDAL> findByJeuId(Long jeuId);
    List<UtilisateurDAL> findByRencontreId(Long RencontreId);
    Optional<UtilisateurDAL> findByRencontreId(Long RencontreId);

    List<UtilisateurDAL> findByTempDeJeu(Integer tempDeJeu);

    List<UtilisateurDAL> findByNbrParticipantLimite(Integer nbrParticipantLimite);

    List<UtilisateurDAL> findByUtilisateur(Long idUtilisateur);

    List<UtilisateurDAL> findByUtlisateurList(Long idUtilisateurParticipants);

    List<UtilisateurDAL> findByJeu(Long idJeu);


    private String email;
    @Column(nullable = false)
    private String mdp;
    @Column(nullable = false)
    private String pseudo;
    @Column(nullable = false)
    private LocalDate dateNaiss;
    private String genre;
    private String nom;
    private String prenom;
    private String descr;
    private String numTel;

    @OneToOne
    private PhotoDAL photo;

    @ManyToMany(mappedBy = "utilisateurList")
    private List<JeuDAL> jeuList;

    @ManyToMany(mappedBy = "utilisateurList")
    private List<AdresseDAL> adresseList;

    @ManyToMany(mappedBy = "utilisateurList")
    private List<RencontreDAL> rencontreList;

    @OneToOne
    private RencontreDAL rencontre;
}
