package ee.jaltdorf.veebipood.service;

import ee.jaltdorf.veebipood.dto.OrderRowDto;
import ee.jaltdorf.veebipood.entity.Order;
import ee.jaltdorf.veebipood.entity.OrderRow;
import ee.jaltdorf.veebipood.entity.Person;
import ee.jaltdorf.veebipood.entity.Product;
import ee.jaltdorf.veebipood.repository.OrderRepository;
import ee.jaltdorf.veebipood.repository.PersonRepository;
import ee.jaltdorf.veebipood.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    // @Autowired --> dependency injection
    // @RequiredArgsConstructor --> dependency injection

    private OrderRepository orderRepository;
    private PersonRepository personRepository;
    private ProductRepository productRepository;

    public Order saveOrder(Long personId, String parcelMachine, List<OrderRowDto> orderRows){
        Order order = new Order();
        order.setCreated(new Date());
        order.setParcelMachine(parcelMachine);
        //order.setOrderRows(orderRows);
        Person person = personRepository.findById(personId).orElseThrow(); // kui isikut ei leia --> exception
        order.setPerson(person);
        order.setTotal(calculateOrderTotal(orderRows, order));
        return orderRepository.save(order);
    }

    private double calculateOrderTotal(List<OrderRowDto> orderRows, Order order) {
        double total = 0;
        List<OrderRow> orderRowsInOrder = new ArrayList<>();
        for (OrderRowDto orderRowDto : orderRows) {
            Product product = productRepository.findById(orderRowDto.productId()).orElseThrow();
            total += product.getPrice() * orderRowDto.quantity();

            OrderRow orderRowInOrder = new OrderRow();
            orderRowInOrder.setProduct(product);
            orderRowInOrder.setQuantity(orderRowDto.quantity());
            orderRowsInOrder.add(orderRowInOrder);
        }
        order.setOrderRows(orderRowsInOrder);
        return total;
    }
}
