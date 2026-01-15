package rubiya.oauth2.service;

import rubiya.oauth2.DTO.RegisterRequest;

import rubiya.oauth2.entity.User;

public interface UserService {

    User registerUser(RegisterRequest request);

    User loginUser(String email, String rawPassword);

    User processOAuthPostLogin(String email, String name, String providerId);

    User getUserByEmail(String email);
}
