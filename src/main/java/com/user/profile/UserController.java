package com.user.profile;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.user.profile.model.Company;
import com.user.profile.model.User;
import com.user.profile.service.CompanyService;
import com.user.profile.service.SecurityService;
import com.user.profile.service.UserService;




@Controller
public class UserController {


  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  @Autowired
  private CompanyService companyService;

  @Autowired
  private SecurityService securityService;

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
    securityService.autoLogin(userForm.getUsername(), userForm.getPassword());

    return "redirect:/welcome";
  }

  @GetMapping("/login")
  public String login(Model model, String error, String logout) {
    if (error != null)
      model.addAttribute("error", "Your username and password is invalid.");

    if (logout != null)
      model.addAttribute("message", "You have been logged out successfully.");
    logger.info("Log In route called");
    return "login";
  }

  @GetMapping("/users")
  public String listUsers() {
    List<User> users =  userService.listUsers();
    return "welcome";
  }

  @GetMapping({"/", "/welcome"})
  public ModelAndView welcome(Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    User user = userService.getUserByUserName(authentication.getName());
    Company company = companyService.getCompany(user.getCompanyId());
    model.addAttribute("userImage",user.getUserImage());
    model.addAttribute("jobRole", user.getJobRole());
    model.addAttribute("company", company.getName());
    model.addAttribute("companyId", company.getId());
    return new ModelAndView("welcome","user", model);
  }

  @GetMapping("/company")
  public ModelAndView getCompanyById(@RequestParam(name = "id") String id, Model model) {
    companyService.incrementViews(Long.parseLong(id));
    Company company =  companyService.getCompany(Long.parseLong(id));
    model.addAttribute("companyName", company.getName());
    model.addAttribute("address", company.getAddress());
    model.addAttribute("views", company.getViews());
    logger.info("GET company with parameter passing called");
    return new ModelAndView("company", "company", model);
  }
}
