package com.jdve.busers.services.implement;

import com.jdve.busers.domain.entities.Rol;
import com.jdve.busers.domain.entities.User;
import com.jdve.busers.domain.entities.UserRol;
import com.jdve.busers.domain.entities.UserRolId;
import com.jdve.busers.dto.RolDTO;
import com.jdve.busers.dto.UserRolDTO;
import com.jdve.busers.exceptions.EntityNotFoundException;
import com.jdve.busers.exceptions.InvalidIdException;
import com.jdve.busers.repositories.RolRepository;
import com.jdve.busers.repositories.UserRepository;
import com.jdve.busers.repositories.UserRolRepository;
import com.jdve.busers.services.UserRolService;
import com.jdve.busers.services.mapper.RolMapper;
import com.jdve.busers.services.mapper.UserRolMapper;
import com.jdve.busers.utils.ErrorMessages;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRolServiceImpl implements UserRolService {
    private final UserRolRepository repository;
    private final UserRolMapper mapper;

    public UserRolServiceImpl(UserRolRepository repository, UserRolMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<UserRolDTO> listUserRoles() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserRolDTO> listUsersByRol(Integer rolId) {
        return repository.findByRolId(rolId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserRolDTO getUserRolById(UserRolId id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(String.format(ErrorMessages.USER_ROL_NOT_FOUND, id.getUserId(), id.getRolId()));
        }

        return repository.findById(id).map(mapper::toDto).get();
    }

    @Override
    public UserRolDTO save(UserRolDTO userRolDTO) {
        if (userRolDTO.getRolId() == null || userRolDTO.getUserId() == null) {
            throw new InvalidIdException(String.format(ErrorMessages.INVALID_ID));
        }
        userRolDTO.setCreatedAt(LocalDateTime.now());

        return mapper
                .toDto(repository.save(mapper.toEntity(userRolDTO)));
    }

    @Override
    public UserRolDTO edit(UserRolId userRolId, UserRolDTO userRolDTO){
        final UserRolDTO userRolFromDB = getUserRolById(userRolId);

        userRolDTO.setRolId(userRolFromDB.getRolId());
        userRolDTO.setUserId(userRolFromDB.getUserId());
        userRolDTO.setRolName(userRolFromDB.getRolName());
        userRolDTO.setUsername(userRolFromDB.getUsername());
        userRolDTO.setEmail(userRolFromDB.getEmail());

        return mapper
                .toDto(repository.save(mapper.toEntity(userRolDTO)));
    }

    @Override
    public UserRolDTO delete(UserRolId id) {
        final UserRolDTO toDelete = getUserRolById(id);
        repository.deleteById(id);

        return toDelete;
    }
}
