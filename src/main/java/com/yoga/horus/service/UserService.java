package com.yoga.horus.service;

import com.yoga.horus.dto.UserDTO;
import com.yoga.horus.dtoMapper.UserDTOMapper;
import com.yoga.horus.entity.User;
import com.yoga.horus.repository.UsersRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService implements BaseService <UserDTO>{

    private final UsersRepository usersRepository;
    private final UserDTOMapper userDTOMapper;

    public UserService(UsersRepository usersRepository, UserDTOMapper userDTOMapper) {
        this.usersRepository = usersRepository;
        this.userDTOMapper = userDTOMapper;
    }

    @Override
    public List<UserDTO> getAll() {
        return usersRepository.findAll()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getOne(UUID id) {
        return usersRepository.findById(id)
                .map(userDTOMapper)
                .orElseThrow();
    }

    @Override
    public void create(UserDTO object) {
        User user = new User();
        usersRepository.save(user);
    }

    @Override
    public UserDTO update(UUID id, UserDTO object) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }


}
