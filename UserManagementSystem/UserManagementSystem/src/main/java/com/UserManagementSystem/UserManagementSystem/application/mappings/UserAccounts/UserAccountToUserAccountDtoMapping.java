package com.UserManagementSystem.UserManagementSystem.application.mappings.UserAccounts;

import org.modelmapper.PropertyMap;
import com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts.UserAccountDto;
import com.UserManagementSystem.UserManagementSystem.domain.models.UserAccount;

public class UserAccountToUserAccountDtoMapping extends PropertyMap<UserAccount, UserAccountDto> {
    protected void configure() {
    }
}