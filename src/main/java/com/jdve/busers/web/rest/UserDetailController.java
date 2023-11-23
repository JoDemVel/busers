package com.jdve.busers.web.rest;

import com.jdve.busers.dto.UserDetailDTO;
import com.jdve.busers.services.UserDetailService;
import com.jdve.busers.utils.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Path.USER_DETAIL)
public class UserDetailController {
    private final UserDetailService userDetailService;

    @GetMapping
    public ResponseEntity<List<UserDetailDTO>> getAllUserDetails(){
        return ResponseEntity
                .ok()
                .body(userDetailService.listUserDetails());
    }

    @GetMapping(Path.ID)
    public ResponseEntity<UserDetailDTO> getUserDetailById(@PathVariable final Long id) {
        return ResponseEntity
                .ok()
                .body(userDetailService.getUserDetailById(id));
    }

    @PostMapping
    public ResponseEntity<UserDetailDTO> saveUserDetail(@RequestBody final UserDetailDTO userDetailDTO) {
        return ResponseEntity
                .ok()
                .body(userDetailService.save(userDetailDTO));
    }

    @PutMapping(Path.ID)
    public ResponseEntity<UserDetailDTO> editUserDetail(@PathVariable final Long id,
                                                        @RequestBody final UserDetailDTO userDetailDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userDetailService.edit(id, userDetailDTO));
    }

    @DeleteMapping(Path.ID)
    public ResponseEntity<UserDetailDTO> deleteUserDetail(@PathVariable final Long id) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(userDetailService.delete(id));
    }
}
