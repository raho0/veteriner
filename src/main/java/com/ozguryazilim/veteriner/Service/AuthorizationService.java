package com.ozguryazilim.veteriner.Service;

import com.ozguryazilim.veteriner.Config.CustomUserDetail;
import com.ozguryazilim.veteriner.Entity.OwnerEntity;
import com.ozguryazilim.veteriner.Repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationService implements UserDetailsService {
    private final OwnerRepository ownerRepository;

    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        OwnerEntity owner = ownerRepository.findByName(username);

        if (owner == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetail(owner);
    }
}
