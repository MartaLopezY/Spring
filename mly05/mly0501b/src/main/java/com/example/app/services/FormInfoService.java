package com.example.app.services;


import com.example.app.entity.FormInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Service

public class FormInfoService {
    /**
     *
     */
    public Set<FormInfo> lista=new HashSet<>();


    public Set<FormInfo> agregar(FormInfo fi){
        FormInfo formInfo=new FormInfo();
        formInfo.setEdad(fi.getEdad());
        formInfo.setNombre(fi.getNombre());
        formInfo.setApellidos(fi.getApellidos());
        lista.add(formInfo);
        return lista;
    }




}