package Model;

import java.math.BigDecimal;

public class Sale {

    private int id;
    private Integer idFatura;
    private Integer idCliente;
    private String nomeCliente;
    private int quantidadeTotal;
    private BigDecimal totalPago;
    private String status;
    private BigDecimal troco;

    public Sale(int id, Integer idFatura, Integer idCliente, String nomeCliente, int quantidadeTotal, BigDecimal totalPago, String status, BigDecimal troco) {
        this.id = id;
        this.idFatura = idFatura;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.quantidadeTotal = quantidadeTotal;
        this.totalPago = totalPago;
        this.status = status;
        this.troco = troco;
    }

    public Sale() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(Integer idFatura) {
        this.idFatura = idFatura;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public BigDecimal getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(BigDecimal totalPago) {
        this.totalPago = totalPago;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTroco() {
        return troco;
    }

    public void setTroco(BigDecimal troco) {
        this.troco = troco;
    }
}
