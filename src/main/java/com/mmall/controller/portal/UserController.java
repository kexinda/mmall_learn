package com.mmall.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by kexi955 on 4/23/2024.
 */

@Controller
@RequestMapping("/user/")
public class UserController {
    /**
     * USER LOGIN
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public Object login(String username, String password, HttpSession session){



        return null;
    }




}
