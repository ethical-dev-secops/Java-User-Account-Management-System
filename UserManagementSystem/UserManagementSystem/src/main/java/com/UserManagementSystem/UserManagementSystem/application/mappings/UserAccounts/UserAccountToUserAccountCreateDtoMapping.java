package com.UserManagementSystem.UserManagementSystem.application.mappings.UserAccounts;

import org.modelmapper.PropertyMap;
import com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts.UserAccountCreateDto;
import com.UserManagementSystem.UserManagementSystem.domain.models.UserAccount;

public class UserAccountToUserAccountCreateDtoMapping extends PropertyMap<UserAccount, UserAccountCreateDto> {
    protected void configure() {
    }
}