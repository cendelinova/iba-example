package com.mycompany.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Petra
 */
@Controller
public class HelloMVCController {

    @RequestMapping(value = "/helloMVC", method = RequestMethod.GET)
    public String printHello(@RequestParam(value = "x", required = false) String x, ModelMap model) {

        model.addAttribute("message", "Hello IBA!");   
        int count = 1;
        if (x != null) {
            try {
                count = Integer.parseInt(x);
                if (count<0) count = 1;
            } catch (NumberFormatException ex) {
                count = 1;
            }
        }

        model.addAttribute("x", count);
        return "helloMVC";

    }

}
