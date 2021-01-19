package com.demo.controllers;

import com.demo.DTO.CustomerDTO;
import com.demo.entities.Customer;
import com.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController // This means that this class is a Controller
@RequestMapping("/server")
public class MainController {

    @Autowired
    private CustomerService customerService;


    @GetMapping(path="/add") // Map ONLY POST Requests
    public CustomerDTO  addNewUser (@RequestParam(value = "name", defaultValue = "Hello") String name,
                                    @RequestParam(value = "name", defaultValue = "World") String email) {
        return customerService.save(new CustomerDTO(name, email));

    }

    @GetMapping(path="/findByName") // Map ONLY POST Requests
    public CustomerDTO  findByName (@RequestParam(value = "name") String name) {
        return customerService.findByName(name);
    }

    @GetMapping(path="/deleteByName") // Map ONLY POST Requests
    public String  deleteByName (@RequestParam(value = "name") String name) {
         customerService.deleteByName(name);
         return "Ok";
    }

    @GetMapping(path="/all")
    public List<CustomerDTO>  getAllUsers() {
        return customerService.findAll();
    }
}
