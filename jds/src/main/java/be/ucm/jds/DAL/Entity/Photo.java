package be.ucm.jds.DAL.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_photo;

    private String lien_photo;

    @ManyToMany
    private List<Adresse> adresseList_photo;
}
