package com.example.demo.mapper;

import com.example.demo.dto.AddressDTO;
import com.example.demo.model.AddressBO;
import com.example.demo.model.PersonBO;

public abstract class AddressMapper {
    public static AddressBO map(AddressDTO addressDTO, PersonBO personBO) {
        return AddressBO.createNew(
                addressDTO.getAddressNo(),
                personBO,addressDTO.getCountry(),
                addressDTO.getCity(),
                addressDTO.getStreet(),
                addressDTO.getStreetNumber()
        );
    }

    public static AddressDTO map(AddressBO addressBO) {
        return new AddressDTO(
                addressBO.getId(),
                addressBO.getPerson().getSSN(),
                addressBO.getCountry(),
                addressBO.getCity(),
                addressBO.getStreet(),
                addressBO.getStreetNumber()
        );
    }
}
