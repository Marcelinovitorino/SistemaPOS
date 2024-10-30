package Model;

public class Employee {

    private long id;
    private String nome;
    private String numeroTelefone;
  
   

    public Employee() {
    }

    public Employee(long id, String nome, String numeroTelefone) {
        this.id = id;
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        
    }
     public Employee(String nome, String numeroTelefone) {
      
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        
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

 
  
}
