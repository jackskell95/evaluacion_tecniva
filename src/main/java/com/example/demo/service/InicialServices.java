package com.example.demo.service;

import com.example.demo.model.ObtenerUsuarios;
import com.example.demo.model.Usuario;
import com.example.demo.utils.ResultObjectResponse;

public interface InicialServices {

    ResultObjectResponse obtenerUsuarios(ObtenerUsuarios datos);
    
    ResultObjectResponse agregarUsuario(Usuario datos);
    
    ResultObjectResponse actualizarUsuario(Usuario datos);
    
    ResultObjectResponse eliminarUsuario(Usuario datos);
    

}
