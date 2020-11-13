package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.jwt.JwtUtils;
import com.example.fourkingmusic.models.*;
import com.example.fourkingmusic.repository.RoleRepository;
import com.example.fourkingmusic.repository.UserRepository;
import com.example.fourkingmusic.request.LoginRequest;
import com.example.fourkingmusic.request.SignupRequest;
import com.example.fourkingmusic.response.JwtResponse;
import com.example.fourkingmusic.response.MessageResponse;
import com.example.fourkingmusic.service.LikesongService;
import com.example.fourkingmusic.service.SongService;
import com.example.fourkingmusic.service.UserService;
import com.example.fourkingmusic.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private SongService songService;

    @Autowired
    private LikesongService likesongService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUser()
                ));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> responseEntity(@Valid @RequestBody SignupRequest signupRequest){
        if (userRepository.existsUsersByUsername(signupRequest.getUsername())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Tài khoản đã tồn tại!"));
        }

        if(userRepository.existsUsersByEmail(signupRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Email đã được sử dụng!"));
        }

        Users users = new Users(signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword()),
                signupRequest.getGender(),
                signupRequest.getAvatarUrl(),
                signupRequest.getName(),
                signupRequest.getHobbies()
                );

        users.setAvatarUrl("https://cdn3.vectorstock.com/i/1000x1000/26/62/runner-avatar-figure-with-mp3-player-music-block-vector-32312662.jpg");

        Set<String> strRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        if(strRoles == null){
            Role userRole = roleRepository.findRoleByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            Role adminRole = roleRepository.findRoleByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);
        }
        users.setRole(roles);
        userRepository.save(users);
        ArrayList<Song> songs = songService.findAll();
        for (Song song : songs){
            Likesong likesong = new Likesong();
            likesong.setUser(users);
            likesong.setSong(song);
            likesong.setStatus(false);
            likesongService.saveLikesong(likesong);
        }
        return ResponseEntity.ok(new MessageResponse("Đăng ký tài khoản thành công!"));
    }
}
