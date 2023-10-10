package com.example.app.services;


import com.example.app.entity.FormInfo;
import org.springframework.stereotype.Service;


@Service

public class FormInfoService {
    /**
     *
     */

   FormInfo formInfo=new FormInfo();

    public FormInfo agregar(FormInfo fi){
        formInfo.setEdad(fi.getEdad());
        formInfo.setNombre(fi.getNombre());
        formInfo.setApellidos(fi.getApellidos());
        return formInfo;
    }




}