package ee.jaltdorf.veebipood.controller;

import ee.jaltdorf.veebipood.dto.OrderRowDto;
import ee.jaltdorf.veebipood.entity.Order;
import ee.jaltdorf.veebipood.entity.OrderRow;
import ee.jaltdorf.veebipood.entity.Person;
import ee.jaltdorf.veebipood.repository.OrderRepository;
import ee.jaltdorf.veebipood.repository.PersonRepository;
import ee.jaltdorf.veebipood.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class OrderController {

    private OrderRepository orderRepository;
    private OrderService orderService;



    @GetMapping("orders")
    public List<Order> getOrder(){
        return orderRepository.findAll();
    }

    @DeleteMapping("orders/{id}")
    public List<Order> deleteOrder(@PathVariable Long id){
        orderRepository.deleteById(id); //kustutab
        return orderRepository.findAll(); //siin on uuenenud seis
    }

    @PostMapping("orders")
    public Order addOrder(@RequestParam Long personId,
                                @RequestParam(required = false) String parcelMachine,
                                @RequestBody List<OrderRowDto> orderRows){
        return orderService.saveOrder(personId, parcelMachine, orderRows); //siin salvestab
        //return orderRepository.findAll(); //siin on uuenenud seis
    }

}
