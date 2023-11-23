package com.jdve.busers.web.rest;

import com.jdve.busers.domain.entities.UserRolId;
import com.jdve.busers.dto.UserRolDTO;
import com.jdve.busers.services.UserRolService;
import com.jdve.busers.utils.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Path.USER_ROL)
public class UserRolController {
    private final UserRolService userRolService;

    @GetMapping
    public ResponseEntity<List<UserRolDTO>> getAllUsersRoles(){
        return ResponseEntity
                .ok()
                .body(userRolService.listUserRoles());
    }

    @GetMapping(Path.ID_USER_ROL)
    public ResponseEntity<UserRolDTO> getUserRolById(@PathVariable final Long userId,
                                                     @PathVariable final Integer rolId) {
        return ResponseEntity
                .ok()
                .body(userRolService.getUserRolById(new UserRolId(userId, rolId)));
    }

    @GetMapping("/{rolId}")
    public ResponseEntity<List<UserRolDTO>> getUsersByRolId(@PathVariable final Integer rolId) {
        return ResponseEntity
                .ok()
                .body(userRolService.listUsersByRol(rolId));
    }

    @PostMapping
    public ResponseEntity<UserRolDTO> saveUserRol(@RequestBody final UserRolDTO userRolDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userRolService.save(userRolDTO));
    }

    @PatchMapping(Path.ID_USER_ROL)
    public ResponseEntity<UserRolDTO> editUserRol(@PathVariable final Long userId,
                                                  @PathVariable final Integer rolId,
                                                  @RequestBody final UserRolDTO userRolDTO) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(userRolService.edit(new UserRolId(userId, rolId), userRolDTO));
    }

    @DeleteMapping(Path.ID_USER_ROL)
    public ResponseEntity<UserRolDTO> deleteUserRol(@PathVariable final Long userId,
                                                    @PathVariable final Integer rolId) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(userRolService.delete(new UserRolId(userId, rolId)));
    }
}
