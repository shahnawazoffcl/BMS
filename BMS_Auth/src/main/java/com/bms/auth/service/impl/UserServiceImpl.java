package com.bms.auth.service.impl;

import com.bms.auth.exceptions.UserNotFoundException;
import com.bms.auth.models.Role;
import com.bms.auth.models.User;
import com.bms.auth.repository.RoleRepository;
import com.bms.auth.repository.UserRepository;
import com.bms.auth.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User addUser(User user){
        return this.userRepository.save(user);
    }

    public User getUserByEmailAndPassword(String email, String password){
        return this.userRepository.findByEmailAndPassword(email, password).orElseThrow(()->new UserNotFoundException("No User Found"));
    }

    @Override
    public User getUserById(UUID id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found with id: "+id);
        }

        return userOptional.get();
    }

    @Override
    public User setUserRoles(UUID userId, List<UUID> roleIds){
        Set<Role> roles = roleRepository.findAllByIdIn(roleIds);
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found with id: "+userId);
        }

        User user = userOptional.get();
        user.setRoles(roles);

        return userRepository.save(user);
    }
}
