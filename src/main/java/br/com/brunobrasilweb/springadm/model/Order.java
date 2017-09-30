package br.com.brunobrasilweb.springadm.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Tabela referente aos pedidos feitos pelos
 * clientes
 * 
 * @author João Bonin
 * 
 * @since 28/09/2017
 */
@Entity(name = "zuhause_pedidos")
public class Order extends AbstractModel<Long>{
    
    @Column(name="usuario", nullable = false, length = 20)
    private String user;
    
    @Column(name="telefone", nullable = false, length = 20)
    private String phone;
    
    @Column(name="pedido", nullable = false, length = 400)
    private String order;
    
    @Column(name="total", nullable = false, length = 15)
    private String total;
    
    @Column(name="pagamento", nullable = false, length = 40)
    private String payment;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data")
    private Date date;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
