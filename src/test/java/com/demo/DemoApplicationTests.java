package com.demo;

import com.demo.DTO.CustomerDTO;
import com.demo.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private CustomerService customerService;

    @Before
    public void init(){

        CustomerDTO customerDTO = new CustomerDTO("init","init");
        customerService.save(customerDTO);
        customerService.deleteByName("init");
    }

    @Test
    public void testDelete() {
        customerService.save(new CustomerDTO("delete1","delete1"));
        customerService.deleteByName("delete1");
        CustomerDTO customerDTO = customerService.findByName("delete1");
        assert(customerDTO.getName().equals(""));
    }

    @Test
    public void testSaveAndFindByName(){
        customerService.save(new CustomerDTO("save1","save1"));
        CustomerDTO customerDTOReturn = customerService.findByName("save1");
        // Verify that a new entry is made in DB and that we can have it back
        assert(customerDTOReturn.getName().equals("save1"));

        customerService.deleteByName("save1");
    }

    @Test
    public void testAll(){
        customerService.save(new CustomerDTO("all1","all1"));
        customerService.save(new CustomerDTO("all2","all2"));

        List<CustomerDTO> customers = customerService.findAll();
        assert(customers.size() == 2);
        assert(customers.get(0).getName().equals("all1"));
        assert(customers.get(1).getName().equals("all2"));
    }
}
