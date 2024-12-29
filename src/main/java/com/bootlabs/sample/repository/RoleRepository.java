package com.bootlabs.sample.repository;

import com.bootlabs.sample.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
