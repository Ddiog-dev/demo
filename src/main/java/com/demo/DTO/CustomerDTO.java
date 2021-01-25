package com.demo.DTO;

import org.springframework.stereotype.Component;


public class CustomerDTO {
    private  String name;
    private  String email;

    public CustomerDTO(){};

    public CustomerDTO(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

}
