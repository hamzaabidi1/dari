package tn.Dari.spring.service;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import tn.Dari.spring.entity.User;

public interface UserService extends UserDetailsService {
	User addUser(User user);

	public List<User> retreiveAllUsers();

	boolean deleteUser(Principal principal);

	boolean isEnabled();

	// void save(User user, String siteURL) throws UnsupportedEncodingException,
	// MessagingException;

	boolean verify(String code);

	void register(User user, String siteURL) throws UnsupportedEncodingException, MessagingException;

	User findByEmail(String email);

	UserDetails loadUserByUsername(String username);

	void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException;

	List<User> listAll(String keyword);
	List<User> findAllByNameLike(String name);

	// void updateUser(User user, Authentication authentication);

}
