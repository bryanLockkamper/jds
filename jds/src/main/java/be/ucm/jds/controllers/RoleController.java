package be.ucm.jds.controllers;

import be.ucm.jds.BL.Entity.Role;
import be.ucm.jds.DAL.DAO.Class.RoleDAOImpl;
import be.ucm.jds.DAL.mappers.RoleMapperDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class RoleController {

    RoleDAOImpl roleDAO;

    @Autowired
    public RoleController (RoleDAOImpl roleDAO){ this.roleDAO = roleDAO;}

    @GetMapping
    public List<Role> getRoles(){
        return roleDAO.getAll()
                .stream()
                .map(roleDAL ->  RoleMapperDAL.roleDAL_To_Role(roleDAL.orElse(null)))
                .collect(Collectors.toList());
    }
}
