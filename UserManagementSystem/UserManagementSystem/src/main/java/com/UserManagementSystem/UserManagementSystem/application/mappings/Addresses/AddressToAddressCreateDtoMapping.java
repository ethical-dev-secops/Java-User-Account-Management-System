package com.UserManagementSystem.UserManagementSystem.application.mappings.Addresses;

import org.modelmapper.PropertyMap;
import com.UserManagementSystem.UserManagementSystem.application.models.Addresses.AddressCreateDto;
import com.UserManagementSystem.UserManagementSystem.domain.models.Address;

public class AddressToAddressCreateDtoMapping extends PropertyMap<Address, AddressCreateDto> {
    protected void configure() {
    }
}