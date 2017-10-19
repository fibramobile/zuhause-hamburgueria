package br.com.brunobrasilweb.springadm.controller;

import br.com.brunobrasilweb.springadm.model.Customers;
import br.com.brunobrasilweb.springadm.service.CustomersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    private CustomersService customerService;

    @Autowired
    public void setCustomerService(CustomersService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers")
    public String index() {
        return "redirect:/customers/1";
    }

    @RequestMapping(value = "/customers/{pageNumber}", method = RequestMethod.GET)
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Customers> page = customerService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("showPaginator", true);

        return "customers/list";

    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam(name = "q") String query, Model model) {

        if (!query.equals("")) {
            List<Customers> list = customerService.findCustomerByPhone(query);

            model.addAttribute("list", list);
            model.addAttribute("showPaginator", false);

            return "customers/list";
        }

        return "redirect:customers";
    }
}
