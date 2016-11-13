package trainMe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import trainMe.model.Discipline;
import trainMe.model.User;
import trainMe.services.AvatarService;
import trainMe.services.DisciplineService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by romab on 11/13/16.
 */
@Controller
@RequestMapping("/modify/")
public class ModifyUsersDataController {


    @Autowired
    DisciplineService disciplineService;
    @Autowired
    AvatarService avatarService;

    @RequestMapping(value = "avatar", method = RequestMethod.POST)
    public String updateAvatar (HttpServletRequest request,
                                @RequestParam("newAvatar") MultipartFile file) throws IOException{

        avatarService.update((User)request.getSession().getAttribute("currentSessionUser"), file);
        return "redirect:/userPage";
    }



    @RequestMapping(value = "discipline/add", method = RequestMethod.POST)
    public String addDiscipline(HttpServletRequest request,
                                @RequestParam(value="disciplineToAdd", required=false) String disciplineToAdd){

        disciplineService.addDiscipline((User)request.getSession().getAttribute("currentSessionUser"),
                                            disciplineToAdd);

        return "redirect:/userPage";

    }

    @RequestMapping(value = "discipline/remove", method = RequestMethod.POST)
    public String removeDiscipline(HttpServletRequest request,
                                @RequestParam(value="disciplineToRemove", required=false) String disciplineToRemove){

        disciplineService.removeDiscipline((User)request.getSession().getAttribute("currentSessionUser"),
                disciplineToRemove);

        return "redirect:/userPage";

    }
}
