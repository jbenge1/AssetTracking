package com.assetTracking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    
    @Autowired
    AssetDAO assetDAO;

    @RequestMapping("/")
    public String home() {    	
        return "index";
    }


    @RequestMapping("EmployeeList")
    public ModelAndView getEmployeeRecords() {
        List<Employee> list = new ArrayList<>();
        list = assetDAO.getAllEmployeeRecords();
        return new ModelAndView("employeeList", "employee", list);
    }
    
    @RequestMapping("AssetList")
    public ModelAndView getAssetRecords() {
    	List<Asset> list = new ArrayList<>();
    	list = assetDAO.getAllAssetRecords();
    	return new ModelAndView("assetList", "asset", list);
    }
    
    @RequestMapping("LoanList")
    public ModelAndView getLoanRecords() {
    	List<Loan> list = new ArrayList<>();
    	list = assetDAO.getAllLoanRecords();
    	return new ModelAndView("loanList", "loan", list);
    }
    
//#####################################################################################################################
    //The following is the contoller seciton for inserting into the DB
    // The following is a decent template for extracting information from a 
    // from inside a jsp....
    //=============================================================================================
    
    //not entirely sure what this does just yet...
    @ModelAttribute("employee")
    public Employee setUpEmployeeForm() {
    	return new Employee();
    }
    
    //This is a normal mapping to the addEmployeeForm.jsp
    @GetMapping("EmployeeAddForm")
    public String addEmployeeForm() {
    	return "addEmployeeForm";
    }
    //Here is where the fun happens
    @PostMapping("addEmployee") //Post mapping tells spring (or something idk...) that we are posting...
    public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee, Model model) {
    	//Again not sure what the model attribute tag is for
    	//but we are passed in a new employee that was created (somewhere)
    	assetDAO.addEmployee(employee);
    	
    	List<Employee> list = new ArrayList<>();
        list = assetDAO.getAllEmployeeRecords();
        return new ModelAndView("employeeList", "employee", list);
    	
    }//============================================================================================
    
    //LOAN ADD CONTROLLERS
    @ModelAttribute("loan")
    public Loan setUpLoanForm() {
    	return new Loan();
    }
    
    @GetMapping("LoanAddForm")
    public String addLoanForm(){
    	return "addLoanForm";
    }
    
    @PostMapping("addLoan")
    public ModelAndView addLoan(@ModelAttribute("loan") Loan loan, Model model) {
    	String flag = assetDAO.addLoan(loan);
    	
    	if(!flag.equals("loanList"))
    		return new ModelAndView(flag, "", null);
    	List<Loan> list = new ArrayList<>();
    	list = assetDAO.getAllLoanRecords();
    	return new ModelAndView("loanList", "loan", list);
    	
    }
    
    //LOAN DELETE FORMS
    @ModelAttribute("loan")
    public Loan deleteLoan() {
    	return new Loan();
    }
    
    @GetMapping("LoanDelForm")
    public String loanDelForm() {
    	return "delLoanForm";
    }
    
    @PostMapping("removeLoan")
    public ModelAndView ModelAndView(@ModelAttribute("loan") Loan loan, Model model) {
    	assetDAO.removeLoan(loan);
    	List<Loan> list = new ArrayList<>();
    	list = assetDAO.getAllLoanRecords();
    	return new ModelAndView("loanList","loan", list);
    }
    
    
//#####################################################################################################################
}
