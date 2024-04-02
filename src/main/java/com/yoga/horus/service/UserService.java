package com.yoga.horus.service;

import com.yoga.horus.dto.UserDTO;
import com.yoga.horus.dtoMapper.UserDTOMapper;
import com.yoga.horus.entity.User;
import com.yoga.horus.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements BaseService <User,UserDTO>{

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
                .get();
    }


    public void create(User user) {
        usersRepository.save(user);
    }

    @Override
    public void update(UUID id, User user) {
       if (usersRepository.existsById(id)){
           usersRepository.save(user);
       } else {
           throw new NoSuchElementException();
       }

    }

    @Override
    public void delete(UUID id) {
        if (usersRepository.existsById(id)){
            usersRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }

    }


}
