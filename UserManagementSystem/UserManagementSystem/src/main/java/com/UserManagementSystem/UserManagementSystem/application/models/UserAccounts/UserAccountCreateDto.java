package com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.UserManagementSystem.UserManagementSystem.domain.models.UserAccount;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
@Data
public class UserAccountCreateDto {

    public static UserAccountCreateDto mapFromUserAccount(UserAccount userAccount, ModelMapper mapper) {
        return mapper.map(userAccount, UserAccountCreateDto.class);
    }

    public static List<UserAccountCreateDto> mapFromUserAccounts(Collection<UserAccount> userAccounts, ModelMapper mapper) {
        return userAccounts
            .stream()
            .map(userAccount -> UserAccountCreateDto.mapFromUserAccount(userAccount, mapper))
            .collect(Collectors.toList());
    }
}