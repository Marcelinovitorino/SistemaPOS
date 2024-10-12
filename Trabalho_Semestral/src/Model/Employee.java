package Model;

public class Employee {

    private long id;
    private String nome;
    private String numeroTelefone;
    private int estado;
    private String dataCriacao;

    public Employee() {
    }

    public Employee(long id, String nome, String numeroTelefone, int estado, String dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.estado = estado;
        this.dataCriacao = dataCriacao;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
