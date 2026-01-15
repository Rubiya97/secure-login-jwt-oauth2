package rubiya.oauth2.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.servlet.http.HttpServletResponse;
import rubiya.oauth2.DTO.RegisterRequest;
import rubiya.oauth2.DTO.RegisterResponse;
import rubiya.oauth2.entity.User;
import rubiya.oauth2.jwt.JwtUtil;
import rubiya.oauth2.service.UserService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

	
	@InjectMocks
	private AuthController authController;
	
	@Mock 
	private UserService userService;
	
	@Mock
	private JwtUtil jwtUtil;
	
	@Mock 
	private HttpServletResponse response;
	
	
	@Test
	public void testRegister_success() {
		RegisterRequest request = new RegisterRequest();
		request.setName("Rubiya");
		request.setEmail("rubiya@example.com");
		request.setPassword("pass123");
		
		User mockUser = new User();
		mockUser.setId(1L);
		mockUser.setName("Rubiya");
		mockUser.setEmail("rubiya@example.com");
		
		Mockito.when(userService.registerUser(Mockito.any(RegisterRequest.class)))
		   .thenReturn(mockUser);
		
		RegisterResponse response = authController.register(request);
		
		
		assertEquals(1L, response.getId());
		assertEquals("Rubiya",response.getName());
		assertEquals("rubiya@example.com",response.getEmail());
		assertEquals("Registration successful!", response.getMessage());
	}
	
}
