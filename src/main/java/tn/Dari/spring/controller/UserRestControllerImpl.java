package tn.Dari.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.Dari.spring.SecurityConfiguration.JwtUtils;
import tn.Dari.spring.SecurityConfiguration.UserDetailsImpl;
import tn.Dari.spring.entity.Tokens;
import tn.Dari.spring.entity.User;
import tn.Dari.spring.payload.JwtResponse;
import tn.Dari.spring.payload.MessageResponse;
import tn.Dari.spring.repository.TokenReopsitory;
import tn.Dari.spring.repository.UserRepository;
import tn.Dari.spring.service.IUserService;



@RestController
public class UserRestControllerImpl {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	IUserService iUserService;
	@Autowired
	TokenReopsitory tokenReopsitory;
	@Autowired
	UserRepository userRepository;
	@Autowired
	JwtUtils jwtUtils;

	@GetMapping("/getAllUsers")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody
	public List<User> getAllUsers() {

		return iUserService.getAllUsers();
	}

	@GetMapping("/getMyInfo")
	@PreAuthorize("hasRole('ADMIN')or hasRole('CLIENT')")
	@ResponseBody
	public User getMyInfo(Authentication auth) {

		return iUserService.getMyInfo(auth);
	}
	
	
	
	
	@DeleteMapping("/deleteUserById/{iduser}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody
	public String deleteUserById(@PathVariable("iduser") long userId) {
		
		
		 iUserService.setTokenToBlackList(userId);
		return iUserService.deleteUserById(userId);

	}

	@PutMapping(value = "/updateUser")
	@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN')")
	@ResponseBody
	public ResponseEntity<?> updateUser(@RequestBody User u, Authentication auth) {
		User u1 = userRepository.findByName(auth.getName()).get();
		if (!u.getName().equals(u1.getName())) {
			if (userRepository.existsByName(u.getName())) {
				return ResponseEntity.badRequest().body(
						new MessageResponse("Error: Username is already taken!" + u1.getName() + "" + u1.getEmail()));
			}
		}

		if (!u.getEmail().equals(u1.getEmail())) {
			if (userRepository.existsByEmail(u.getEmail())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
			}
		}
		System.out.println(u.getPassword());
		User user = iUserService.updateUser(u, auth);

		System.out.println(user.getPassword());
		System.out.println(user.getName());
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), u.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		 iUserService.setTokenToBlackList(user.getUserId());
			Tokens t = new Tokens();
			t.setName(jwt);
			t.setUserId(user.getUserId());
			tokenReopsitory.save(t);
		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	
	
	}
	@GetMapping(value = "/getRoleById/{iduser}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody	
		public List<String> getRoleById(@PathVariable("iduser") long userId) {
			
			
			 return iUserService.getRoleById(userId);

		}
	@GetMapping(value = "/getConnctedUsers")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody	
		public List<User> getConnctedUsers() {
			 return iUserService.getListConnectedUser();

		}
	
	@GetMapping(value = "/getNewUserByNbDays/{nbDays}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody	
		public List<User> getNewUserByNbDays(@PathVariable("nbDays") int nbDays) {
			 return iUserService.getNewUserByNbDays(nbDays);

		}

	@DeleteMapping(value = "/deleteRole/{userId}")

	@ResponseBody	
		public int deleteRole(@PathVariable("userId") int userId) {
			  iUserService.deleteRole(userId);
			  return 1;
		}

	


}
