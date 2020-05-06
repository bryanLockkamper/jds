package be.ucm.jds.DAL.DAO.Class;

import be.ucm.jds.DAL.DAO.Interface.GroupeDAO;
import be.ucm.jds.DAL.DAO.Interface.RoleDAO;
import be.ucm.jds.DAL.Entity.GroupeDAL;
import be.ucm.jds.DAL.Entity.RoleDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupeDAOimpl {
    private final GroupeDAO groupeDAO;

    @Autowired
    public GroupeDAOimpl(GroupeDAO groupeDAO) {
        this.groupeDAO = groupeDAO;
    }

    public Optional<GroupeDAL> findById(Long id) {
        return this.groupeDAO.findById(id);
    }

    public List<GroupeDAL> getAll() {
        return this.groupeDAO.findAll();
    }
}
