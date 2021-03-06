package com.hotelMS.controller;

import com.hotelMS.domain.Access;
import com.hotelMS.domain.Role;
import com.hotelMS.domain.User;
import com.hotelMS.dto.user.CompanyDto;
import com.hotelMS.dto.user.CreateUserDto;
import com.hotelMS.dto.user.UserLoginDto;
import com.hotelMS.repository.RoleRepository;
import com.hotelMS.repository.UserRepository;
import com.hotelMS.service.impl.AuthServiceImpl;
import com.hotelMS.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

@RestController



public class UserController {

    @Autowired
    private UserServiceImpl userDetailsService;

    @Autowired
    private AuthServiceImpl authService;

    @Resource
    RoleRepository roleRepository;

    @Resource
    UserRepository userRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody CreateUserDto createUserDto) throws Exception {
        return userDetailsService.save(createUserDto);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDto userLoginDto) throws Exception {
        return authService.authenticateUser(userLoginDto);
    }

    @RequestMapping(value = "/password_reset", method = RequestMethod.POST)
    public ResponseEntity<?> resetUserPassword(@RequestBody User user) throws Exception {
        return authService.resetUserPassword(user);
    }

    @RequestMapping(value = "/activate_account", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('USER_ACTIVATION')")
    public ResponseEntity<?> validate(@RequestBody User user) throws Exception {
        return authService.activateUser(user);
    }

    @RequestMapping(value="/getUserDetails", method = RequestMethod.POST)
    public Object getDetails(@RequestBody CompanyDto companyDto) throws Exception {
        return userDetailsService.getAllUser(companyDto);
    }

    @RequestMapping(value = "get_roles/{id}", method = RequestMethod.GET)
    public Role getProfile(@PathVariable Integer id) {
        return roleRepository.findAllByAccessId(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User findById(@PathVariable String id) throws EntityNotFoundException {
        return userRepository.findById(Integer.valueOf(id)).get();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<User> findAll(final Pageable pageable) throws EntityNotFoundException {
        return userRepository.findAll(pageable);
    }
}