package com.UserManagementSystem.UserManagementSystem.application.mappings.UserAccounts;

import org.modelmapper.PropertyMap;
import com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts.UserAccountUpdateDto;
import com.UserManagementSystem.UserManagementSystem.domain.models.UserAccount;

public class UserAccountToUserAccountUpdateDtoMapping extends PropertyMap<UserAccount, UserAccountUpdateDto> {
    protected void configure() {
    }
}