package pt.dockoder.secureserver.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.dockoder.secureserver.service.impl.UserService;
import pt.dockoder.secureserver.utils.Globals;

@RestController
public class TokenController {

    @Autowired
    private UserService userService;

    @PostMapping("/token")
    public String getToken(@RequestParam("username") final String username,
                           @RequestParam("password") final String passWord){
        String token = userService.login(username, passWord);

        return StringUtils.isEmpty(token) ? Globals.NO_TOKEN_FOUND : token;
    }
}
