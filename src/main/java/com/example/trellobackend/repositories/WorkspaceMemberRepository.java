package com.example.trellobackend.repositories;

import com.example.trellobackend.models.workspace.Workspace;
import com.example.trellobackend.models.workspace.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkspaceMemberRepository extends JpaRepository<Members, Long> {
    List<Members> findByWorkspace(Workspace workspace);
}
