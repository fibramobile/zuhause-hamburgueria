package br.com.brunobrasilweb.springadm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="zuhause_clientes")
public class Customers extends AbstractModel<Long> {

    @Column(name="nome", nullable = false, length = 35)
    private String name;
    
    @Column(name="usuario", nullable = false, length = 40)
    private String user;
    
    @Column(name="senha", nullable = false,  length = 32)
    private String password;
    
    @Column(name="email", nullable = false, length = 40)
    private String email;
    
    @Column(name="rua", nullable = false, length = 100)
    private String street;
    
    @Column(name="numero", nullable = false, length = 10)
    private String number;
    
    @Column(name="bairro", nullable = false, length = 50)
    private String quarter;
    
    @Column(name="cidade", nullable = false, length = 50)
    private String city;
        
    @Column(name="tel", nullable = false, length = 25)
    private String phone;
            
    @Column(name="complemento", nullable = false, length = 200)
    private String complement;

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
