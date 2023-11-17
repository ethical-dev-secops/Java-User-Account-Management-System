package com.UserManagementSystem.UserManagementSystem.domain.models;

import lombok.NoArgsConstructor;
import com.UserManagementSystem.UserManagementSystem.intent.IntentManageClass;
import com.UserManagementSystem.UserManagementSystem.intent.Mode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_accounts")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@IntentManageClass(privateMethods = Mode.Ignore)
public class UserAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", nullable = false)
    private UUID id;

    public boolean isNew() {
        return this.id == null;
    }
}
