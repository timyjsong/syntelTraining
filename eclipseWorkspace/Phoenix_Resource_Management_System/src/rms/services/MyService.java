package rms.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyService {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String index()
    {
        return "welcome2";
    }
    @RequestMapping(value="/utilization",method = RequestMethod.GET)
    public String utilization()
    {
        return "util";
    }
}
