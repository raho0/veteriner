package com.ozguryazilim.veteriner.Controller;

import com.ozguryazilim.veteriner.Dto.OwnerDto;
import com.ozguryazilim.veteriner.Entity.CustomUserDetail;
import com.ozguryazilim.veteriner.Entity.OwnerEntity;
import com.ozguryazilim.veteriner.Service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    //get current user's entity
    @Secured({"ROLE_admin", "ROLE_user"})
    @GetMapping("/get")
    public ResponseEntity<List<OwnerDto>> getOwnerById(@AuthenticationPrincipal CustomUserDetail user) {
        return ownerService.getOwnerById(user.getId());
    }

    //get owner entity by name
    @Secured("ROLE_admin")
    @GetMapping("/getBy")
    public ResponseEntity<OwnerEntity> getOwnerByName(@RequestParam String name) {
        return ownerService.getOwnerByName(name);
    }

    //get all owners
    @Secured("ROLE_admin")
    @GetMapping("/getAll")
    public ResponseEntity<List<OwnerEntity>> getOwners() {
        return ownerService.getOwners();
    }

}
