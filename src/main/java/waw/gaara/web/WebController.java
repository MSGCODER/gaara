package waw.gaara.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenn on 16/9/20.
 */
@Controller
@RequestMapping(value = "/")
public class WebController {
    @ResponseBody
    @RequestMapping(value = "")
    public String index(){
        return "GAARA";
    }
}
