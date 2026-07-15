package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private Long  portfolio_id;

    @Column(nullable = false)
    private String portfolio_name;




    @OneToOne
    @JoinColumn(name ="client_id",unique = true)
    private Client client;


    @OneToMany(mappedBy = "portfolio",
               cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<Security> securities = new ArrayList<>();



    public Portfolio() {
    }

    public Portfolio(String portfolio_name, Client client, List<Security> securities) {
        this.portfolio_name = portfolio_name;
        this.client = client;
        this.securities = securities;
    }

    public Long getPortfolio_id() {
        return portfolio_id;
    }



    public String getPortfolio_name() {
        return portfolio_name;
    }

    public void setPortfolio_name(String portfolio_name) {
        this.portfolio_name = portfolio_name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
