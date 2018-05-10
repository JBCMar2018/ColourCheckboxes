package me.afua.checkboxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    ColourRepo colours;

    @Autowired
    UserRepo users;


    @RequestMapping("/")
    public String showIndex(Model model, HttpServletRequest request)
    {

        String theName = request.getParameter("name");
        //Add an attribute for the list of colours
        model.addAttribute("colours",colours.findAll());
        //Add an attribute for the user
        model.addAttribute("person",users.findAppUserByFirstNameIgnoreCase(theName));
        return "index";
    }

    @PostMapping("/savecolours")
    public String saveColours(@Valid @ModelAttribute("person") AppUser user, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "index";
        }
        users.save(user);
        return "redirect:/?name="+user.getFirstName();
    }

    @PostConstruct
    public void addUsersAndColours()
    {

        //Colours
        Colour c = new Colour();
        c.setName("blue");
        colours.save(c);

        c = new Colour();
        c.setName("orange");
        colours.save(c);

        c = new Colour();
        c.setName("green");
        colours.save(c);

        c = new Colour();
        c.setName("purple");
        colours.save(c);

        c = new Colour();
        c.setName("red");
        colours.save(c);

        AppUser u = new AppUser();
        u.setFirstName("Soulyana");
        u.addColour(colours.findByNameIgnoreCase("blue"));
        u.addColour(colours.findByNameIgnoreCase("purple"));
        users.save(u);

        u = new AppUser();
        u.setFirstName("Dominique");
        u.addColour(colours.findByNameIgnoreCase("orange"));
        u.addColour(colours.findByNameIgnoreCase("pink"));
        users.save(u);

    }
}
