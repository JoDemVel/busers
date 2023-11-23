package com.jdve.busers.services.implement;

import com.jdve.busers.dto.RolPermissionDTO;
import com.jdve.busers.exceptions.EntityNotFoundException;
import com.jdve.busers.exceptions.InvalidArgumentException;
import com.jdve.busers.exceptions.InvalidIdException;
import com.jdve.busers.repositories.RolPermissionRepository;
import com.jdve.busers.services.RolPermissionService;
import com.jdve.busers.services.mapper.RolPermissionMapper;
import com.jdve.busers.utils.ErrorMessages;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolPermissionServiceImpl implements RolPermissionService {
    private final RolPermissionRepository repository;
    private final RolPermissionMapper mapper;

    public RolPermissionServiceImpl(RolPermissionRepository repository, RolPermissionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<RolPermissionDTO> getRolPermissionsByRolId(Integer rolId) {
        return repository.findAllByRol_Id(rolId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RolPermissionDTO getRolPermissionById(Integer id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(String.format(ErrorMessages.ROL_PERMISSION_NOT_FOUND, id));
        }

        return repository.findById(id).map(mapper::toDto).get();
    }

    @Override
    public List<RolPermissionDTO> getAllRolPermission() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RolPermissionDTO save(RolPermissionDTO rolPermissionDTO) {
        if (rolPermissionDTO.getId() != null) {
            throw new InvalidArgumentException(String.format(ErrorMessages.INVALID_ARGUMENT));
        }
        rolPermissionDTO.setCreatedAt(LocalDateTime.now());

        return mapper
                .toDto(repository.save(mapper.toEntity(rolPermissionDTO)));
    }

    @Override
    public RolPermissionDTO edit(Integer id, RolPermissionDTO rolPermissionDTO) {
        if (rolPermissionDTO.getId() != null && rolPermissionDTO.getId() != id) {
            throw new InvalidIdException(String.format(ErrorMessages.INVALID_ID));
        }

        if (rolPermissionDTO.getId() == null) {
            rolPermissionDTO.setId(id);
        }

        return mapper
                .toDto(repository.save(mapper.toEntity(rolPermissionDTO)));
    }

    @Override
    public RolPermissionDTO delete(Integer id) {
        final RolPermissionDTO toDelete = getRolPermissionById(id);
        repository.deleteById(id);

        return toDelete;
    }
}
