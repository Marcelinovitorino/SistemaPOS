package Model;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String nome;
    private String marca;
    private BigDecimal preco;
    private int quantidade;
    private int idFornecedor;
    private String lote;

    public Product(int id, String nome, String marca, BigDecimal preco, int quantidade, int idFornecedor, String lote) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.quantidade = quantidade;
        this.idFornecedor = idFornecedor;
        this.lote = lote;
    }

    public Product() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
}
