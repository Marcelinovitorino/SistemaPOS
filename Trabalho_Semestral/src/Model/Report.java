
package Model;

import java.math.BigDecimal;

public class Report {
    private int id;
    private int totalVendas;
    private int quantidade;
    private BigDecimal receitaTotal;
    private BigDecimal margemLucro;

    public Report(int id, int totalVendas, int quantidade, BigDecimal receitaTotal, BigDecimal margemLucro) {
        this.id = id;
        this.totalVendas = totalVendas;
        this.quantidade = quantidade;
        this.receitaTotal = receitaTotal;
        this.margemLucro = margemLucro;
    }

    public Report() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(int totalVendas) {
        this.totalVendas = totalVendas;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getReceitaTotal() {
        return receitaTotal;
    }

    public void setReceitaTotal(BigDecimal receitaTotal) {
        this.receitaTotal = receitaTotal;
    }

    public BigDecimal getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(BigDecimal margemLucro) {
        this.margemLucro = margemLucro;
    }
}
