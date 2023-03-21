package com.security.multi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.security.multi.model.TenantMaster;

public interface TenantRepository extends JpaRepository<TenantMaster, Integer> {

	
}
