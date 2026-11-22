package com.pcte.transport.controller;

import com.pcte.transport.entity.Route;
import com.pcte.transport.entity.Stop;
import com.pcte.transport.repo.RouteRepo;
import com.pcte.transport.repo.StopRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/routes/{routeId}/stops")
@CrossOrigin(origins = {
"http://127.0.0.1:5500",
"http://localhost:5500",
"http://localhost:3000",
"http://localhost:5173"
}, allowCredentials = "true")
public class StopController {


private final RouteRepo routeRepo;
private final StopRepo stopRepo;

public StopController(RouteRepo routeRepo, StopRepo stopRepo) {
    this.routeRepo = routeRepo;
    this.stopRepo = stopRepo;
}

@GetMapping
public List<Stop> list(@PathVariable Long routeId) {
    return stopRepo.findByRouteIdOrderByOrderIndexAsc(routeId);
}

@PostMapping
public ResponseEntity<Stop> create(@PathVariable Long routeId, @RequestBody Stop s) {
    Route r = routeRepo.findById(routeId).orElseThrow();
    s.setId(null);
    s.setRoute(r);
    return ResponseEntity.ok(stopRepo.save(s));
}

@PutMapping("/{stopId}")
public ResponseEntity<Stop> update(@PathVariable Long routeId, @PathVariable Long stopId, @RequestBody Stop s) {
    Stop db = stopRepo.findById(stopId).orElseThrow();
    if (!db.getRoute().getId().equals(routeId)) return ResponseEntity.notFound().build();
    db.setName(s.getName());
    db.setArrival(s.getArrival());
    db.setDeparture(s.getDeparture());
    db.setLat(s.getLat());
    db.setLng(s.getLng());
    db.setOrderIndex(s.getOrderIndex());
    return ResponseEntity.ok(stopRepo.save(db));
}

@DeleteMapping("/{stopId}")
public ResponseEntity<Void> deleteOne(@PathVariable Long routeId, @PathVariable Long stopId) {
    Stop db = stopRepo.findById(stopId).orElse(null);
    if (db == null || !db.getRoute().getId().equals(routeId)) return ResponseEntity.notFound().build();
    stopRepo.deleteById(stopId);
    return ResponseEntity.noContent().build();
}

@DeleteMapping
public ResponseEntity<Void> deleteAll(@PathVariable Long routeId) {
    stopRepo.deleteByRouteId(routeId);
    return ResponseEntity.noContent().build();
}
}