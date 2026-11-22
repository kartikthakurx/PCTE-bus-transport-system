package com.pcte.transport.repo;

import com.pcte.transport.entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StopRepo extends JpaRepository<Stop, Long> {
List<Stop> findByRouteIdOrderByOrderIndexAsc(Long routeId);
void deleteByRouteId(Long routeId);
}