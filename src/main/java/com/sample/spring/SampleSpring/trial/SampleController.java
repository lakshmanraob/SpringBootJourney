package com.sample.spring.SampleSpring.trial;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class SampleController {

    @RequestMapping(value = {"", "/"})
    String get() {
        return "Initial Mapping";
    }

    @RequestMapping(value = {"/index", "/page*"})
    String getIndex() {
        return "Index Mapping";
    }

    //called as http://localhost:8080/home/id?id=lakshman
    @RequestMapping(value = "/id")
    String getRequestById(@RequestParam("id") String personId) {
        return "Get the Id from the request" + personId;
    }

    //called as http://localhost:8080/home/personName?personName=lakshman
    @RequestMapping(value = "/personName")
    String getPersonName(@RequestParam String personName) {
        return "Request personName " + personName;
    }

    //http://localhost:8080/home/name?person=madhavi
    //http://localhost:8080/home/name
    @RequestMapping(value = "name")
    String getOptionalValue(@RequestParam(value = "person", required = false) String personName) {
        return "It should respond for both variants " + personName;
    }

    //http://localhost:8080/home/defName?person=lakshman
    //http://localhost:8080/home/defName
    @RequestMapping(value = "/defName")
    String getDefName(@RequestParam(value = "person", defaultValue = "madhu") String personName) {
        return "gives us the defaultName " + personName;
    }

    //http://localhost:8080/home/fetch?personId=10
    @RequestMapping(value = "/fetch", params = {
            "personId=10"
    })
    String getParams(@RequestParam("personId") String id) {
        return "Fetched parameter using params attribute = " + id;
    }

    //http://localhost:8080/home/fetch?personId=20
    @RequestMapping(value = "/fetch", params = {
            "personId=20"
    })
    String getParamsDifferent(@RequestParam("personId") String id) {
        return "Fetched parameter using params attribute = " + id;
    }

    @RequestMapping(value = "/fetch/{id}", method = RequestMethod.GET)
    String getDynamicUriValue(@PathVariable String id) {
        System.out.println("ID is " + id);
        return "Dynamic URI parameter fetched";
    }

    @RequestMapping(value = "/fetch/{id:[a-z]+}/{name}", method = RequestMethod.GET)
    String getDynamicUriValueRegex(@PathVariable("name") String name) {
        System.out.println("Name is " + name);
        return "Dynamic URI parameter fetched using regex";
    }

}
