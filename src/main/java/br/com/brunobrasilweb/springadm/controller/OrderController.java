package br.com.brunobrasilweb.springadm.controller;

import br.com.brunobrasilweb.springadm.model.Order;
import br.com.brunobrasilweb.springadm.model.Status;
import br.com.brunobrasilweb.springadm.service.OrderService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe responsavel por controlar os pedidos de requisição e respostas feitas
 * pelo cliente.
 *
 * @author João Bonin
 * @since 28/09/2017
 */
@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String list(Model model) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 0);

        Date startDate = calendar.getTime();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 23);
        calendar1.set(Calendar.MINUTE, 59);
        calendar1.set(Calendar.SECOND, 59);
        calendar1.set(Calendar.MILLISECOND, 0);

        Date endDate = calendar1.getTime();

        List<Order> list = orderService.findByDateBetweenAndStatus(startDate, endDate, Status.IN_QUEUE);

        model.addAttribute("status", Status.values());
        model.addAttribute("statusSelected", Status.IN_QUEUE);
        model.addAttribute("date", new Date());
        model.addAttribute("list", list);

        return "orders/list";

    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String filter(@RequestParam Status status, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, Model model) {

        Calendar startDate = Calendar.getInstance();
        startDate.setTime(date);
        startDate.set(Calendar.HOUR_OF_DAY, 00);
        startDate.set(Calendar.MINUTE, 00);
        startDate.set(Calendar.SECOND, 00);
        startDate.set(Calendar.MILLISECOND, 0);

        Calendar endDate = Calendar.getInstance();
        endDate.setTime(date);
        endDate.set(Calendar.HOUR_OF_DAY, 23);
        endDate.set(Calendar.MINUTE, 59);
        endDate.set(Calendar.SECOND, 59);
        endDate.set(Calendar.MILLISECOND, 0);

        List<Order> list = orderService.findByDateBetweenAndStatus(startDate.getTime(), endDate.getTime(), status);

        model.addAttribute("status", Status.values());
        model.addAttribute("statusSelected", status);
        model.addAttribute("date", date);
        model.addAttribute("list", list);

        return "orders/list";
    }
    
    @RequestMapping(value = "change-status/{orderId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void chengeStatus(@PathVariable Long orderId, @RequestParam Status status){
        orderService.update(orderId, status);
    }
}
