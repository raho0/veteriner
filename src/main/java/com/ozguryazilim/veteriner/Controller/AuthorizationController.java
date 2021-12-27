package com.ozguryazilim.veteriner.Controller;

import com.ozguryazilim.veteriner.Config.JwtUtil;
import com.ozguryazilim.veteriner.Entity.OwnerEntity;
import com.ozguryazilim.veteriner.Request.AuthorizationRequest;
import com.ozguryazilim.veteriner.Service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class AuthorizationController {

    private final OwnerService ownerService;
    private final JwtUtil jwtUtil;

    @PostMapping("/auth")
    private ResponseEntity<?> authentication(@RequestBody AuthorizationRequest request) {
        OwnerEntity owner = ownerService.findByNameAndPassword(request.getName(), request.getPassword());
        String token = jwtUtil.generateToken(owner);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> addUser(@RequestBody OwnerEntity owner) {
        return ownerService.addOwner(owner);
    }

}
