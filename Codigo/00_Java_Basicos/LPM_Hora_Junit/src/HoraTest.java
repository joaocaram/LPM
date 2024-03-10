import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class HoraTest {

    @Test
    public void criaHoraValidaCorretamente(){
        Hora hora1 = new Hora(12, 23, 10);
        assertTrue(hora1.ehValida());
    }

    @Test
    public void formataCorretamenteHoraCom2Digitos(){
        Hora hora1 = new Hora(20, 10, 10);
        assertEquals("20:10:10", hora1.horaFormatada());
    }

    @Test
    public void formataCorretamenteHoraCom1Digito(){
        Hora hora1 = new Hora(8, 5, 0);
        assertEquals("08:05:00", hora1.horaFormatada());
    }
    
}
