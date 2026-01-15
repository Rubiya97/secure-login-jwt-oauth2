package rubiya.oauth2.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rubiya.oauth2.entity.User;
import rubiya.oauth2.service.UserService;

@RestController
@RequestMapping("/user")
public class usercontroller {
	
	
	
@Autowired
private UserService userService;
	
	@GetMapping("/profile")
	public ResponseEntity<?> getProfile(Authentication authentication) {
	    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	    User user = userService.getUserByEmail(userDetails.getUsername());

	    return ResponseEntity.ok(Map.of(
	            "id", user.getId(),
	            "name", user.getName(),
	            "email", user.getEmail()
	    ));
	}

}
