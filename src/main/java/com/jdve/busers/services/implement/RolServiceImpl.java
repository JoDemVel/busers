package com.jdve.busers.services.implement;

import com.jdve.busers.dto.RolDTO;
import com.jdve.busers.dto.RolPermissionDTO;
import com.jdve.busers.exceptions.EntityNotFoundException;
import com.jdve.busers.exceptions.InvalidArgumentException;
import com.jdve.busers.exceptions.InvalidIdException;
import com.jdve.busers.repositories.RolRepository;
import com.jdve.busers.services.RolService;
import com.jdve.busers.services.mapper.RolMapper;
import com.jdve.busers.utils.ErrorMessages;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {
    private final RolRepository repository;
    private final RolMapper mapper;

    public RolServiceImpl(RolRepository repository, RolMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<RolDTO> listRoles() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RolDTO getRolById(Integer id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(String.format(ErrorMessages.ROL_NOT_FOUND, id));
        }

        return repository.findById(id).map(mapper::toDto).get();
    }

    @Override
    public RolDTO save(RolDTO rolDTO) {
        if (rolDTO.getId() != null) {
            throw new InvalidArgumentException(String.format(ErrorMessages.INVALID_ARGUMENT));
        }

        return mapper
                .toDto(repository.save(mapper.toEntity(rolDTO)));
    }

    @Override
    public RolDTO edit(Integer id, RolDTO rolDTO) {
        if (rolDTO.getId() != null && rolDTO.getId() != id) {
            throw new InvalidIdException(String.format(ErrorMessages.INVALID_ID));
        }

        if (rolDTO.getId() == null) {
            rolDTO.setId(id);
        }

        return mapper
                .toDto(repository.save(mapper.toEntity(rolDTO)));
    }

    @Override
    public RolDTO delete(Integer id) {
        final RolDTO toDelete = getRolById(id);
        repository.deleteById(id);

        return toDelete;
    }
}
