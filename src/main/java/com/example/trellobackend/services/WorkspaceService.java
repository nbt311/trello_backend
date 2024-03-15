package com.example.trellobackend.services;

import com.example.trellobackend.dto.WorkspaceDTO;
import com.example.trellobackend.models.workspace.Workspace;
import com.example.trellobackend.payload.request.WorkspaceRequest;

import java.util.List;
import java.util.Optional;

public interface WorkspaceService {
    Iterable<Workspace> findAll();
    Optional<Workspace> findById(Long id);
    Workspace save(Workspace workspace);
    void delete(Long id);
    WorkspaceDTO createWorkspace(WorkspaceRequest workspaceRequest, String frontendURL);
    String inviteUserToWorkspace(String email, Workspace workspace);
    Workspace getWorkspaceById(long workspaceId);
    List<WorkspaceDTO> getAllWorkspaceByUser(Long userId);
}
