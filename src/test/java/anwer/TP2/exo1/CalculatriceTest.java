package anwer.TP2.exo1;



import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;



import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CalculatriceTest {

    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionner() {
        // Définition du comportement de la méthode "additionner"
        when(calculatrice.additionner(9, 20)).thenReturn(29);


        // Appel de la méthode à tester
        int resultat = calculatrice.additionner(9, 20);

        // Vérification du résultat
        assertEquals(29, resultat);

        // Vérification que la méthode "additionner" a été appelée avec 2 et 3
        verify(calculatrice).additionner(9, 20);

        // Vérification qu'aucune autre méthode n'a été appelée
        verifyNoMoreInteractions(calculatrice);

        //test d'etat avec spy element
        Calculatrice calculatriceS = new Calculatrice();

        // Crée un spy pour surveiller l'objet réel
        Calculatrice spyCalculatrice = spy(calculatriceS);

        // Appel de la méthode réelle (le code de additionner est exécuté)
        int result2 = spyCalculatrice.additionner(10, 20);
        assertEquals(30, result2);
        // La méthode additionner met à jour l'état interne (result)
        assertEquals(30, spyCalculatrice.getResult());


    }
}
