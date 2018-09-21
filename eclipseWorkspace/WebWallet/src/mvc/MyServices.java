package mvc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyServices {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String welcome(ModelMap map) {
		return "welcome";
	}
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String home(ModelMap map) {
		return "welcome";
	}
	
	@RequestMapping(value="/viewCustomer",method=RequestMethod.GET)
	public String showAllCustomers(ModelMap map) {
		List<Customer> list = new ShowAllCustomerLogic().selectAllCustomer();
		map.addAttribute("allcust", list);
		return "allcustomers";
	}
	
	@RequestMapping(value="/newCustomer",method=RequestMethod.GET)
	public ModelAndView addNewCustomer() {
		return new ModelAndView("newCustomerForm","command",new Customer());
	} 
	
	@RequestMapping(value="saveNewCustomer",method=RequestMethod.POST)
	public ModelAndView saveNewCustomer(@ModelAttribute("cust") Customer cust) {
		int ret = new ShowAllCustomerLogic().insertCustomer(cust);
		if(ret>0)
			return new ModelAndView("redirect:/viewCustomer");
		else
			return new ModelAndView("Error");
	}
	
	@RequestMapping(value="deleteCustomer/{custId}")
	public ModelAndView deleteCustomer(@PathVariable int custId) {
		
		int ret = new ShowAllCustomerLogic().deleteCustomer(custId);
		if(ret>0) 
			return new ModelAndView("redirect:/viewCustomer");
		else 
			return new ModelAndView("Error");
	}
	
	@RequestMapping(value="editCustomer/{custId}")
	public ModelAndView editCustomer(@PathVariable int custId) {
		
		Customer ret = new ShowAllCustomerLogic().getCustomer(custId);
		return new ModelAndView("editCustomerForm","command",ret);
		
	}
	
	@RequestMapping(value="saveEditCustomer",method=RequestMethod.POST)
	public ModelAndView saveEditCustomer(@ModelAttribute("cust") Customer cust) {
		
		int ret = new ShowAllCustomerLogic().updateCustomer(cust);
		if(ret>0)
			return new ModelAndView("redirect:/viewCustomer");
		else
			return new ModelAndView("Error");
	}
	
}
