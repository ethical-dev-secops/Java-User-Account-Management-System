package com.UserManagementSystem.UserManagementSystem.application.mappings.Addresses;

import org.modelmapper.PropertyMap;
import com.UserManagementSystem.UserManagementSystem.application.models.Addresses.AddressDto;
import com.UserManagementSystem.UserManagementSystem.domain.models.Address;

public class AddressToAddressDtoMapping extends PropertyMap<Address, AddressDto> {
    protected void configure() {
    }
}