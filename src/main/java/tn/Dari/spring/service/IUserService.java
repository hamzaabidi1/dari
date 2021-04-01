package tn.Dari.spring.service;

import java.util.List;
import org.springframework.security.core.Authentication;

import tn.Dari.spring.entity.User;
import tn.Dari.spring.payload.SignUpRequest;


public interface IUserService {
	public User getUserById(long userId);
	public List<User> getAllUsers();
	public String deleteUserById(long userId);
	public User updateUser(User u, Authentication auth);
    public User getMyInfo(Authentication auth);
    public void desactivate_Acount(long userId);
    public void activate_Acount(long userId);
    public void setTokenToBlackList(long userId);
    public List<String> getRoleById(long userId);
    public List<User> getListConnectedUser();
    public List <User> getNewUserByNbDays(int nbDays);
    public void logout(Authentication auth);
	public void deleteRole(long userId);
	User save(SignUpRequest signUpRequest);
	List<User> findAllByNameLike(String name);
}
