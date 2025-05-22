package anwer.TP2.exo4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;


import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class JeuIntegrationTest {
    
    @Mock
    private Joueur joueurMock;
    
    @Mock
    private De de1Mock;
    
    @Mock
    private De de2Mock;
    
    @Test
    public void testGainPariAvecBanqueReelle() throws JeuFermeException, DebitImpossibleException {
        // Création d'une banque avec un fond initial de 1000 et un minimum de 500
        BanqueImpl banque = new BanqueImpl(1000, 500);
        
        // Configuration des mocks
        when(joueurMock.mise()).thenReturn(100);
        when(de1Mock.lancer()).thenReturn(3);
        when(de2Mock.lancer()).thenReturn(4);
        
        // Création du jeu
        Jeu jeu = new Jeu(banque);
        
        // Jouer
        jeu.jouer(joueurMock, de1Mock, de2Mock);
        
        // Vérifications
        verify(joueurMock).debiter(100);
        verify(joueurMock).crediter(200);
        assertEquals(900, banque.getFond()); // 1000 - 100 (mise) + 100 (gain) - 200 (paiement)
        assertTrue(jeu.estOuvert()); // La banque est encore solvable
    }
    
    @Test
    public void testBanqueInsolvableApresGainAvecBanqueReelle() throws JeuFermeException, DebitImpossibleException {
        // Création d'une banque avec un fond initial de 300 et un minimum de 500
        BanqueImpl banque = new BanqueImpl(300, 500);
        
        // Configuration des mocks
        when(joueurMock.mise()).thenReturn(100);
        when(de1Mock.lancer()).thenReturn(3);
        when(de2Mock.lancer()).thenReturn(4);
        
        // Création du jeu
        Jeu jeu = new Jeu(banque);
        
        // Jouer
        jeu.jouer(joueurMock, de1Mock, de2Mock);
        
        // Vérifications
        verify(joueurMock).debiter(100);
        verify(joueurMock).crediter(200);
        assertEquals(200, banque.getFond()); // 300 - 100 (mise) + 100 (gain) - 200 (paiement)
        assertFalse(jeu.estOuvert()); // La banque n'est plus solvable
    }
} 