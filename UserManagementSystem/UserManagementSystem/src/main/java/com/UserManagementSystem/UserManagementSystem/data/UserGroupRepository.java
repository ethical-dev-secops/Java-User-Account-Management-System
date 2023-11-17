package com.UserManagementSystem.UserManagementSystem.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.UserManagementSystem.UserManagementSystem.domain.models.UserGroup;
import com.UserManagementSystem.UserManagementSystem.intent.IntentMerge;
import java.util.UUID;

@IntentMerge
public interface UserGroupRepository extends JpaRepository<UserGroup, UUID> {
}
