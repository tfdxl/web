package com.monlie.web.controller;

import com.monlie.web.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * user controller
 *
 * @author monlie
 */
@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/api/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping("/indexPage")
    public String helloFtl(HttpServletRequest request, @RequestParam("name") String name, Map<String, Object> map) {

        final String remoteAddr = request.getRemoteAddr();
        final String remoteHost = request.getRemoteHost();
        final int port = request.getRemotePort();

        log.info("Remote info ,addr:{},host:{},port:{}", remoteAddr, remoteHost, port);
        String remoteUser = request.getRemoteUser();

        Thread.State state = Thread.currentThread().getState();
        Thread current = Thread.currentThread();
        log.info("Current Thread is " + current.getName() + ", state is " + state.toString());
        map.put("desc", userRepository.getUserInfo());
        map.put("hello", "Hello FreeMarker");
        return "index";
    }
}
