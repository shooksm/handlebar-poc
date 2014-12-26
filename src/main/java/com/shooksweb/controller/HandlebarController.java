package com.shooksweb.controller;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.shooksweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/handlebar")
public class HandlebarController {

	@Autowired
	ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) throws IOException {
		TemplateLoader templateLoader = new ClassPathTemplateLoader();
		templateLoader.setPrefix("WEB-INF/static/hbs");
		Handlebars handlebars = new Handlebars(templateLoader);
		Template template = handlebars.compile("index");
		modelMap.addAttribute(productService.getProducts());
		return template.apply(modelMap);
	}
}
