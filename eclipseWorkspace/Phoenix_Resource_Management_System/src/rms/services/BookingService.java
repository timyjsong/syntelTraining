package rms.services;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rms.dao.BookingDAO;
import rms.dao.ChartData;

import java.util.List;

@Controller
@RequestMapping("/Booking")
public class BookingService {

	@RequestMapping(method=RequestMethod.GET)
	public String home()
	{
		return "welcome2";
	}
	@RequestMapping(value="/Reservation",method=RequestMethod.GET)
	public String reservation(ModelMap modelList)
	{
		// Grab locations
		// Grab Rooms
		return "Booking/ReservationView";
	}
	@RequestMapping(value="/Utilization",method=RequestMethod.GET)
	public String utilization(ModelMap modelList)
	{
		// Grab locations
		// Grab Rooms
        BookingDAO dao = new BookingDAO();
        List<ChartData> list = dao.getNumberBookingPerDay();
        for(ChartData i : list)
        {
            System.out.println(i.getDateTime()+" "+i.getNumDays());

        }

        modelList.addAttribute("chartData",list);
		return "util";
	}
	/* Add the Restful Services as well */
}
