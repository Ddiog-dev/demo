package com.demo;

import com.demo.DTO.CustomerDTO;
import com.demo.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        customerService.save(new CustomerDTO("name","mail"));
        customerService.deleteByName("name");
        CustomerDTO customerDTO = customerService.findByName("name"); ;
        assert(customerDTO.getName().equals(""));
    }

    @Test
    public void testSaveAndFindByName(){
        customerService.save(new CustomerDTO("name","mail"));
        CustomerDTO customerDTOReturn = customerService.findByName("name");
        // Verify that a new entry is made in DB and that we can have it back
        assert(customerDTOReturn.getName().equals("name"));
    }
}
