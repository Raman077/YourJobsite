package com.user.profile;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.user.profile.model.User;
import com.user.profile.service.UserService;

@Controller
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/registration")
  public String registration(Model model) {
    model.addAttribute("userForm", new User());

    return "registration";
  }

  @PostMapping("/registration")
  public String registration(
      @ModelAttribute("userForm")
          User userForm, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "registration";
    }

    userService.createUser(userForm);

    //    securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

    return "redirect:/welcome";
  }

  @GetMapping("/login")
  public String login(Model model, String error, String logout) {
    if (error != null)
      model.addAttribute("error", "Your username and password is invalid.");

    if (logout != null)
      model.addAttribute("message", "You have been logged out successfully.");

//    search the db for user, extract id and hit userService.getUser(id)
//    info retrieved has to be filled in the form
    return "login";
  }

  @GetMapping("/users")
  public String listUsers() {
    List<User> users =  userService.listUsers();
    return "welcome";
  }

  @GetMapping({"/", "/welcome"})
  public String welcome(Model model) {
    return "welcome";
  }
}
