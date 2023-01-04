import java.util.ArrayList;

public class Carrello implements Lista{
    private ArrayList<Articolo> Articoli;
    private int Grandezza_tot_carrello;
    private double Prezzo_Tot_carrello;


    public Carrello(ArrayList<Articolo> articoli, int grandezza_tot_carrello, double prezzo_Tot_carrello) {
        Articoli = articoli;
        Grandezza_tot_carrello = articoli.size();
        Prezzo_Tot_carrello = 0;
        for(int i = 0; i < articoli.size(); i++)
        {
            Prezzo_Tot_carrello += articoli.get(i).getPrezzo();
        }
    }

    public Carrello()
    {
        Articoli = new ArrayList<Articolo>();
        setPrezzo_Tot_carrello(0);
        setGrandezza_tot_carrello(0);
    }

    public int getGrandezza_tot_carrello() {
        return Grandezza_tot_carrello;
    }

    public double getPrezzo_Tot_carrello() {
        return Prezzo_Tot_carrello;
    }


    @Override
    public void Add(Articolo a) {
        Articoli.add(a);
        Grandezza_tot_carrello ++;
        Prezzo_Tot_carrello += a.getPrezzo();
    }

    @Override
    public void Remove(Articolo a) {
        Articoli.remove(a);
        setGrandezza_tot_carrello(getGrandezza_tot_carrello() - 1);
        setPrezzo_Tot_carrello(getPrezzo_Tot_carrello() - a.getPrezzo());
    }

    @Override
    public Articolo Get(String s) {
        for(int i = 0; i < Articoli.size(); i++)
        {
            if(Articoli.get(i).getID_articolo().equals(s) || Articoli.get(i).getNome_articolo().equals(s))
                return Articoli.get(i);

        }
        return null;
    }

    public void SvuotaCarrello()
    {
        Articoli.removeAll(Articoli);
        setGrandezza_tot_carrello(0);
        setPrezzo_Tot_carrello(0);
    }

    private void setGrandezza_tot_carrello(int grandezza_tot_carrello) {
        Grandezza_tot_carrello = grandezza_tot_carrello;
    }

    private void setPrezzo_Tot_carrello(double prezzo_Tot_carrello) {
        Prezzo_Tot_carrello = prezzo_Tot_carrello;
    }

    public boolean isEmpty()
    {return getGrandezza_tot_carrello() == 0;}

    public ArrayList<Articolo> GetAll()
    {return Articoli;}
}
