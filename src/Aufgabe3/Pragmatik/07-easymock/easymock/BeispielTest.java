// BeispielTest.java

import static org.easymock.EasyMock.*;

public final class BeispielTest {
    private BeispielTest() { }

    // vom Mock-Objekt zu implementierendes Interface:
    public interface Beispiel {
        boolean methode();
    }

    public static void main(String[] args) {
        // Mock-Objekt erzeugen:
        Beispiel mock = createMock(Beispiel.class);

        // Mock-Verhalten mit interner DSL spezifizieren:
        expect(mock.methode()).andReturn(true).times(2);
        replay(mock);

        // Mock-Objekt benutzen:
        for (String s : args) {
            System.out.println(mock.methode());
        }
        verify(mock);
    }
}

