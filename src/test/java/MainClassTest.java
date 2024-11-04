import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
import static org.example.Main.*;

public class MainClassTest {

    @Test
    public void testMainMethod_postcode_invalid() {

        String maandInkomenInput = "3000\n";
        String studieschuldInput = "500\n";
        String postcodeInput = "1234\n";
        String partnerInput = "ja\n";
        String rentevasteInput = "5\n";

        String simulatedInput = maandInkomenInput +
                studieschuldInput +
                postcodeInput +
                rentevasteInput +
                partnerInput;


        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        main(new String[]{});

        String consoleOutput = out.toString();

        assertTrue(consoleOutput.contains("je maandinkomen: 3000"));
        assertTrue(consoleOutput.contains("je studieschuld: 500"));
        assertFalse(consoleOutput.contains("postcode: 654")); //except dat die false is en daarom pass de test
        assertTrue(consoleOutput.contains("heb je een partner: ja"));
        assertTrue(consoleOutput.contains("Maximaal lenen: 229500.0"));
    }

    @Test
    public void testMainMethod_studieschuld_invalid() {
        String maandInkomenInput = "3000\n";
        String studieschuldInput = "300\n";
        String postcodeInput = "1234\n";
        String partnerInput = "ja\n";
        String rentevasteInput = "5\n";

        String simulatedInput = maandInkomenInput +
                studieschuldInput +
                postcodeInput +
                rentevasteInput +
                partnerInput;

        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        main(new String[]{});

        String consoleOutput = out.toString();

        assertTrue(consoleOutput.contains("je maandinkomen: 3000"));
        assertFalse(consoleOutput.contains("je studieschuld: 777"));
        assertTrue(consoleOutput.contains("je postcode: 1234"));
        assertTrue(consoleOutput.contains("heb je een partner: ja"));
        assertTrue(consoleOutput.contains("Maximaal lenen: 229500.0"));
    }

    @Test
    public void testMainMethod_partnerInput_invalid() {
        String maandInkomenInput = "3000\n";
        String studieschuldInput = "500\n";
        String postcodeInput = "1234\n";
        String partnerInput = "ja\n";
        String rentevasteInput = "5\n";


        String simulatedInput = maandInkomenInput +
                studieschuldInput +
                postcodeInput +
                rentevasteInput +
                partnerInput;


        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));


        main(new String[]{});


        String consoleOutput = out.toString();

        assertTrue(consoleOutput.contains("je maandinkomen: 3000"));
        assertTrue(consoleOutput.contains("je studieschuld: 500"));
        assertTrue(consoleOutput.contains("je postcode: 1234"));
        assertFalse(consoleOutput.contains("Nee"));
        assertTrue(consoleOutput.contains("Maximaal lenen: 229500.0"));
    }

    @Test
    public void testMainMethod_rentevasteInput_invalid() {
        String maandInkomenInput = "3000\n";
        String studieschuldInput = "500\n";
        String postcodeInput = "1234\n";
        String partnerInput = "ja\n";
        String rentevasteInput = "5\n";


        String simulatedInput = maandInkomenInput +
                studieschuldInput +
                postcodeInput +
                rentevasteInput +
                partnerInput;


        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));


        main(new String[]{});


        String consoleOutput = out.toString();

        assertTrue(consoleOutput.contains("je maandinkomen: 3000"));
        assertTrue(consoleOutput.contains("je studieschuld: 500"));
        assertTrue(consoleOutput.contains("je postcode: 1234"));
        assertTrue(consoleOutput.contains("heb je een partner: ja"));
        assertFalse(consoleOutput.contains("9999"));
    }


    @Test
    public void testMainMethod_passed() {
        String maandInkomenInput = "3000\n";
        String studieschuldInput = "500\n";
        String postcodeInput = "1234\n";
        String partnerInput = "ja\n";
        String rentevasteInput = "5\n";


        String simulatedInput = maandInkomenInput +
                studieschuldInput +
                postcodeInput +
                rentevasteInput +
                partnerInput;


        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));


        main(new String[]{});


        String consoleOutput = out.toString();

        assertTrue(consoleOutput.contains("je maandinkomen: 3000"));
        assertTrue(consoleOutput.contains("je studieschuld: 500"));
        assertTrue(consoleOutput.contains("je postcode: 1234"));
        assertTrue(consoleOutput.contains("heb je een partner: ja"));
        assertTrue(consoleOutput.contains("Maximaal lenen: 229500.0"));
    }

}