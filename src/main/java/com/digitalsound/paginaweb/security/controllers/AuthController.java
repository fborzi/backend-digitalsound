package com.digitalsound.paginaweb.security.controllers;

import com.digitalsound.paginaweb.dto.Message;
import com.digitalsound.paginaweb.security.dto.JwtDto;
import com.digitalsound.paginaweb.security.dto.NewUser;
import com.digitalsound.paginaweb.security.dto.UserLogin;
import com.digitalsound.paginaweb.security.enums.RoleName;
import com.digitalsound.paginaweb.security.jwt.JwtProvider;
import com.digitalsound.paginaweb.security.models.AppUser;
import com.digitalsound.paginaweb.security.models.Role;
import com.digitalsound.paginaweb.security.services.RoleService;
import com.digitalsound.paginaweb.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@ResponseStatus
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    JwtProvider jwtProvider;

    @GetMapping("/all")
    public ResponseEntity<List<AppUser>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @PostMapping("/new")
    public ResponseEntity<?> newUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Message("Campos incorrectos."), HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByUsername(newUser.getUsername())){
            return new ResponseEntity(new Message("El usuario ya existe."), HttpStatus.BAD_REQUEST);
        }

        AppUser user = new AppUser(
                newUser.getUsername(),
                newUser.getName(),
                newUser.getLastName(),
//                newUser.getEmail(),
                passwordEncoder.encode(newUser.getPassword()),
                newUser.getBusiness(),
                newUser.getDni());
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByName(RoleName.ROLE_USER).get());
        if(newUser.getUserRoles().contains("ADMIN")){
            roles.add(roleService.findByName(RoleName.ROLE_ADMIN).get());
        }
        user.setUserRoles(roles);
        userService.save(user);
        return new ResponseEntity(new Message("Usuario creado correctamente."), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody UserLogin userlogin, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Campos incorrectos."), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userlogin.getUsername(), userlogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        //UserDetails userdetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt);
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }

}
