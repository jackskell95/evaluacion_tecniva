package com.example.demo.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.mapping.UsuarioRowMapper;
import com.example.demo.model.ObtenerUsuarios;
import com.example.demo.model.Usuario;
import com.example.demo.repository.InicialRepository;
import com.example.demo.utils.ResultObjectResponse;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Repository
public class InicialRepositoryImpl implements InicialRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("dataSource")
    public void setDataSource(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Get user records
     *
     * @param datos Information needed to obtain the list of users of type ObtenerUsuarios.
     * @return ResultObjectResponse
     */
    @Override
    public ResultObjectResponse obtenerUsuarios(ObtenerUsuarios datos) {
        try {
            String consulta = "SELECT id, nombre, apellidos, correo, fecha_nacimiento from USUARIO ORDER BY id "+(datos.getOrden()==0?"ASC":"DESC")+" LIMIT "+datos.getRegistroInicial()+", "+datos.getTotalRegistros()+"; ";
            List<Usuario> lista = this.jdbcTemplate.query(consulta, new UsuarioRowMapper());
            return new ResultObjectResponse(1, false, "Success", lista);
        } catch (Exception e) {
            return new ResultObjectResponse(0, true, e.getCause().getMessage(), null);
        }
    }

    /**
     * Add user record
     *
     * @param datos Information needed to add a user of type User.
     * @return ResultObjectResponse
     */
    @Override
    public ResultObjectResponse agregarUsuario(Usuario datos) {
        try {
            if (datos.getNombre() != "" && datos.getApellidos() != "" && datos.getCorreo() != "" && datos.getFecha_nacimiento()  != ""){
                String consulta = "INSERT INTO USUARIO (nombre, apellidos, correo, fecha_nacimiento) VALUES(?, ?, ?, ?)";
                int valid = this.jdbcTemplate.update(consulta, datos.getNombre(), datos.getApellidos(), datos.getCorreo(), datos.getFecha_nacimiento());
                if (valid == 0) {
                    return new ResultObjectResponse(0, true, "Error al insertar el usuarioo", null);
                }
                return new ResultObjectResponse(1, false, "Success", null);
            } else {
                return new ResultObjectResponse(0, true, "Error, falta informació", null);
            }
        } catch (Exception e) {
            return new ResultObjectResponse(0, true, e.getCause().getMessage(), null);
        }
    }

    /**
     * Update user record
     *
     * @param datos Information needed to update a user of type User.
     * @return ResultObjectResponse
     */
    @Override
    public ResultObjectResponse actualizarUsuario(Usuario datos) {
        try {
            if (datos.getId() > 0 && datos.getNombre() != "" && datos.getApellidos() != "" && datos.getCorreo() != "" && datos.getFecha_nacimiento()  != ""){
                String consulta = "UPDATE USUARIO SET nombre = ?, apellidos = ?, correo = ?, fecha_nacimiento = ? WHERE id = ?";
                int valid = this.jdbcTemplate.update(consulta, datos.getNombre(), datos.getApellidos(), datos.getCorreo(), datos.getFecha_nacimiento(), datos.getId());
                if (valid == 0) {
                    return new ResultObjectResponse(0, true, "Error al actualizar el usuarioo", null);
                }
                return new ResultObjectResponse(1, false, "Success", null);
            } else {
                return new ResultObjectResponse(0, true, "Error, falta informació", null);
            }
        } catch (Exception e) {
            return new ResultObjectResponse(0, true, e.getCause().getMessage(), null);
        }
    }

    /**
     * Delete user record
     *
     * @param datos Information needed to delete a user of type User.
     * @return ResultObjectResponse
     */
    @Override
    public ResultObjectResponse eliminarUsuario(Usuario datos) {
        try {
            if (datos.getId() > 0){
                String consulta = "DELETE FROM USUARIO WHERE id = ?";
                int valid = this.jdbcTemplate.update(consulta, datos.getId());
                if (valid == 0) {
                    return new ResultObjectResponse(0, true, "Error al eliminar el usuarioo", null);
                }
                return new ResultObjectResponse(1, false, "Success", null);
            } else {
                return new ResultObjectResponse(0, true, "Error, falta informació", null);
            }
        } catch (Exception e) {
            return new ResultObjectResponse(0, true, e.getCause().getMessage(), null);
        }
    }


}
