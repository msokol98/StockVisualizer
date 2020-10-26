package io.sokol.stockvisualizer.entity;

import javax.persistence.*;

@Entity
public class UserStock {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Portfolio portfolio;

    @ManyToOne
    private StockDay buyDay;

    @ManyToOne
    private StockDay sellDay;

    public long getId() {
        return id;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public StockDay getBuyDay() {
        return buyDay;
    }

    public void setBuyDay(StockDay buyDay) {
        this.buyDay = buyDay;
    }

    public StockDay getSellDay() {
        return sellDay;
    }

    public void setSellDay(StockDay sellDay) {
        this.sellDay = sellDay;
    }
}
