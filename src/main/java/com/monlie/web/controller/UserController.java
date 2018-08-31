package com.monlie.web.controller;

import com.monlie.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * user controller
 *
 * @author monlie
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/api/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping("/indexPage")
    public String helloFtl(HttpServletRequest request, Map<String, Object> map) {

        String method = request.getMethod();
        System.err.print(method);
        //Thread.dumpStack();
        map.put("desc", userRepository.getUserInfo());
        map.put("hello", "Hello FreeMarker");
        return "index";
    }
}
