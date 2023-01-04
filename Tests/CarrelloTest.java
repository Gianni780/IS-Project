import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CarrelloTest {
    private Carrello Cart = new Carrello();
    Articolo a1 = new Articolo("123", 2, "gioco1", 30, "uhwufiouog");
    Articolo a2 = new Articolo("384659", 1, "gioco2", 40, "uhwuofhewroog");

    @BeforeEach
    public void SetUp()
    {
        Cart.SvuotaCarrello();
        Cart.Add(a1);
        Cart.Add(a2);
    }
    @Test
    public void test_CartEmpty()
    {
        Cart.SvuotaCarrello();
        assertTrue(Cart.isEmpty(), "Controllo carrello vuoto");
    }

    @Test
    public void test_CartEmpty2()
    {
        Cart.SvuotaCarrello();
        assertEquals(0, Cart.getGrandezza_tot_carrello(), "COntrollo carrello vuoto 2");
    }

    @Test
    public void test_Cart1Articolo()
    {
        Cart.Remove(a1);
        assertEquals(1, Cart.getGrandezza_tot_carrello(), "Controllo rimozione un articolo");
    }

    @Test
    public void test_CartPrezzototale()
    {
        int prezzotot = 0;
        for(int i = 0; i < Cart.getGrandezza_tot_carrello(); i++)
        {
            prezzotot += Cart.GetAll().get(i).getPrezzo();
        }
        assertEquals(prezzotot, Cart.getPrezzo_Tot_carrello(), "Controllo prezzo totale giusto");
    }

    @AfterAll
    public static void SetOff()
    {
        System.out.println("Test finiti");
    }

}