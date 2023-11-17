package com.UserManagementSystem.UserManagementSystem.application.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.stream.Collectors;
import java.util.function.Function;
import com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts.UserAccountCreateDto;
import com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts.UserAccountDto;
import com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts.UserAccountUpdateDto;
import com.UserManagementSystem.UserManagementSystem.application.services.UserAccountService;
import com.UserManagementSystem.UserManagementSystem.data.UserAccountRepository;
import com.UserManagementSystem.UserManagementSystem.domain.models.UserAccount;
import com.UserManagementSystem.UserManagementSystem.intent.IntentIgnoreBody;
import com.UserManagementSystem.UserManagementSystem.intent.IntentMerge;
import java.util.List;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@IntentMerge
public class UserAccountServiceImpl implements UserAccountService {
    private UserAccountRepository userAccountRepository;
    private ModelMapper mapper;

    @Override
    @Transactional(readOnly = false)
    public UUID CreateUserAccount(UserAccountCreateDto dto) {
        var userAccount = new UserAccount();
        userAccountRepository.save(userAccount);
        return userAccount.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public UserAccountDto FindUserAccountById(UUID id) {
        var userAccount = userAccountRepository.findById(id);
        if (!userAccount.isPresent()) {
            return null;
        }
        return UserAccountDto.mapFromUserAccount(userAccount.get(), mapper);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserAccountDto> FindUserAccounts() {
        var userAccounts = userAccountRepository.findAll();
        return UserAccountDto.mapFromUserAccounts(userAccounts, mapper);
    }

    @Override
    @Transactional(readOnly = false)
    public void UpdateUserAccount(UUID id, UserAccountUpdateDto dto) {
        var userAccount = userAccountRepository.findById(id).get();
        userAccountRepository.save(userAccount);
    }

    @Override
    @Transactional(readOnly = false)
    public void DeleteUserAccount(UUID id) {
        var userAccount = userAccountRepository.findById(id);
        if (!userAccount.isPresent()) {
            return;
        }
        userAccountRepository.delete(userAccount.get());
    }
}
