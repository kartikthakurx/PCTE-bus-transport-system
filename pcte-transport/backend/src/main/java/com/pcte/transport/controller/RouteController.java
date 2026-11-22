package com.pcte.transport.controller;

import com.pcte.transport.entity.Route;
import com.pcte.transport.repo.RouteRepo;
import com.pcte.transport.repo.StopRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins = {
"http://127.0.0.1:5500",
"http://localhost:5500",
"http://localhost:3000",
"http://localhost:5173"
}, allowCredentials = "true")
@RequiredArgsConstructor
public class RouteController {

    
private final RouteRepo routeRepo;
private final StopRepo stopRepo;

// Routes CRUD

@GetMapping
public List<Route> all() {
    return routeRepo.findAll();
}

@GetMapping("/{id}")
public Route one(@PathVariable Long id) {
    return routeRepo.findById(id).orElseThrow();
}

@PostMapping
public Route createRoute(@RequestBody Route route) {
    route.setId(null);
    return routeRepo.save(route);
}

@PutMapping("/{id}")
public Route update(@PathVariable Long id, @RequestBody Route r) {
    Route cur = routeRepo.findById(id).orElseThrow();
    cur.setCode(r.getCode());
    cur.setName(r.getName());
    cur.setColorHex(r.getColorHex());
    cur.setBusNo(r.getBusNo());
    cur.setGeometryGeoJson(r.getGeometryGeoJson());
    cur.setFromPlace(r.getFromPlace());
    cur.setToPlace(r.getToPlace());
    cur.setArriveAtCollege(r.getArriveAtCollege());
    cur.setDepartAtCollege(r.getDepartAtCollege());
    return routeRepo.save(cur);
}

@DeleteMapping("/{id}")
@Transactional
public void delete(@PathVariable Long id) {
    // Ensure stops are removed with the route
    stopRepo.deleteByRouteId(id);
    routeRepo.deleteById(id);   
}
}