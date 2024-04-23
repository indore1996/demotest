package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepo vehicleRepo;
	
	@GetMapping("/{pageNo}/{Size}")
	public Page<User> getAllVehicle(@PathVariable int pageNo,@PathVariable int size,@RequestParam(defaultValue="id") String sortBy){
		Pageable p = PageRequest.of(pageNo,size,Sort.by(sortBy));
		
		return vehicleRepo.findAll(p);
	}
	
	@PostMapping
	public User createvehicle(@RequestBody User vehicle) {
		return vehicleRepo.save(vehicle);
	}
	
	@PutMapping("/{id}")
	public User updatevehicle(@RequestBody User vehicle,@PathVariable Long id) throws Exception {
		User ve = vehicleRepo.findById(id).orElseThrow(()-> new Exception("mo"+id));
		
		return vehicleRepo.save(ve);
	}
	
	
	@DeleteMapping("/{id}")
	public void deletevehicle(@PathVariable Long id) {
		vehicleRepo.deleteById(id);
	}
}
