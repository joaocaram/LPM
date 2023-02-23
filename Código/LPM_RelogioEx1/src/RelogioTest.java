import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RelogioTest {
    
    Relogio meuRelogio;

    @BeforeEach
    public void prepare(){
        meuRelogio = new Relogio();
        meuRelogio.ajustarHora(6, 5, 12);
    }

    @Test
    public void deveFormatarCom24horas(){
         assertEquals("06:05:12", meuRelogio.horaFormatada());        
    }

    @Test
    public void deveFormatarComAM(){
        assertEquals("06:05:12 AM", meuRelogio.horaFormatadaAMPM()); 
    }

    @Test
    public void deveFormatarMeioDiaComPM(){
        meuRelogio.ajustarHora(12, 0, 0);
        assertEquals("12:00:00 PM", meuRelogio.horaFormatadaAMPM()); 
    }

    @Test
    public void deveFormatarMeiaNoiteComAM(){
        meuRelogio.ajustarHora(0, 0, 0);
        assertEquals("12:00:00 AM", meuRelogio.horaFormatadaAMPM()); 
    }

    @Test
    public void deveFormatarComPM(){
        meuRelogio.ajustarHora(18, 0, 0);
        assertEquals("06:00:00 PM", meuRelogio.horaFormatadaAMPM()); 
    }
}
