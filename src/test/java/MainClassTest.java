import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
import static org.example.Main.*;

public class MainClassTest {

    @Test
    public void testMainMethod() {
        // Simuleer invoer voor elke prompt apart
        String maandInkomenInput = "3000\n";    // Maandinkomen invoer
        String studieschuldInput = "500\n";     // Studieschuld invoer
        String postcodeInput = "1234\n";        // Postcode invoer
        String rentevasteInput = "5\n";         // Rentevaste periode invoer
        String partnerInput = "ja\n";           // Partner invoer

        // Combineer de invoer voor de test
        String simulatedInput = maandInkomenInput +
                studieschuldInput +
                postcodeInput +
                rentevasteInput +
                partnerInput;

        // Injecteer de gesimuleerde invoer
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        // Redirect de output om deze later te kunnen controleren
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Roep de main methode aan
        main(new String[]{});

        // Controleer de output van de console
        String consoleOutput = out.toString();

        assertTrue(consoleOutput.contains("U heeft een geldig maandinkomen ingevoerd: 3000"));
        assertTrue(consoleOutput.contains("U heeft een geldig studie inkomen ingevoerd: 500"));
        assertTrue(consoleOutput.contains("Maximaal lenen"));
        assertTrue(consoleOutput.contains("Maandelijkse intrest"));
        assertTrue(consoleOutput.contains("maandelijkse betaling"));
    }
}