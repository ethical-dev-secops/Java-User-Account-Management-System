package com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.UserManagementSystem.UserManagementSystem.domain.models.UserAccount;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAccountDto {
    private UUID Id;

    public static UserAccountDto mapFromUserAccount(UserAccount userAccount, ModelMapper mapper) {
        return mapper.map(userAccount, UserAccountDto.class);
    }

    public static List<UserAccountDto> mapFromUserAccounts(Collection<UserAccount> userAccounts, ModelMapper mapper) {
        return userAccounts
            .stream()
            .map(userAccount -> UserAccountDto.mapFromUserAccount(userAccount, mapper))
            .collect(Collectors.toList());
    }
}