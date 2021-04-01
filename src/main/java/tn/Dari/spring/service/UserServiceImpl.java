package tn.Dari.spring.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import tn.Dari.spring.entity.BlacklistToken;
import tn.Dari.spring.entity.Role;
import tn.Dari.spring.entity.Roles;
import tn.Dari.spring.entity.Tokens;
import tn.Dari.spring.entity.User;
import tn.Dari.spring.payload.SignUpRequest;
import tn.Dari.spring.repository.BlacklistTokenRepository;
import tn.Dari.spring.repository.LoggRepository;
import tn.Dari.spring.repository.TokenReopsitory;
import tn.Dari.spring.repository.UserRepository;



@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	TokenReopsitory tokenReopsitory;
	@Autowired
	BlacklistTokenRepository blacklistTokenRepo;
	
	@Autowired
	LoggRepository loggRepository;

	@Override
	public User getUserById(long userId) {

		return userRepository.findById(userId).get();
	}

	@Override
	public List<User> getAllUsers() {

		return (List<User>) userRepository.findAll();
	}


	@Override
	public String deleteUserById(long userId) {
		User u = userRepository.findById(userId).get();
		

		if(this.getRoleById(u.getUserId()).contains("admin"))
				{
			return "this user is an admin";
				}
		
   	this.setTokenToBlackList(userId);
	  
		
	 this.deleteRole(userId);
		userRepository.delete(u);
		return "deleted";
	}
	@Override
	public void deleteRole(long userId) {
	 userRepository.deleteRole(userId);
	}
	

	@Override
	public User updateUser(User u, Authentication auth) {
		User u1 = userRepository.findByName(auth.getName()).get();
		if (!u.getAddress().equals(""))
			u1.setAddress(u.getAddress());
		if (u.getAge() != 0)
			u1.setAge(u.getAge());
		if (!u.getEmail().equals(""))
			u1.setEmail(u.getEmail());
		if (!u.getName().equals(""))
			u1.setName(u.getName());
		if (!u.getNumTel().equals(""))
			u1.setNumTel(u.getNumTel());
		if (!u.getSex().equals(""))
			u1.setSex(u.getSex());
		if (!(u.getPassword() == null))
			u1.setPassword(encoder.encode(u.getPassword()));

		userRepository.save(u1);
		return u1;

	}

	@Override
	public User getMyInfo(Authentication auth) {
		User u = new User();
		u = userRepository.findByName(auth.getName()).get();
		return u;
	}

	@Override
	public void desactivate_Acount(long userId) {
		User user = userRepository.findById(userId).get();
		user.setConnected(false);
		user.setDesactivate(true);
		userRepository.save(user);
	}

	@Override
	public void activate_Acount(long userId) {
		User user = userRepository.findById(userId).get();
		user.setDesactivate(false);
		userRepository.save(user);
	}

	@Override
	public void setTokenToBlackList(long userId) {
		List<String> tokens = new ArrayList<String>();

		tokens = tokenReopsitory.getTokenByUser(userId);

		for (String t : tokens) {
			BlacklistToken b = new BlacklistToken();
			b.setToken(t);
			blacklistTokenRepo.save(b);
			Tokens tok = tokenReopsitory.findByName(t);
			tokenReopsitory.delete(tok);
		}
	}

	@Override
	public List<String> getRoleById(long userId) {
		User user = userRepository.findById(userId).get();
		List<String> l = new ArrayList<String>();
		for (Roles r : user.getRoles()) {
			if (r.getName().equals(Role.ROLE_CLIENT)) {
				l.add("client");
			}
			if (r.getName().equals(Role.ROLE_ADMIN)) {
				l.add("admin");
			}
			
		}

		
		return l;
	}

	@Override
	public List<User> getListConnectedUser() {
		List<User> users = new ArrayList<User>();
		users = userRepository.findAll();
		List<User> Connectedusers = new ArrayList<User>();
		for(User u: users )
		{System.out.println(u.isConnected());
			if(u.isConnected()==true && this.getRoleById(u.getUserId()).contains("client"))
			{	
				Connectedusers.add(u);
			}
		}
		return Connectedusers;
	}
	
	
	
	
	@Override
	public void logout(Authentication auth) {
		User u = userRepository.findByName(auth.getName()).get();
		u.setConnected(false);
		userRepository.save(u);
	}
	
	@Override
	public List<User> getNewUserByNbDays(int nbDays) {
		List<User> users = new ArrayList<User>();
		users = userRepository.findAll();
		List<User> newusers = new ArrayList<User>();
		Date d = new Date(System.currentTimeMillis());
		Date date1 = new Date(d.getTime() - (nbDays * 86400000));
		for(User u: users )
		{
			
			
			if(u.getDateCreate().compareTo(date1)>0 && this.getRoleById(u.getUserId()).contains("client"))
			{
				System.out.println(date1);
				System.out.println(u.getDateCreate());
				newusers.add(u);
			}
		}
		return newusers;
	}

	

	@Override
	public User save(SignUpRequest signUpRequest) {
		// TODO Auto-generated method stub
		return null;
	}

/*	@Override
	public String deleteUserById(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(SignUpRequest signUpRequest) {
		// TODO Auto-generated method stub
		return null;
	} */
	@Override
	public List<User> findAllByNameLike(String name) {
		List<User> users=new ArrayList<>();
		users=userRepository.findAllByNameLike(name);
		return users;
	}
	
	
}
