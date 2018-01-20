package com.example.pksiv.uiclient.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.pksiv.uiclient.web.model.User;

@Controller
@RequestMapping("/user")
class MainController {

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @Value("${resource.server.uri:http://localhost:8081/api/users}")
    private String resourceServerUri;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list() {
        final List<User> users = restTemplate.getForObject(resourceServerUri, List.class);
        return new ModelAndView("list", "users", users);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(User user) {
        final MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
        param.add("email", user.getEmail());
        param.add("password", user.getPassword());
        final User created = restTemplate.postForObject(resourceServerUri , param, User.class);
        System.out.println(created);
        return "redirect:/user";
    }

    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(@ModelAttribute final User user) {
        return "form";
    }

}
