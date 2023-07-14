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
public class ObtenerUsuarios {

    private int registroInicial = 0;
    private int totalRegistros = 0;
    private int orden = 0;
    

}



