package com.jdve.busers.services.implement;

import com.jdve.busers.domain.entities.User;
import com.jdve.busers.domain.entities.UserDetail;
import com.jdve.busers.dto.UserCreateDTO;
import com.jdve.busers.dto.UserDTO;
import com.jdve.busers.exceptions.EntityNotFoundException;
import com.jdve.busers.exceptions.InvalidArgumentException;
import com.jdve.busers.exceptions.InvalidIdException;
import com.jdve.busers.repositories.UserDetailRepository;
import com.jdve.busers.repositories.UserRepository;
import com.jdve.busers.services.UserService;
import com.jdve.busers.services.mapper.UserCreateMapper;
import com.jdve.busers.services.mapper.UserMapper;
import com.jdve.busers.utils.ErrorMessages;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserDetailRepository userDetailRepository;
    private final UserMapper mapper;
    private final UserCreateMapper mapperUserCreate;

    public UserServiceImpl(UserRepository repository, UserDetailRepository userDetailRepository, UserMapper mapper, UserCreateMapper mapperUserCreate) {
        this.repository = repository;
        this.userDetailRepository = userDetailRepository;
        this.mapper = mapper;
        this.mapperUserCreate = mapperUserCreate;
    }

    @Override
    public List<UserDTO> listUsers() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> listUsersDetailed() {
        return repository.findAll()
                .stream()
                .map(mapper::toDtoDetailed)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(String.format(ErrorMessages.USER_NOT_FOUND, id));
        }

        return repository.findById(id).map(mapper::toDtoDetailed).get();
    }

    @Transactional
    @Override
    public UserDTO save(UserCreateDTO userCreateDTO) {
        if (userCreateDTO.getId() != null) {
            throw new InvalidArgumentException(String.format(ErrorMessages.INVALID_ARGUMENT));
        }

        return upsert(userCreateDTO);
    }

    @Transactional
    @Override
    public UserDTO edit(Long id, UserCreateDTO userCreateDTO) {
        if (userCreateDTO.getId() != null && userCreateDTO.getId() != id) {
            throw new InvalidIdException(String.format(ErrorMessages.INVALID_ID));
        }

        if (userCreateDTO.getId() == null) {
            userCreateDTO.setId(id);
        }

        return upsert(userCreateDTO);
    }

    @Transactional
    public UserDTO upsert(UserCreateDTO userCreateDTO){
        User userFromDB = repository.save(mapperUserCreate.toEntity(userCreateDTO));
        if (userCreateDTO.getLastName() != null) {
            UserDetail userDetailFromDB = userDetailRepository.save(
                    UserDetail.builder()
                            .firstName(userCreateDTO.getFirstName())
                            .lastName(userCreateDTO.getLastName())
                            .age(userCreateDTO.getAge())
                            .birthDay(userCreateDTO.getBirthDate())
                            .user(userFromDB)
                            .build()
            );

            return UserDTO.builder()
                    .id(userFromDB.getId())
                    .username(userFromDB.getUsername())
                    .email(userFromDB.getEmail())
                    .firstName(userDetailFromDB.getFirstName())
                    .lastName(userDetailFromDB.getLastName())
                    .age(userDetailFromDB.getAge())
                    .birthDate(userDetailFromDB.getBirthDay())
                    .build();
        }
        return mapper.toDto(userFromDB);
    }

    @Override
    @Transactional
    public UserDTO delete(Long id) {
        final UserDTO toDelete = getUserById(id);
        repository.deleteById(id);

        return toDelete;
    }
}
