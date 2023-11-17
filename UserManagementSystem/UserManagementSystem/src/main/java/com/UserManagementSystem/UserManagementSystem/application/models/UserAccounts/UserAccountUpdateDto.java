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
public class UserAccountUpdateDto {
    private UUID Id;

    public static UserAccountUpdateDto mapFromUserAccount(UserAccount userAccount, ModelMapper mapper) {
        return mapper.map(userAccount, UserAccountUpdateDto.class);
    }

    public static List<UserAccountUpdateDto> mapFromUserAccounts(Collection<UserAccount> userAccounts, ModelMapper mapper) {
        return userAccounts
            .stream()
            .map(userAccount -> UserAccountUpdateDto.mapFromUserAccount(userAccount, mapper))
            .collect(Collectors.toList());
    }
}