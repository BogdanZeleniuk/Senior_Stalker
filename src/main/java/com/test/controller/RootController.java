package com.test.controller;

import com.test.dto.UserDTO;
import com.test.dto.UserUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class RootController extends AbstractUserController{

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(ModelMap model,
                        @RequestParam(value = "error", required = false) boolean error,
                        @RequestParam(value = "message", required = false) String message){
        model.put("error", error);
        model.put("message", message);
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap model) {
        model.addAttribute("userDTO", new UserDTO());
        model.addAttribute("register", true);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegister(@Valid UserDTO userDTO, BindingResult result, SessionStatus status, ModelMap model) {
        if (!result.hasErrors()) {
            try {
                super.create(UserUtil.createUserFromDTO(userDTO));
                status.setComplete();
                return "redirect:login?message=user.registered";
            } catch (DataIntegrityViolationException ex) {
                result.rejectValue("email", "duplicate.login");
                return "redirect:login?error=true";
            }
        }
        model.addAttribute("register", true);
        return "register";
    }
}
