package trainMe.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trainMe.api.RestAPIService;
import trainMe.api.apiModel.FeedbackApiType;
import trainMe.jsonObjects.TestObject;
import trainMe.model.Feedback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romab on 11/13/16.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private RestAPIService restAPIService;

    @RequestMapping(value = "/test",method= RequestMethod.GET)
    public TestObject getTest() {

        TestObject test = new TestObject(3,"name","alias",213214);

        return test;
    }

    @RequestMapping(value = "/feedback/{feedbackId}",method= RequestMethod.GET)
    public Feedback getFeedback(@PathVariable("feedbackId") int feedbackId) {
        return restAPIService.getFeedbackById(feedbackId);
    }

    @RequestMapping(value = "/feedbacks/{userId}",method= RequestMethod.GET)
    public ArrayList<FeedbackApiType> getFeedbacks(@PathVariable("userId") int userId) {
        return restAPIService.getFeedbacksByUserId(userId);
    }

    @RequestMapping(value = "/disciplines/{userId}",method= RequestMethod.GET)
    public List getDisciplinesByUserId(@PathVariable("userId") int userId) {
        return restAPIService.getDisciplinesByUserId(userId);
    }

    @RequestMapping(value = "/disciplinesToAdd/{userId}",method= RequestMethod.GET)
    public List getSortedDisciplinesNamesToAdd(@PathVariable("userId") int userId) {
        return restAPIService.getSortedDisciplinesNamesToAdd(userId);
    }

    @RequestMapping(value = "/chats/byId/{userId}",method= RequestMethod.GET)
    public List getUsersChatsListByUserId(@PathVariable("userId") int userId) {
        return restAPIService.getUsersChatsList(userId);
    }

    @RequestMapping(value = "/chats/byLogin/{userLogin}",method= RequestMethod.GET)
    public List getUsersChatsListByUserLogin(@PathVariable("userLogin") String userLogin) {
        return restAPIService.getUsersChatsList(userLogin);
    }

    @RequestMapping(value = "/messages/{chatId}",method= RequestMethod.GET)
    public List getChatMessages(@PathVariable("chatId") int chatId) {

        return restAPIService.getChatMessages(chatId);
    }


    @RequestMapping(value = "/autocomplete/disciplines/{param}",method= RequestMethod.GET)
    public ArrayList<String> getDisciplines(@PathVariable("param") String parameter) {

        return restAPIService.getDisciplinesNamesStartsWithParam(parameter);
    }

    @RequestMapping(value = "/autocomplete/full_names/{param}",method= RequestMethod.GET)
    public ArrayList<String> getUsersFullNames(@PathVariable("param") String parameter) {

        return restAPIService.getUsersFullNamesStartsWithParam(parameter);

    }






}
