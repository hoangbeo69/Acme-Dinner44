package controllers.diner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import security.LoginService;
import services.DinerService;
import services.EventService;
import controllers.AbstractController;
import domain.Diner;

@Controller
@RequestMapping("/diner/bussinessCard")
public class DinerBussinessCardController extends AbstractController {
	
	// Services ---------------------------------------------------------------

		@Autowired
		private DinerService dinerService;
		
		@Autowired
		private EventService eventService;
		
		@Autowired
		private LoginService loginService;
		
		// Constructors -----------------------------------------------------------
		
		public DinerBussinessCardController() {
			super();
		}

		// Bussiness card of a diner ----------------------------------------------------------------

		@RequestMapping(value = "/view", method = RequestMethod.GET)
		public ModelAndView bussinessCard(@RequestParam(required = true) final int q) {
			ModelAndView result;
			result = new ModelAndView("bussinessCard/view");
			
			Diner d = dinerService.findOne(q);
			result.addObject("personalSection", d.getBussinessCard().getPersonalSection());
			result.addObject("professionalSections", d.getBussinessCard().getProfessionalSections());
			result.addObject("socialSections", d.getBussinessCard().getSocialSections());
			result.addObject("bussinessCard", d.getBussinessCard());
			
			return result;
		}
		
		//My bussiness card view
		@RequestMapping("/myView")
		public ModelAndView myBussinessCard() {
			ModelAndView result;
			result = new ModelAndView("bussinessCard/myView");
			
			Diner d = (Diner) loginService.findActorByUsername(LoginService.getPrincipal().getId());
			
			result.addObject("personalSection", d.getBussinessCard().getPersonalSection());
			result.addObject("professionalSections", d.getBussinessCard().getProfessionalSections());
			result.addObject("socialSections", d.getBussinessCard().getSocialSections());
			result.addObject("bussinessCard", d.getBussinessCard());

			return result;
		}
		

		// Creation ---------------------------------------------------------------

		/*@RequestMapping(value="/create",method=RequestMethod.GET)
		public ModelAndView create(){
			ModelAndView res;

			res = new ModelAndView("diner/create");
			res.addObject("diner",dinerService.create());

			return res;
		}*/
		
		// Save ---------------------------------------------------------------
		/*@RequestMapping(value="/save",method=RequestMethod.POST,params = "save")
		public ModelAndView saveCreate(@Valid Diner diner, BindingResult binding){
			ModelAndView res;

			if(binding.hasErrors()){
				res = createModelAndView(diner,null);
			}else{
				try{
					dinerService.save(diner);
					res = new ModelAndView("redirect:/welcome/index.do");

				}catch(Throwable e){
					res = createModelAndView(diner, "diner.commit.error");
				}
			}
			return res;

		}*/


		/*@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
		public ModelAndView delete(Diner diner) {
			ModelAndView result;

			dinerService.delete(diner);
			result = new ModelAndView("redirect:list.do");

			return result;
		}*/
		
		// Ancillary methods ------------------------------------------------------
		
		protected ModelAndView createModelAndView(Diner diner,String message){
			ModelAndView res;
			res = new ModelAndView("diner/create");
			res.addObject("diner", diner);
			res.addObject("message",message);
			return res;
		}


}
