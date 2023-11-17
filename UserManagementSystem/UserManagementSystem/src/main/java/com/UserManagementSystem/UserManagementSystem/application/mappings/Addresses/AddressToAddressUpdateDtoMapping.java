package com.UserManagementSystem.UserManagementSystem.application.mappings.Addresses;

import org.modelmapper.PropertyMap;
import com.UserManagementSystem.UserManagementSystem.application.models.Addresses.AddressUpdateDto;
import com.UserManagementSystem.UserManagementSystem.domain.models.Address;

public class AddressToAddressUpdateDtoMapping extends PropertyMap<Address, AddressUpdateDto> {
    protected void configure() {
    }
}