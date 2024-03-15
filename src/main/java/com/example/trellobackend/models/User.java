package com.example.trellobackend.models;

import com.example.trellobackend.enums.MemberRole;
import com.example.trellobackend.models.board.BoardMembers;
import com.example.trellobackend.models.workspace.WorkspaceMembers;
import com.example.trellobackend.enums.UserRole;
import com.example.trellobackend.models.board.Board;
import com.example.trellobackend.models.workspace.Workspace;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank
    @Size(max = 120)
    private String password;
    private String fullName;
    private String publicName;
    private String jobTitle;
    private String department;
    private String organization;
    private String location;
    private String localTime;
    private String avatarUrl;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<WorkspaceMembers> workspaceMembers = new HashSet<>();
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<BoardMembers> BoardMembers = new HashSet<>();
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, String avatarUrl) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatarUrl = avatarUrl;
    }
}
