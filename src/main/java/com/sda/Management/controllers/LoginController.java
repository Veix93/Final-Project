package com.sda.Management.controllers;
import com.sda.Management.dto.UserRegistrationDto;
import com.sda.Management.models.User.User;
import com.sda.Management.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class LoginController {
    private final UserService userService;

    @Autowired

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("index")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        UserRegistrationDto user = new UserRegistrationDto();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration/save")
    public String registration(
            @Valid @ModelAttribute("user") UserRegistrationDto user,
            BindingResult result,
            Model model) {
        User existingUserEmail = userService.findByEmail(user.getEmail());
        if (existingUserEmail != null
                && existingUserEmail.getEmail() != null
                && existingUserEmail.getEmail().isEmpty()) {
            return "redirect:/registration?fail";
        }
        User existingUsername = userService.findByUsername(user.getUsername());
        if (existingUsername != null
                && existingUsername.getUsername() != null
                && existingUsername.getUsername().isEmpty()) {
            return "redirect:/registration?fail";
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "registration";
        }
        userService.saveUser(user);
        return "redirect:/login?success";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<UserRegistrationDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @InitBinder("birthdate")
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    setValue(sdf.parse(text));
                } catch (ParseException e) {
                    setValue(null);
                }
            }

            @Override
            public String getAsText() {
                return sdf.format((Date) getValue());
            }
        });
    }
}
