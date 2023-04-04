package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    @Autowired(required = true)
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("user") User user) {
        if (user.getId() == 0) {
            this.userService.addUser(user);
        } else {
            this.userService.updateUser(user);
        }
        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        this.userService.removeUser(id);

        return "redirect:/users";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getById(id));
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping("/userData/{id}")
    public String userData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getById(id));

        return "userData";
    }
}
