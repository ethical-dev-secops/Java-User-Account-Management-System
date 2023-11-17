package com.UserManagementSystem.UserManagementSystem.application.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.stream.Collectors;
import java.util.function.Function;
import com.UserManagementSystem.UserManagementSystem.application.models.UserGroups.UserGroupCreateDto;
import com.UserManagementSystem.UserManagementSystem.application.models.UserGroups.UserGroupDto;
import com.UserManagementSystem.UserManagementSystem.application.models.UserGroups.UserGroupUpdateDto;
import com.UserManagementSystem.UserManagementSystem.application.services.UserGroupService;
import com.UserManagementSystem.UserManagementSystem.data.UserGroupRepository;
import com.UserManagementSystem.UserManagementSystem.domain.models.UserGroup;
import com.UserManagementSystem.UserManagementSystem.intent.IntentIgnoreBody;
import com.UserManagementSystem.UserManagementSystem.intent.IntentMerge;
import java.util.List;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@IntentMerge
public class UserGroupServiceImpl implements UserGroupService {
    private UserGroupRepository userGroupRepository;
    private ModelMapper mapper;

    @Override
    @Transactional(readOnly = false)
    public UUID CreateUserGroup(UserGroupCreateDto dto) {
        var userGroup = new UserGroup();
        userGroup.setGroupName(dto.getGroupName());
        userGroupRepository.save(userGroup);
        return userGroup.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public UserGroupDto FindUserGroupById(UUID id) {
        var userGroup = userGroupRepository.findById(id);
        if (!userGroup.isPresent()) {
            return null;
        }
        return UserGroupDto.mapFromUserGroup(userGroup.get(), mapper);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserGroupDto> FindUserGroups() {
        var userGroups = userGroupRepository.findAll();
        return UserGroupDto.mapFromUserGroups(userGroups, mapper);
    }

    @Override
    @Transactional(readOnly = false)
    public void UpdateUserGroup(UUID id, UserGroupUpdateDto dto) {
        var userGroup = userGroupRepository.findById(id).get();
        userGroup.setGroupName(dto.getGroupName());
        userGroupRepository.save(userGroup);
    }

    @Override
    @Transactional(readOnly = false)
    public void DeleteUserGroup(UUID id) {
        var userGroup = userGroupRepository.findById(id);
        if (!userGroup.isPresent()) {
            return;
        }
        userGroupRepository.delete(userGroup.get());
    }
}
