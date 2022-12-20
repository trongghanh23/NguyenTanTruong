package com.example.smartphones.service.decentralization;

import com.example.smartphones.model.decentralization.Role;


import java.util.List;

public interface IRoleService {

    List<Role> findAllRole();

    List<Role> getAllRoles();

    void saveCreateGmail(String email);

    List<Role> getRoleByUsername(String email);

}
