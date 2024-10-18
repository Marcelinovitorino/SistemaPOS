
package Model;

import java.sql.Timestamp;

public class User {

    private int id;
    private String nome;
    private String funcionario;
    private String perfil;
    private String username;
    private String senha;
    private int estado;
    private Timestamp dataCriacao;

   
    public User() {}

  
    public User(int id, String nome, String funcionario, String perfil, String username, String senha, int estado, Timestamp dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.funcionario = funcionario;
        this.perfil = perfil;
        this.username = username;
        this.senha = senha;
        this.estado = estado;
        this.dataCriacao = dataCriacao;
    }

   
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

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Timestamp getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Timestamp dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    // Método para exibir informações do usuário
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numeroTelefone='" + funcionario + '\'' +
                ", perfil='" + perfil + '\'' +
                ", username='" + username + '\'' +
                ", senha='" + senha + '\'' +
                ", estado=" + estado +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
