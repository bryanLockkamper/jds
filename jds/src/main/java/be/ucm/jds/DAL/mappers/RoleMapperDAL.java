package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Role;
import be.ucm.jds.DAL.Entity.RoleDAL;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;

public class RoleMapperDAL {

    public static Role roleDAL_To_Role(RoleDAL roleDAL){
        return new ModelMapper().map(roleDAL, Role.class);
    }

    public static RoleDAL role_To_RoleDAL(Role role){
        return new ModelMapper().map(role,RoleDAL.class);
    }
}
