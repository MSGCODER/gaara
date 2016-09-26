package waw.gaara.web.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenn on 16/9/25.
 */
@Controller
@RequestMapping(value = "/client")
public class ClientController {
    @RequestMapping(value = "/callback")
    @ResponseBody
    public String callback(@RequestParam String code){
        return code;
    }
}
