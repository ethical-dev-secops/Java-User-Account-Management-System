package com.UserManagementSystem.UserManagementSystem.domain.models;

import lombok.NoArgsConstructor;
import com.UserManagementSystem.UserManagementSystem.intent.IntentManageClass;
import com.UserManagementSystem.UserManagementSystem.intent.Mode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@IntentManageClass(privateMethods = Mode.Ignore)
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Size(max = 30)
    @Column(name = "product_name", length = 30, nullable = false)
    private String productName;

    @Column(columnDefinition = "uuid", name = "user_account_id", nullable = false)
    private UUID userAccountId;

    @Setter(AccessLevel.NONE)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id", nullable = false, insertable = false, updatable = false)
    private UserAccount userAccount;

    public boolean isNew() {
        return this.id == null;
    }
}
