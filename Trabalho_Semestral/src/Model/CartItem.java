package Model;

public class CartItem {

    private int id;
    private int idFatura;
    private String nomeProduto;
    private String idProduto;
    private String quantidade;
    private String precoUnit;
    private String precoTotal;

    public CartItem() {
    }

    public CartItem(int id, int idFatura, String nomeProduto, String idProduto, String quantidade, String precoUnit, String precoTotal) {
        this.id = id;
        this.idFatura = idFatura;
        this.nomeProduto = nomeProduto;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;
        this.precoTotal = precoTotal;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(String precoUnit) {
        this.precoUnit = precoUnit;
    }

    public String getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(String precoTotal) {
        this.precoTotal = precoTotal;
    }

    @Override
    public String toString() {
        return "CartItem{"
                + "id=" + id
                + ", idFatura=" + idFatura
                + ", nomeProduto='" + nomeProduto + '\''
                + ", idProduto='" + idProduto + '\''
                + ", quantidade='" + quantidade + '\''
                + ", precoUnit='" + precoUnit + '\''
                + ", precoTotal='" + precoTotal + '\''
                + '}';
    }

}
