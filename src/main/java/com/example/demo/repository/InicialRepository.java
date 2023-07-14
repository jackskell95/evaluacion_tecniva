package com.example.demo.repository;

import java.util.ArrayList;

import com.example.demo.model.ObtenerUsuarios;
import com.example.demo.model.Usuario;
import com.example.demo.utils.ResultObjectResponse;

public interface InicialRepository {

    ResultObjectResponse obtenerUsuarios(ObtenerUsuarios datos);
    
    ResultObjectResponse agregarUsuario(Usuario datos);
    
    ResultObjectResponse actualizarUsuario(Usuario datos);
    
    ResultObjectResponse eliminarUsuario(Usuario datos);
    
}
