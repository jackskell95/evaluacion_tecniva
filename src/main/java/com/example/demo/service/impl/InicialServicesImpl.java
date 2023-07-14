package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.ObtenerUsuarios;
import com.example.demo.model.Usuario;
import com.example.demo.repository.InicialRepository;
import com.example.demo.service.InicialServices;
import com.example.demo.utils.ResultObjectResponse;


@Service
public class InicialServicesImpl implements InicialServices {

    @Autowired
    private InicialRepository iniRep;

    /**
     * Get user records
     *
     * @param datos Information needed to obtain the list of users of type ObtenerUsuarios.
     * @return ResultObjectResponse
     */
    @Override
    public ResultObjectResponse obtenerUsuarios(ObtenerUsuarios datos) {
        return iniRep.obtenerUsuarios(datos);
    }

    /**
     * Add user record
     *
     * @param datos Information needed to add a user of type User.
     * @return ResultObjectResponse
     */
    @Override
    public ResultObjectResponse agregarUsuario(Usuario datos) {
        return iniRep.agregarUsuario(datos);
    }

    /**
     * Update user record
     *
     * @param datos Information needed to update a user of type User.
     * @return ResultObjectResponse
     */
    @Override
    public ResultObjectResponse actualizarUsuario(Usuario datos) {
        return iniRep.actualizarUsuario(datos);
    }

    /**
     * Delete user record
     *
     * @param datos Information needed to delete a user of type User.
     * @return ResultObjectResponse
     */
    @Override
    public ResultObjectResponse eliminarUsuario(Usuario datos) {
        return iniRep.eliminarUsuario(datos);
    }


}
