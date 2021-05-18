package tn.Dari.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.Dari.spring.repository.*;
import tn.Dari.spring.service.*;
import tn.Dari.spring.SecurityConfiguration.*;
import tn.Dari.spring.entity.Reclamation;
import tn.Dari.spring.entity.Role;
import tn.Dari.spring.entity.Roles;
import tn.Dari.spring.entity.Tokens;
import tn.Dari.spring.entity.User;
import tn.Dari.spring.payload.JwtResponse;
import tn.Dari.spring.payload.LoginRequest;
import tn.Dari.spring.payload.MessageResponse;
import tn.Dari.spring.payload.SignUpRequest;
import tn.Dari.spring.repository.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	IUserService iUserService;

	@Autowired
	UserServiceImpl userServiceImpl;
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	TokenReopsitory tokenReopsitory;
	@Autowired
	BlacklistTokenRepository blackListtokenReopsitory;

   @Autowired
   IReclamationRepository iReclamationRepository;

	
   @PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
try{
		User u=userRepository.findByName(loginRequest.getUsername()).orElse(null);
		if(u.isDesactivate()){
			return ResponseEntity.badRequest().body(new MessageResponse("Error: This account is desactivate"));
		}
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		User user=userRepository.findById(userDetails.getId()).get();
		user.setCounterLogin(0);
		user.setLastLoginDate(new Date());
		user.setConnected(true);
		userRepository.save(user);
		Tokens t = new Tokens();
		t.setName(jwt);
		t.setUserId(user.getUserId());
		tokenReopsitory.save(t);
		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
}catch (Exception e) {
	User user=userRepository.findByName(loginRequest.getUsername()).orElse(null);
	if(user!=null){
		int compt=user.getCounterLogin();
		if(compt<2){
		user.setCounterLogin(++compt);
		userRepository.save(user);
		return ResponseEntity.badRequest().body(new MessageResponse( "Error: "+ compt+" tentative(s),you have three, please try again"));
		}
		else{
			user.setDesactivate(true);
			userRepository.save(user);
			return ResponseEntity.badRequest().body(new MessageResponse("Error:  please contact our admin  "));
		}
		
	}
	
	return ResponseEntity.badRequest().body(new MessageResponse("Error:  try to push a true username and password"));
}	
}


	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
	//	if (userRepository.existsByName(signUpRequest.getName())) {
		//	return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		//}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()), signUpRequest.getAddress(), signUpRequest.getAge(),
				signUpRequest.getCin(), signUpRequest.getNumTel(),signUpRequest.getSex());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Roles> roles = new HashSet<>();

		if (strRoles== null) {
			Roles userRole = roleRepository.findByName(Role.ROLE_CLIENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Roles adminRole = roleRepository.findByName(Role.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				
				default:
					Roles userRole = roleRepository.findByName(Role.ROLE_CLIENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					
				
				
					roles.add(userRole);
				}
			});
		}
		user.setDateCreate(new Date());
		user.setRoles(roles);
		user.setName(signUpRequest.getName());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		user.setCin(signUpRequest.getCin());
		user.setEmail(signUpRequest.getEmail());
		user.setAge(signUpRequest.getAge());
		user.setAddress(signUpRequest.getAddress());
		user.setNumTel(signUpRequest.getNumTel());
		user.setSex(signUpRequest.getSex());
		userRepository.save(user);
		
		

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}


	@PostMapping("/batch-desactivate")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> desactivateUsersBatch() {
		//number  desactivate account
		int index=0;
		List<User> alluser= userRepository.findAll();
		for(User user: alluser){
		if(!userServiceImpl.getRoleById(user.getUserId()).contains("admin") && !user.isDesactivate()){
			Date lastlogin=user.getLastLoginDate();
			if((new Date()).getMonth()- lastlogin.getMonth()>=1 || (new Date()).getYear()- lastlogin.getYear()>=1 ){
				user.setDesactivate(true);	
				user.setConnected(false);
				userRepository.save(user);
				iUserService.setTokenToBlackList(user.getUserId());
				index++;
			}
		}
		}
		return ResponseEntity.ok(new MessageResponse(index+" are desactivate"));
	}
	
	@PostMapping("/desactivate")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> desactivateUsers() {
		//number  desactivate account
		int index=0;
		
		
		List<User> alluser= userRepository.findAll();
		for(User user: alluser){
			int nbr=iReclamationRepository.nombrerec(user);
		if(!userServiceImpl.getRoleById(user.getUserId()).contains("admin") && !user.isDesactivate()){
			
			if( nbr >=3){
				user.setDesactivate(true);	
				user.setConnected(false);
				userRepository.save(user);
				iUserService.setTokenToBlackList(user.getUserId());
				index++;
			}
		}
		}
		return ResponseEntity.ok(new MessageResponse(index+" are desactivate"));
	}

	/*@GetMapping("/search/{name}")
  	@ResponseBody
  	public List<User> searchUser(@PathVariable("name") String name) {
		
		//userRepository.search(name);
  		return userRepository.search(name);

  		}*/
  		
	@PostMapping("/batch-point")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> UpdatePointBatch(Authentication authentication) {
		
		int index=0;
		List<User> alluser= userRepository.findAll();
		for(User user: alluser){
			for(Roles r :user.getRoles())
			{
			
			
			
		if(!user.isDesactivate()){
			if(r.getName().equals(Role.ROLE_CLIENT))
			{
				
			
			Date datecreate=user.getDateCreate();
			Date today=new Date();
			int yearToday=today.getYear();
			if((yearToday+1900)!=user.getLastyearaddpoint()){
			
			if(today.getDate()==datecreate.getDate() && today.getMonth()==datecreate.getMonth() && today.getYear()!=datecreate.getYear() )
			{
				user.setPoint(user.getPoint()+100);
				user.setLastyearaddpoint(yearToday+1900);
				userRepository.save(user);
				index++;
			}
			}
			}
		}
		}
		}
		//add this to log
	//	UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		//SharedLogg.addlog("user", "insert",userDetails);	
		//the first is the table name, the second is the action, the third user connected
		//
		
		
		return ResponseEntity.ok(new MessageResponse("Add 100 points  for " +index+ " customer(s)"));
	}

	
	
	@GetMapping("/get_All_desactivate_Acount")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User>  get_All_desactivate_Acount() {
		
		List<User> userdesactivate=new ArrayList<User>();
		for(User user: userRepository.findAll()){
		if(user.isDesactivate()){
			userdesactivate.add(user);
		}
		}
		return userdesactivate;
	}
	
	@PostMapping("/desactivate_Acount/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public  ResponseEntity<?>  desactivate_Acount(@PathVariable("userId") long userId) {
          
           iUserService .desactivate_Acount(userId);
           iUserService.setTokenToBlackList(userId);
           return ResponseEntity.ok(new MessageResponse("User Account deactivated"));
	}
	
	@PostMapping("/activate_Acount/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public  ResponseEntity<?>  activate_Acount(@PathVariable("userId") long userId) {
          
           iUserService .activate_Acount(userId);
           return ResponseEntity.ok(new MessageResponse("User Account activated"));
	}
	
	@PostMapping(value = "/logout")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')  ")
	@ResponseBody	
		public ResponseEntity<?> logout(Authentication auth) {
			  iUserService.logout(auth);
			return  ResponseEntity.ok("loggedOut");
		}

	@GetMapping("/retrieve-Users-name/{name}")
	@ResponseBody
	public List<User> getAllName(@PathVariable("name")String name) {

		List<User> list = iUserService.findAllByNameLike(name);
		return list;

	}
}
