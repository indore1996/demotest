package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

	@Autowired
	private VehicleRepo vehicleRepo;
	
	@GetMapping("/{pageNo}/{Size}")
	public Page<Vehicle> getAllVehicle(@PathVariable int pageNo,@PathVariable int size,@RequestParam(defaultValue="id") String sortBy){
		Pageable p = PageRequest.of(pageNo,size,Sort.by(sortBy));
		
		return vehicleRepo.findAll(p);
	}
	
	@PostMapping
	public Vehicle createvehicle(@RequestBody Vehicle vehicle) {
		return vehicleRepo.save(vehicle);
	}
	
	@PutMapping("/{id}")
	public Vehicle updatevehicle(@RequestBody Vehicle vehicle,@PathVariable Long id) throws Exception {
		Vehicle ve = vehicleRepo.findById(id).orElseThrow(()-> new Exception("mo"+id));
		
		return vehicleRepo.save(ve);
	}
	
	
	@DeleteMapping("/{id}")
	public void deletevehicle(@PathVariable Long id) {
		vehicleRepo.deleteById(id);
	}
}
