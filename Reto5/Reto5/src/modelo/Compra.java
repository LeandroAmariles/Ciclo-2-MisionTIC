package modelo;

public class Compra {

    private int id;
    private String constructora;
    private String BancoVinculado;

    public Compra(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public String getBancoVinculado() {
        return BancoVinculado;
    }

    public void setBancoVinculado(String bancoVinculado) {
        BancoVinculado = bancoVinculado;
    }
}
