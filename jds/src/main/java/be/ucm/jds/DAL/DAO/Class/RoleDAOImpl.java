package be.ucm.jds.DAL.DAO.Class;

import be.ucm.jds.BL.Entity.ListRoles;
import be.ucm.jds.DAL.DAO.Interface.RoleDAO;
import be.ucm.jds.DAL.Entity.RoleDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class RoleDAOImpl {

    private RoleDAO roleDAO;

    @Autowired
    public RoleDAOImpl(RoleDAO roleDAO){ this.roleDAO = roleDAO;}

    public Optional<RoleDAL> findById(Long id){return this.roleDAO.findById(id);}

    public List<Optional<RoleDAL>> getAll(){return  this.roleDAO.getAll();}
}
