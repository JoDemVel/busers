package com.jdve.busers.services.implement;

import com.jdve.busers.dto.PermissionDTO;
import com.jdve.busers.exceptions.EntityNotFoundException;
import com.jdve.busers.exceptions.InvalidArgumentException;
import com.jdve.busers.exceptions.InvalidIdException;
import com.jdve.busers.repositories.PermissionRepository;
import com.jdve.busers.services.PermissionService;
import com.jdve.busers.services.mapper.PermissionMapper;
import com.jdve.busers.utils.ErrorMessages;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository repository;
    private final PermissionMapper mapper;

    public PermissionServiceImpl(PermissionRepository permissionRepository, PermissionMapper permissionMapper) {
        this.repository = permissionRepository;
        this.mapper = permissionMapper;
    }

    @Override
    public List<PermissionDTO> listPermissions() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PermissionDTO getPermissionById(Integer id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(String.format(ErrorMessages.PERMISSION_NOT_FOUND, id));
        }

        return repository.findById(id).map(mapper::toDto).get();
    }

    @Override
    public PermissionDTO save(PermissionDTO permissionDTO) {
        if (permissionDTO.getId() != null) {
            throw new InvalidArgumentException(String.format(ErrorMessages.INVALID_ARGUMENT));
        }
        permissionDTO.setCreatedAt(LocalDateTime.now());

        return mapper
                .toDto(repository.save(mapper.toEntity(permissionDTO)));
    }

    @Override
    public PermissionDTO edit(Integer id, PermissionDTO permissionDTO) {
        if (permissionDTO.getId() != null && permissionDTO.getId() != id) {
            throw new InvalidIdException(String.format(ErrorMessages.INVALID_ID));
        }

        if (permissionDTO.getId() == null) {
            permissionDTO.setId(id);
        }

        return mapper
                .toDto(repository.save(mapper.toEntity(permissionDTO)));
    }

    @Override
    public PermissionDTO delete(Integer id) {
        final PermissionDTO toDelete = getPermissionById(id);
        repository.deleteById(id);

        return toDelete;
    }
}
