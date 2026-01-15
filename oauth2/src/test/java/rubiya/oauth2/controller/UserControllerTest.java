package rubiya.oauth2.controller;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import static org.junit.jupiter.api.Assertions.assertEquals;

import rubiya.oauth2.entity.User;
import rubiya.oauth2.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
@InjectMocks
private usercontroller userController;

@Mock
private UserService userService;

@Mock
private Authentication authentication;

@Mock
private UserDetails userDetails;

@Test
public void testGetProfile_success() {
	//Mock authentication and UserDetails
	
	Mockito.when(authentication.getPrincipal())
	.thenReturn(userDetails);
	
	Mockito.when(userDetails.getUsername())
	.thenReturn("rubiya@example.com");
	
	//Mock UserService
	User mockUser = new User();
	mockUser.setId(1L);
	mockUser.setName("Rubiya");
	mockUser.setEmail("rubiya@example.com");
	
	Mockito.when(userService.getUserByEmail("rubiya@example.com"))
	.thenReturn(mockUser);
	
	//call controller
	ResponseEntity<?> response = userController.getProfile(authentication);
	
	//verify
	assertEquals(HttpStatus.OK,response.getStatusCode());
	
	Map<String,Object> body = (Map<String,Object>) response.getBody();
	assertEquals(1L,body.get("id"));
	assertEquals("Rubiya",body.get("name"));
	assertEquals("rubiya@example.com",body.get("email"));
	
}
}
