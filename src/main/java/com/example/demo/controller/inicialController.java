package com.example.demo.controller;

import com.example.demo.utils.ResultObjectResponse;
import com.example.demo.service.InicialServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ObtenerUsuarios;
import com.example.demo.model.Usuario;

@RestController
@RequestMapping("/api")
public class inicialController {

    @Autowired
    InicialServices iniServ;


    /**
     * Get user records
     *
     * @param datos Information needed to obtain the list of users of type ObtenerUsuarios.
     * @return ResultObjectResponse
     */
    @GetMapping(value = "/obtener-usuarios", consumes = {"application/json"})
    public ResultObjectResponse obtenerUsuarios(@RequestBody ObtenerUsuarios datos) {
        return iniServ.obtenerUsuarios(datos);
    }
    
    /**
     * Add user record
     *
     * @param datos Information needed to add a user of type User.
     * @return ResultObjectResponse
     */
    @PostMapping(value = "/agregar-usuario", consumes = {"application/json"})
    public ResultObjectResponse agregarUsuario(@RequestBody Usuario datos) {
        return iniServ.agregarUsuario(datos);
    }

    /**
     * Update user record
     *
     * @param datos Information needed to update a user of type User.
     * @return ResultObjectResponse
     */
    @PostMapping(value = "/actualizar-usuario", consumes = {"application/json"})
    public ResultObjectResponse actualizarUsuario(@RequestBody Usuario datos) {
        return iniServ.actualizarUsuario(datos);
    }
    
    /**
     * Delete user record
     *
     * @param datos Information needed to delete a user of type User.
     * @return ResultObjectResponse
     */
    @PostMapping(value = "/eliminar-usuario", consumes = {"application/json"})
    public ResultObjectResponse eliminarUsuario(@RequestBody Usuario datos) {
        return iniServ.eliminarUsuario(datos);
    }


}
