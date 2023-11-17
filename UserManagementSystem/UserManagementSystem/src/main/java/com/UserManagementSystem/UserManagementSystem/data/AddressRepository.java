package com.UserManagementSystem.UserManagementSystem.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.UserManagementSystem.UserManagementSystem.domain.models.Address;
import com.UserManagementSystem.UserManagementSystem.intent.IntentMerge;
import java.util.UUID;

@IntentMerge
public interface AddressRepository extends JpaRepository<Address, UUID> {
}
