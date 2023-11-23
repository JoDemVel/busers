package com.jdve.busers.services.implement;

import com.jdve.busers.dto.RolDTO;
import com.jdve.busers.dto.UserDetailDTO;
import com.jdve.busers.exceptions.EntityNotFoundException;
import com.jdve.busers.exceptions.InvalidArgumentException;
import com.jdve.busers.exceptions.InvalidIdException;
import com.jdve.busers.repositories.UserDetailRepository;
import com.jdve.busers.services.UserDetailService;
import com.jdve.busers.services.mapper.UserDetailMapper;
import com.jdve.busers.utils.ErrorMessages;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    private final UserDetailRepository repository;
    private final UserDetailMapper mapper;

    public UserDetailServiceImpl(UserDetailRepository repository, UserDetailMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<UserDetailDTO> listUserDetails() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetailDTO getUserDetailById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(String.format(ErrorMessages.USER_DETAIL_NOT_FOUND, id));
        }

        return repository.findById(id).map(mapper::toDto).get();
    }

    @Override
    public UserDetailDTO save(UserDetailDTO userDetailDTO) {
        if (userDetailDTO.getId() != null || userDetailDTO.getUserId() == null) {
            throw new InvalidArgumentException(String.format(ErrorMessages.INVALID_ARGUMENT));
        }

        return mapper
                .toDto(repository.save(mapper.toEntity(userDetailDTO)));
    }

    @Override
    public UserDetailDTO edit(Long id, UserDetailDTO userDetailDTO) {
        if (userDetailDTO.getId() != null && userDetailDTO.getId() != id || userDetailDTO.getUserId() == null) {
            throw new InvalidIdException(String.format(ErrorMessages.INVALID_ID));
        }

        if (userDetailDTO.getId() == null) {
            userDetailDTO.setId(id);
        }

        return mapper
                .toDto(repository.save(mapper.toEntity(userDetailDTO)));
    }

    @Override
    public UserDetailDTO delete(Long id) {
        final UserDetailDTO toDelete = getUserDetailById(id);
        repository.deleteById(id);

        return toDelete;
    }
}
