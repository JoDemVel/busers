package com.jdve.busers.web.rest;

import com.jdve.busers.dto.PermissionDTO;
import com.jdve.busers.services.PermissionService;
import com.jdve.busers.utils.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Path.PERMISSION)
public class PermissionController {
    private final PermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<PermissionDTO>> getAllPermissions() {
        return ResponseEntity.ok(permissionService.listPermissions());
    }

    @GetMapping(Path.ID)
    public ResponseEntity<PermissionDTO> getPermissionById(@PathVariable final Integer id) {
        return ResponseEntity.ok(permissionService.getPermissionById(id));
    }

    @PostMapping
    public ResponseEntity<PermissionDTO> savePermission(@RequestBody final PermissionDTO permissionDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(permissionService.save(permissionDTO));
    }

    @PutMapping(Path.ID)
    public ResponseEntity<PermissionDTO> editPermission(@PathVariable final Integer id,
                                                        @RequestBody final PermissionDTO permissionDTO) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(permissionService.edit(id, permissionDTO));
    }

    @DeleteMapping(Path.ID)
    public ResponseEntity<PermissionDTO> deletePermission(@PathVariable final Integer id) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(permissionService.delete(id));
    }
}
