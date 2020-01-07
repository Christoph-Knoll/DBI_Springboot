package com.example.demo.api;

import com.example.demo.dto.AddressDTO;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("api/v1/address")
@RestController
public class AddressController {

    private final PersonService personService;

    @Autowired
    public AddressController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @Transactional
    public void addAddress(@NotNull @RequestBody AddressDTO addressDTO){
        personService.addAddress(addressDTO);
    }

    @GetMapping
    @Transactional(readOnly=true)
    @RequestMapping("cities")
    public List<String> getCities(){
        return personService.getCities();
    }
}
