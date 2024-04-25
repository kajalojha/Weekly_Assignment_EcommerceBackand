package com.TaskManagementSystem.TaskManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_table")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Order_id ;

    @Column(name = "total_Price")
    private  double totalprice;
    @Column(name = "Session_id")
    private String sessionId;
    @Column(name ="order_name")
    private String order_name;

    // Mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    public Cart(){

    }
    public Cart(Integer order_id , double totalprice , String sessionId , String order_name, User user) {
       this.Order_id = order_id;
       this.totalprice = totalprice;
       this.sessionId = sessionId;
       this.order_name=order_name;
       this.user= user;
    }


    public Integer getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(Integer order_id) {
        Order_id = order_id;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Order_id=" + Order_id +
                ", totalprice=" + totalprice +
                ", sessionId='" + sessionId + '\'' +
                ",order_name= "+ order_name + '\''+
                ", user = "+ user + '\''+
                '}';
    }
}
