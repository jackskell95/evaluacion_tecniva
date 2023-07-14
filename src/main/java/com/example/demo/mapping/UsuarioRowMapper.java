package com.example.demo.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Usuario;

public class UsuarioRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuario row = new Usuario();
        row.setId(rs.getInt(1));
        row.setNombre(rs.getString(2));
        row.setApellidos(rs.getString(3));
        row.setCorreo(rs.getString(4));
        row.setFecha_nacimiento(rs.getString(4));
        return row;
    }
}
