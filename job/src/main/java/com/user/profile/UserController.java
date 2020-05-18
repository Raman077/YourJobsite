package com.user.profile;
import java.util.List;
import java.util.Map;

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
    securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

    return "redirect:/welcome";
  }

  @GetMapping("/login")
  public String login(Model model, String error, String logout) {
    if (error != null)
      model.addAttribute("error", "Your username and password is invalid.");

    if (logout != null)
      model.addAttribute("message", "You have been logged out successfully.");

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
    model.addAttribute("jobRole", user.getJobRole());
    model.addAttribute("company", company.getName());
    model.addAttribute("companyId", company.getId());
    return new ModelAndView("welcome","user", model);
  }

  @GetMapping("/company/{id}")
  public ModelAndView getCompanyById(@PathVariable("id") String id, Model model) {
    System.out.println("1");
    companyService.incrementViews(Long.parseLong(id));
    Company company =  companyService.getCompany(Long.parseLong(id));
    model.addAttribute("companyName", company.getName());
    model.addAttribute("address", company.getAddress());
    model.addAttribute("views", company.getViews());
    System.out.println("getcompaniesbyid saved");
    return new ModelAndView("company", "company", company);
  }
}
