package com.UserManagementSystem.UserManagementSystem.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.UserManagementSystem.UserManagementSystem.application.mappings.Addresses.AddressToAddressCreateDtoMapping;
import com.UserManagementSystem.UserManagementSystem.application.mappings.Addresses.AddressToAddressDtoMapping;
import com.UserManagementSystem.UserManagementSystem.application.mappings.Addresses.AddressToAddressUpdateDtoMapping;
import com.UserManagementSystem.UserManagementSystem.application.mappings.UserAccounts.UserAccountToUserAccountCreateDtoMapping;
import com.UserManagementSystem.UserManagementSystem.application.mappings.UserAccounts.UserAccountToUserAccountDtoMapping;
import com.UserManagementSystem.UserManagementSystem.application.mappings.UserAccounts.UserAccountToUserAccountUpdateDtoMapping;
import com.UserManagementSystem.UserManagementSystem.application.mappings.UserGroups.UserGroupToUserGroupCreateDtoMapping;
import com.UserManagementSystem.UserManagementSystem.application.mappings.UserGroups.UserGroupToUserGroupDtoMapping;
import com.UserManagementSystem.UserManagementSystem.application.mappings.UserGroups.UserGroupToUserGroupUpdateDtoMapping;
import org.modelmapper.convention.MatchingStrategies;

@Configuration
public class ModelMapperBean {
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        InitializeMappings(modelMapper);

        return modelMapper;
    }

    private void InitializeMappings(ModelMapper modelMapper) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.addMappings(new AddressToAddressCreateDtoMapping());
        modelMapper.addMappings(new AddressToAddressDtoMapping());
        modelMapper.addMappings(new AddressToAddressUpdateDtoMapping());
        modelMapper.addMappings(new UserAccountToUserAccountCreateDtoMapping());
        modelMapper.addMappings(new UserAccountToUserAccountDtoMapping());
        modelMapper.addMappings(new UserAccountToUserAccountUpdateDtoMapping());
        modelMapper.addMappings(new UserGroupToUserGroupCreateDtoMapping());
        modelMapper.addMappings(new UserGroupToUserGroupDtoMapping());
        modelMapper.addMappings(new UserGroupToUserGroupUpdateDtoMapping());
    }
}
