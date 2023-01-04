public class Articolo {
    private String ID_articolo;
    private int Quantita_articolo;
    private String Nome_articolo;
    private double Prezzo;
    private String KEY;

    public Articolo(String ID_articolo, int quantita_articolo, String nome_articolo, double prezzo, String KEY) {
        this.ID_articolo = ID_articolo;
        Quantita_articolo = quantita_articolo;
        Nome_articolo = nome_articolo;
        Prezzo = prezzo;
        this.KEY = KEY;
    }

    public String getID_articolo() {
        return ID_articolo;
    }

    public int getQuantita_articolo() {
        return Quantita_articolo;
    }

    public String getNome_articolo() {
        return Nome_articolo;
    }

    public double getPrezzo() {
        return Prezzo;
    }

    public String getKEY() {
        return KEY;
    }

    public void setID_articolo(String ID_articolo) {
        this.ID_articolo = ID_articolo;
    }

    public void setQuantita_articolo(int quantita_articolo) {
        Quantita_articolo = quantita_articolo;
    }

    public void setNome_articolo(String nome_articolo) {
        Nome_articolo = nome_articolo;
    }

    public void setPrezzo(double prezzo) {
        Prezzo = prezzo;
    }

    public void setKEY(String KEY) {
        this.KEY = KEY;
    }

    public boolean isEmpty()
    {
        return getQuantita_articolo() == 0;
    }
}
