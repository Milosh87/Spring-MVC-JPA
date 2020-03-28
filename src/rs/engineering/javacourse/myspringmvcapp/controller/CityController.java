package rs.engineering.javacourse.myspringmvcapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.service.CityService;

@Controller
@RequestMapping(value = "/city")
public class CityController {
	private final CityService<CityDto> cityService;
	
	@Autowired
	CityController(CityService<CityDto> cityService){
		this.cityService = cityService;
	}
	
	@GetMapping
	public String home() {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: home()    ===================");
		System.out.println("====================================================================");
		return "city/home";
	}
	/*
	@GetMapping(value = "add")
	public String add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: add()     ===================");
		System.out.println("====================================================================");
		CityDto cityDto = new CityDto(0l, "-");
		request.setAttribute("cityDto", cityDto);
		return "city/add";
	}
	*/
	
	@GetMapping(value = "add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: add()     ===================");
		System.out.println("====================================================================");
		ModelAndView modelAndView = new ModelAndView("city/add");
		
		CityDto cityDto = new CityDto(0l, "N/A");
		modelAndView.addObject("cityDto",cityDto);
		
		return modelAndView;
	}
	
	
	/*
	@PostMapping(value = "save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: save()    ===================");
		System.out.println("====================================================================");
		
		Long number = Long.parseLong(request.getParameter("number"));
		String name = request.getParameter("name");
		
		CityDto cityDto = new CityDto(number,name);
		
		System.out.println(cityDto);
		return "redirect:/city/add";
	}
	*/
	
	/*
	@PostMapping(value = "save")
	public String save(@RequestParam(name="number") Long number,@RequestParam(name="name") String name) {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: save()    ===================");
		System.out.println("====================================================================");
		
		CityDto cityDto = new CityDto(number,name);
		
		System.out.println(cityDto);
		return "redirect:/city/add";
		
	}
	*/
	
	@RequestMapping(value = "/save",  method = RequestMethod.POST)
	public ModelAndView save(ModelMap model,  @ModelAttribute(value = "cityDto")@Valid CityDto city, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("city/add");
			System.out.println("======= NOT OK ============");
			modelAndView.addObject("cityDto", city);
			return modelAndView;
		}else {
			ModelAndView modelAndView = new ModelAndView("city/home");
			System.out.println("=======  OK ============");
			cityService.save(city);
			return modelAndView;
		}

	}
}
	

