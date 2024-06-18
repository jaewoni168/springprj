package com.security2.service;

import java.util.List;
import java.util.Map;

import com.security2.dto.User;
import com.security2.mapper.UserMapper;
import com.security2.model.UserOAuth2SignUp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    ModelMapper modelMapper = new ModelMapper();

    public List<User> findAll() {
        return userMapper.findAll();
    }

//    네이버
    Map<String, Object> getAttributes(OAuth2AuthenticationToken auth) {
        String provider = auth.getAuthorizedClientRegistrationId();
        Map<String, Object> attributes = auth.getPrincipal().getAttributes();
        if (provider.equals("naver"))
            attributes = (Map<String, Object>)attributes.get("response");
        return attributes;
    }  // 끝


    public String getOAuth2Id(OAuth2AuthenticationToken auth) {
        String provider = auth.getAuthorizedClientRegistrationId();
        String id = "";
        switch (provider) {
            case "github": id = auth.getPrincipal().getAttributes().get("id").toString(); break;
            case "google": id = auth.getPrincipal().getAttributes().get("sub").toString(); break;
            case "naver": id = getAttributes(auth).get("id").toString(); break;
        }
        return provider + ":" + id;
    }


    public User findByOAuth2Id(OAuth2AuthenticationToken auth) {
        String oauth2Id = getOAuth2Id(auth);
        return userMapper.findByOAuth2Id(oauth2Id);
    }

    public UserOAuth2SignUp createUserOAuth2SignUp(OAuth2AuthenticationToken auth) {
        Map<String, Object> attributes = getAttributes(auth);
        var userOAuthSignUp = new UserOAuth2SignUp();

        userOAuthSignUp.setName((String) attributes.get("name"));
        userOAuthSignUp.setEmail((String) attributes.get("email"));

        return userOAuthSignUp;
    }

    public User insert(OAuth2AuthenticationToken auth, UserOAuth2SignUp userOAuth2SignUp,
                       BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            throw new Exception("사용자를 등록할 수 없습니다.");
        User user = userMapper.findByLoginName(userOAuth2SignUp.getLoginName());
        if (user != null) {
            bindingResult.rejectValue("loginName", null, "사용자 아이디가 중복됩니다.");
            throw new Exception("사용자를 등록할 수 없습니다.");

        }
        User newUser = modelMapper.map(userOAuth2SignUp, User.class);
        newUser.setEnabled(true);
        newUser.setOauth2Id(getOAuth2Id(auth));
        userMapper.insert(newUser);
        return newUser;
    }
}
