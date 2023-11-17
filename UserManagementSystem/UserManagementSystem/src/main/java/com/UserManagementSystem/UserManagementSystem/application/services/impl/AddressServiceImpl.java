package com.UserManagementSystem.UserManagementSystem.application.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.stream.Collectors;
import java.util.function.Function;
import com.UserManagementSystem.UserManagementSystem.application.models.Addresses.AddressCreateDto;
import com.UserManagementSystem.UserManagementSystem.application.models.Addresses.AddressDto;
import com.UserManagementSystem.UserManagementSystem.application.models.Addresses.AddressUpdateDto;
import com.UserManagementSystem.UserManagementSystem.application.services.AddressService;
import com.UserManagementSystem.UserManagementSystem.data.AddressRepository;
import com.UserManagementSystem.UserManagementSystem.domain.models.Address;
import com.UserManagementSystem.UserManagementSystem.intent.IntentIgnoreBody;
import com.UserManagementSystem.UserManagementSystem.intent.IntentMerge;
import java.util.List;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@IntentMerge
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private ModelMapper mapper;

    @Override
    @Transactional(readOnly = false)
    public UUID CreateAddress(AddressCreateDto dto) {
        var address = new Address();
        address.setUnitnumber(dto.getUnitnumber());
        address.setStreet(dto.getStreet());
        address.setSuburb(dto.getSuburb());
        address.setCity(dto.getCity());
        addressRepository.save(address);
        return address.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public AddressDto FindAddressById(UUID id) {
        var address = addressRepository.findById(id);
        if (!address.isPresent()) {
            return null;
        }
        return AddressDto.mapFromAddress(address.get(), mapper);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressDto> FindAddresses() {
        var addresses = addressRepository.findAll();
        return AddressDto.mapFromAddresses(addresses, mapper);
    }

    @Override
    @Transactional(readOnly = false)
    public void UpdateAddress(UUID id, AddressUpdateDto dto) {
        var address = addressRepository.findById(id).get();
        address.setUnitnumber(dto.getUnitnumber());
        address.setStreet(dto.getStreet());
        address.setSuburb(dto.getSuburb());
        address.setCity(dto.getCity());
        addressRepository.save(address);
    }

    @Override
    @Transactional(readOnly = false)
    public void DeleteAddress(UUID id) {
        var address = addressRepository.findById(id);
        if (!address.isPresent()) {
            return;
        }
        addressRepository.delete(address.get());
    }
}
