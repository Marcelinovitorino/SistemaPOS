package Model;

public class Extra {

    private int id;
    private String val;

    public Extra() {
    }

    public Extra(int id, String val) {
        this.id = id;
        this.val = val;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
