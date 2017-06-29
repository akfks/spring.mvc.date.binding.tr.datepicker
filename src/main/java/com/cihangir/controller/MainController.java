package com.cihangir.controller;

import com.cihangir.model.Travel;
import com.cihangir.model.User;
import com.cihangir.service.impl.UserService;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cihangir on 5/16/17.
 */

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder ) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        webDataBinder.registerCustomEditor(Date.class,"beginTime",new CustomDateEditor(sdf, false));
        webDataBinder.registerCustomEditor(Date.class,"endTime",new CustomDateEditor(sdf, false));

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showTravelForm(Model theModel) {

        theModel.addAttribute("newTravel",new Travel());
        return "travel-add";
    }

    @RequestMapping(value = "/travellist", method = RequestMethod.GET)
    public String getTravelList(Model model) {
        // get users from the service
        List<Travel> travelList=userService.getAllTravel();

        // add the users to the model
        model.addAttribute("travels", travelList);

        return "travel-list";
    }

    @RequestMapping("/insert")
    public String insertTravel(@ModelAttribute("newTravel") Travel theTravel){

        userService.saveTravel(theTravel);
        return "redirect:/travellist";
    }

    @RequestMapping(value = "/search")
    public String searchTravel(@RequestParam("datepicker1") @DateTimeFormat(pattern="dd.MM.yyyy") Date  d1, @RequestParam("datepicker2") @DateTimeFormat(pattern="dd.MM.yyyy") Date  d2, Model theModel) throws ParseException {

        System.out.println("Bu:"+d1);
        System.out.println("ŞU:"+d2);

        List<Travel> travelList = userService.getTravelsBetweenDate(d1, d2);

        // add the users to the model
        theModel.addAttribute("travels", travelList);

        return "travel-list";
    }


//    @RequestMapping(value = "/search")
//    public String searchTravel(@RequestParam("datepicker1") String  d1, @RequestParam("datepicker2") String  d2, Model theModel) throws ParseException {
//
//        System.out.println("Bu:"+d1);
//        System.out.println("ŞU:"+d2);
//
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//        Date t1=sdf.parse(d1);
//        Date t2=sdf.parse(d2);
//
//        System.out.println("T1:"+t1);
//        System.out.println("T2:"+t2);
//
//
//        List<Travel> travelList = userService.getTravelsBetweenDate(t1, t2);
//
//        // add the users to the model
//        theModel.addAttribute("travels", travelList);
//
//        return "travel-list";
//    }















}
