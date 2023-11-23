package com.jdve.busers.web.rest;

import com.jdve.busers.dto.RolPermissionDTO;
import com.jdve.busers.services.RolPermissionService;
import com.jdve.busers.utils.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping(Path.ROL)
public class RolPermissionController {
    private final RolPermissionService rolPermissionService;

    @GetMapping(Path.ID + "/permissions")
    public ResponseEntity<List<RolPermissionDTO>> getRolPermissions(@PathVariable final Integer id) {
        return ResponseEntity
                .ok()
                .body(rolPermissionService.getRolPermissionsByRolId(id));
    }

    @GetMapping("/permissions")
    public ResponseEntity<List<RolPermissionDTO>> getAllRolPermissions() {
        return ResponseEntity
                .ok()
                .body(rolPermissionService.getAllRolPermission());
    }

    @GetMapping("/permissions/{rolPermissionId}")
    public ResponseEntity<RolPermissionDTO> getRolPermissionById(@PathVariable final Integer rolPermissionId){
        return ResponseEntity
                .ok()
                .body(rolPermissionService.getRolPermissionById(rolPermissionId));
    }

    @PostMapping("/permissions")
    public ResponseEntity<RolPermissionDTO> saveRolPermission(@RequestBody final RolPermissionDTO rolPermissionDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(rolPermissionService.save(rolPermissionDTO));
    }

    @PutMapping("/permissions/{rolPermissionId}")
    public ResponseEntity<RolPermissionDTO> editRolPermission(@PathVariable final Integer rolPermissionId,
                                                              @RequestBody final RolPermissionDTO rolPermissionDTO) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(rolPermissionService.edit(rolPermissionId, rolPermissionDTO));
    }

    @DeleteMapping("/permissions/{rolPermissionId}")
    public ResponseEntity<RolPermissionDTO> deleteRolPermission(@PathVariable final Integer rolPermissionId) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(rolPermissionService.delete(rolPermissionId));
    }
}
