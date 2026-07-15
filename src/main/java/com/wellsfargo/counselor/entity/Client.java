package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;


@Entity
public class Client {

    @Id
    @GeneratedValue()
    private Long client_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone_no;




    @ManyToOne
    @JoinColumn(name="advisor_id")
    private Advisor advisor;


    @OneToOne(mappedBy = "client",
               cascade = CascadeType.ALL,
                orphanRemoval = true)
    private Portfolio portfolio;


    public Client() {
    }

    public Client(String name, String last_name, String email, String address, String phone_no, Advisor advisor, Portfolio portfolio) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.phone_no = phone_no;
        this.advisor = advisor;
        this.portfolio = portfolio;
    }

    public Long getId() {
        return client_id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
