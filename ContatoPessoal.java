package model;

public class ContatoProfissional extends Contato {

    private String empresa;

    public ContatoProfissional(String nome, String telefone, String empresa) {
        super(nome, telefone);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    @Override
    public String getTipo() {
        return "Profissional";
    }

    @Override
    public String toString() {
        return super.toString() + " - " + empresa;
    }
}
