package br.com.brunobrasilweb.springadm.service;

import br.com.brunobrasilweb.springadm.model.Order;
import br.com.brunobrasilweb.springadm.model.Status;
import br.com.brunobrasilweb.springadm.repository.OrderRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author João Bonin
 * @since 28/09/2017
 */
@Service
public class OrderService extends AbstractService<Order, Long> {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    public List<Order> findByDateBetweenAndStatus(Date startDate, Date endDate, Status status) {
        return orderRepository.findByDateBetweenAndStatusOrderByDateAsc(startDate, endDate, status);
    }

    /**
     * Método que irá realizar a atualização da coluna de status do pedido.
     *
     * @param orderId - Nº do pedido que será atualizado.
     * @param status - O novo status do pedido.
     */
    public void update(Long orderId, Status status) {
        Order order = orderRepository.findOne(orderId);
        order.setStatus(status);
        orderRepository.save(order);
    }
    /**
     * Método que irá realizar a deleção da base de dados de pedidos
     * toda segunda feira ao meio dia.
     */
//    @Scheduled(cron = "0 0 12 ? * MON *")
//    public void deleteOrdersByCron() {
//        orderRepository.deleteAll();
//    }

}
