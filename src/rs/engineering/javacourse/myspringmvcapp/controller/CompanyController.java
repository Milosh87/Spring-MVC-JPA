package rs.engineering.javacourse.myspringmvcapp.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.model.CompanyDto;
import rs.engineering.javacourse.myspringmvcapp.service.CityService;
import rs.engineering.javacourse.myspringmvcapp.service.CompanyService;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {
	private final CityService<CityDto> cityService;
	private final CompanyService<CompanyDto> companyService;

	@Autowired
	public CompanyController(CityService<CityDto> cityService, CompanyService<CompanyDto> companyService) {
		this.cityService = cityService;
		this.companyService = companyService;

	}

	@GetMapping
	public String home() {
		return "company/home";
	}

	@GetMapping(value = "add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("company/add");
		CompanyDto companyDto = new CompanyDto();
		modelAndView.addObject("companyDto", companyDto);
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(ModelMap model, @ModelAttribute(value = "companyDto") @Valid CompanyDto company,
			BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			System.out.println("======= NOT OK ============");
			modelAndView.setViewName("company/add");
			modelAndView.addObject("companyDto", company);

		} else {
			System.out.println("=======  OK ============");
			modelAndView.setViewName("redirect:/company/all");

			companyService.save(company);

		}
		return modelAndView;

	}
	@GetMapping(value="all")
	public ModelAndView all(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView("company/all");
		return modelAndView;
	}
	
	@GetMapping(value="remove")
	public ModelAndView remove(ModelMap model, @RequestParam(name="id") Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/company/all");
		companyService.remove(id);
		return modelAndView;
	}
	
	@GetMapping(value="edit")
	public ModelAndView edit(ModelMap model, @RequestParam(name="id") Long id,
			@RequestParam(name="name") String name, @RequestParam(name="address") String address,
			@RequestParam(name="number") String number, @RequestParam(name="cityId") Long cityId) {
				ModelAndView modelAndView = new ModelAndView("company/edit");
				CityDto cityDto = cityService.findById(cityId);
				CompanyDto companyDto = new CompanyDto(id,name,address,number, cityDto);
		modelAndView.addObject("companyDto", companyDto);
		return modelAndView;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(ModelMap model, @ModelAttribute(value = "companyDto") @Valid CompanyDto company,
			BindingResult result) {
		System.out.println("KOMPANIJA KOJA SE EDITUJE");
		System.out.println(company);
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			System.out.println("======= NOT OK ============");
			modelAndView.setViewName("company/edit");
			modelAndView.addObject("companyDto", company);

		} else {
			System.out.println("=======  OK ============");
			modelAndView.setViewName("redirect:/company/all");

			companyService.edit(company);

		}
		return modelAndView;

	}

	@ModelAttribute(value = "cities")
	private List<CityDto> cities() {
		return cityService.getAll();
	}
	@ModelAttribute(value = "companies")
	private List<CompanyDto> companies() {
		return companyService.getAll();
	}

}
