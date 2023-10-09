package com.example.app.service;

import com.example.app.entity.FormInfo;
import org.springframework.stereotype.Service;




@Service

public class FormInfoService {
/**
 *
 */
public FormInfo formInfo=new FormInfo();

    public FormInfo agregar(FormInfo fi){
        formInfo.setNombre(fi.getNombre());
        formInfo.setApellidos(fi.getApellidos());
        formInfo.setEdad(fi.getEdad());
        return formInfo;
    }



}