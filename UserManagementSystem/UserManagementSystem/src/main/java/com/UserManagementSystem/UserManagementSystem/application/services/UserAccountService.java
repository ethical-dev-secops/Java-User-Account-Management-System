package com.UserManagementSystem.UserManagementSystem.application.services;

import com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts.UserAccountCreateDto;
import com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts.UserAccountDto;
import com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts.UserAccountUpdateDto;
import java.util.List;
import java.util.UUID;


public interface UserAccountService {
    UUID CreateUserAccount(UserAccountCreateDto dto);

    UserAccountDto FindUserAccountById(UUID id);

    List<UserAccountDto> FindUserAccounts();

    void UpdateUserAccount(UUID id, UserAccountUpdateDto dto);

    void DeleteUserAccount(UUID id);

}