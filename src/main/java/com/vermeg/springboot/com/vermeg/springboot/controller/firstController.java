package com.vermeg.springboot.com.vermeg.springboot.controller;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class firstController {
    List<String> l=new ArrayList<>();
    String a="aze";

    @RequestMapping(method = RequestMethod.GET,path ="/all")
    public List<String> getAll(){
    l.add(a);
        return l;
    }
    @RequestMapping(method = RequestMethod.POST,path ="/add")
    public void addString(@PathParam(value = "az") String a){
        l.add(a);
    }
}
