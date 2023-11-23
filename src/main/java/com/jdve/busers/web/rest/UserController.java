package com.jdve.busers.web.rest;

import com.jdve.busers.dto.UserCreateDTO;
import com.jdve.busers.dto.UserDTO;
import com.jdve.busers.services.UserService;
import com.jdve.busers.utils.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Path.USER)
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(@RequestParam(required = false, defaultValue = "false") boolean detailed) {
        if (detailed) {
            return ResponseEntity.ok().body(userService.listUsersDetailed());
        }

        return ResponseEntity
                .ok()
                .body(userService.listUsers());
    }

    @GetMapping(Path.ID)
    public ResponseEntity<UserDTO> getUser(@PathVariable final Long id) {
        return ResponseEntity
                .ok()
                .body(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody final UserCreateDTO userCreateDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.save(userCreateDTO));
    }

    @PutMapping(Path.ID)
    public ResponseEntity<UserDTO> editUser(@PathVariable final Long id,
                                            @RequestBody final UserCreateDTO userCreateDTO) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(userService.edit(id, userCreateDTO));
    }

    @DeleteMapping(Path.ID)
    public ResponseEntity<UserDTO> deleteUser(@PathVariable final Long id) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(userService.delete(id));
    }
}
