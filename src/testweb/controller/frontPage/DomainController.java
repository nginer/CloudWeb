package testweb.controller.frontPage;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import testweb.dao.impl.ServiceDaoImpl;
import testweb.vo.Service;

@Controller
public class DomainController extends AbstractController {

	@Override
	@RequestMapping("/Sports")
	public ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub		
		ServiceDaoImpl sdi = new ServiceDaoImpl();
		List<Service> Slist = sdi.getServiceByDomain("sports");	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Slist", Slist);
		System.out.println("就知道！！！");
		ModelAndView modelAndview = new ModelAndView("/views/Sports",model);
		return modelAndview;
	}
	
	@RequestMapping("/Aesthetic")
	public ModelAndView handleRequestInternalAesthetic(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub		
		ServiceDaoImpl sdi = new ServiceDaoImpl();
		List<Service> Slist = sdi.getServiceByDomain("Aesthetic");	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Slist", Slist);
		System.out.println("就知道！！！Aesthetic");
		ModelAndView modelAndview = new ModelAndView("/views/Aesthetic",model);
		return modelAndview;
	}
	

	@RequestMapping("/AncientLiterature")
	public ModelAndView handleRequestInternalAncientLiterature(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub		
		ServiceDaoImpl sdi = new ServiceDaoImpl();
		List<Service> Slist = sdi.getServiceByDomain("AncientLiterature");	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Slist", Slist);
		System.out.println("就知道！！！AncientLiterature");
		ModelAndView modelAndview = new ModelAndView("/views/AncientLiterature",model);
		return modelAndview;
	}
	

	@RequestMapping("/Architecture")
	public ModelAndView handleRequestInternalArchitecture(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub		
		ServiceDaoImpl sdi = new ServiceDaoImpl();
		List<Service> Slist = sdi.getServiceByDomain("Architecture");	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Slist", Slist);
		System.out.println("就知道！！！Architecture");
		ModelAndView modelAndview = new ModelAndView("/views/Architecture",model);
		return modelAndview;
	}
	

	@RequestMapping("/ArtAndAestheticValue")
	public ModelAndView handleRequestInternalArtAndAestheticValue(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub		
		ServiceDaoImpl sdi = new ServiceDaoImpl();
		List<Service> Slist = sdi.getServiceByDomain("ArtAndAestheticValue");	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Slist", Slist);
		System.out.println("就知道！！！ArtAndAestheticValue");
		ModelAndView modelAndview = new ModelAndView("/views/ArtAndAestheticValue",model);
		return modelAndview;
	}
	
	@RequestMapping("/Ecosystem")
	public ModelAndView handleRequestInternalEcosystem(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub		
		ServiceDaoImpl sdi = new ServiceDaoImpl();
		List<Service> Slist = sdi.getServiceByDomain("Ecosystem");	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Slist", Slist);
		System.out.println("就知道！！！Ecosystem");
		ModelAndView modelAndview = new ModelAndView("/views/Ecosystem",model);
		return modelAndview;
	}
	

	@RequestMapping("/ShapeAndStyle")
	public ModelAndView handleRequestInternalShapeAndStyle(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub		
		ServiceDaoImpl sdi = new ServiceDaoImpl();
		List<Service> Slist = sdi.getServiceByDomain("ShapeAndStyle");	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Slist", Slist);
		System.out.println("就知道！！！ShapeAndStyle");
		ModelAndView modelAndview = new ModelAndView("/views/ShapeAndStyle",model);
		return modelAndview;
	}
	

	@RequestMapping("/VillageArchitecturalCulture")
	public ModelAndView handleRequestInternalVillageArchitecturalCulture(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub		
		ServiceDaoImpl sdi = new ServiceDaoImpl();
		List<Service> Slist = sdi.getServiceByDomain("VillageArchitecturalCulture");	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Slist", Slist);
		System.out.println("就知道！！VillageArchitecturalCulture！");
		ModelAndView modelAndview = new ModelAndView("/views/VillageArchitecturalCulture",model);
		return modelAndview;
	}



	
	

}
