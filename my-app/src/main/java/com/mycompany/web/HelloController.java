
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
public class HelloController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(@RequestParam(value = "x", required = false) Integer x, ModelMap model) {

		model.addAttribute("message", "Hello IBA!");
                model.addAttribute("x",x == null ? 1 : x);
		return "hello";

	}
}
