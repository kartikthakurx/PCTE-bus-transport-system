package com.pcte.transport.repo;

import com.pcte.transport.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RouteRepo extends JpaRepository<Route, Long> {
Optional<Route> findByCode(String code);
}