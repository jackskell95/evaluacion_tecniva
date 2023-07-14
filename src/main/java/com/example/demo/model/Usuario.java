package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Usuario {

    private int id = 0;
    private String nombre = "";
    private String apellidos = "";
    private String correo = "";
    private String fecha_nacimiento = "";

}



