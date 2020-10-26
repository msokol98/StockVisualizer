package io.sokol.stockvisualizer.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "portfolio")
    private List<UserStock> stocks;

    private BigDecimal moneyInvested;
    private BigDecimal currentValue;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserStock> getStocks() {
        return stocks;
    }

    public BigDecimal getMoneyInvested() {
        return moneyInvested;
    }

    public void setMoneyInvested(BigDecimal moneyInvested) {
        this.moneyInvested = moneyInvested;
    }

    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(BigDecimal currentValue) {
        this.currentValue = currentValue;
    }

    public void addStock(UserStock userStock) {
        stocks.add(userStock);
    }
    public void removeStock(UserStock userStock) {
        stocks.remove(userStock);
    }

}
