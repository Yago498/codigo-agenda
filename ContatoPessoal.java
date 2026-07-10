package model;

public class ContatoPessoal extends Contato implements Favoritavel {

    private boolean favorito;

    public ContatoPessoal(String nome, String telefone, boolean favorito) {
        super(nome, telefone);
        this.favorito = favorito;
    }

    @Override
    public String getTipo() {
        return "Pessoal";
    }

    @Override
    public void favoritar() {
        this.favorito = true;
    }

    @Override
    public boolean isFavorito() {
        return favorito;
    }

    @Override
    public String toString() {
        String estrela = favorito ? " ★" : "";
        return super.toString() + estrela;
    }
}
