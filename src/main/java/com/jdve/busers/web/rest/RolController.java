package com.jdve.busers.web.rest;

import com.jdve.busers.dto.RolDTO;
import com.jdve.busers.services.RolService;
import com.jdve.busers.utils.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Path.ROL)
public class RolController {
    private final RolService rolService;

    @GetMapping
    public ResponseEntity<List<RolDTO>> getAllRoles() {
        return ResponseEntity.ok().body(rolService.listRoles());
    }

    @GetMapping(Path.ID)
    public ResponseEntity<RolDTO> getRolById(@PathVariable final Integer id) {
        return ResponseEntity.ok().body(rolService.getRolById(id));
    }

    @PostMapping
    public ResponseEntity<RolDTO> saveRole(@RequestBody final RolDTO rolDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(rolService.save(rolDTO));
    }

    @PutMapping(Path.ID)
    public ResponseEntity<RolDTO> editRole(@PathVariable final Integer id,
                                           @RequestBody final RolDTO rolDTO) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(rolService.edit(id, rolDTO));
    }

    @DeleteMapping(Path.ID)
    public ResponseEntity<RolDTO> deleteRole(@PathVariable final Integer id) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(rolService.delete(id));
    }
}
