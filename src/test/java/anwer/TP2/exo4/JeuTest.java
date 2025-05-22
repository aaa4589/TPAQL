package anwer.TP2.exo4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;



import org.mockito.Mock;


import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class JeuTest {
    
    @Mock
    private Banque banqueMock;
    
    @Mock
    private Joueur joueurMock;
    
    @Mock
    private De de1Mock;
    
    @Mock
    private De de2Mock;

    @Test
    public void testJeuFerme() throws DebitImpossibleException {
        // Création du jeu
        Jeu jeu = new Jeu(banqueMock);

        // Fermeture du jeu
        jeu.fermer();

        // Vérifie que l'exception est bien levée
        assertThrows(JeuFermeException.class, () -> {
            jeu.jouer(joueurMock, de1Mock, de2Mock);
        });
    }


    @Test
    public void testJoueurInsolvable() throws JeuFermeException, DebitImpossibleException {
        // Configuration des mocks
        when(joueurMock.mise()).thenReturn(100);
        doThrow(new DebitImpossibleException()).when(joueurMock).debiter(100);
        
        // Création du jeu
        Jeu jeu = new Jeu(banqueMock);
        
        // Tentative de jouer
        jeu.jouer(joueurMock, de1Mock, de2Mock);
        
        // Vérification que les dés n'ont pas été utilisés
        verify(de1Mock, never()).lancer();
        verify(de2Mock, never()).lancer();
    }
    
    @Test
    public void testPertePari() throws JeuFermeException, DebitImpossibleException {
        // Configuration des mocks
        when(joueurMock.mise()).thenReturn(100);
        when(de1Mock.lancer()).thenReturn(2);
        when(de2Mock.lancer()).thenReturn(3);
        
        // Création du jeu
        Jeu jeu = new Jeu(banqueMock);
        
        // Jouer
        jeu.jouer(joueurMock, de1Mock, de2Mock);
        
        // Vérifications
        verify(joueurMock).debiter(100);
        verify(banqueMock).crediter(100);
        verify(joueurMock, never()).crediter(anyInt());
    }
    
    @Test
    public void testGainPari() throws JeuFermeException, DebitImpossibleException {
        // Configuration des mocks
        when(joueurMock.mise()).thenReturn(100);
        when(de1Mock.lancer()).thenReturn(3);
        when(de2Mock.lancer()).thenReturn(4);
        when(banqueMock.est_solvable()).thenReturn(true);
        
        // Création du jeu
        Jeu jeu = new Jeu(banqueMock);
        
        // Jouer
        jeu.jouer(joueurMock, de1Mock, de2Mock);
        
        // Vérifications
        verify(joueurMock).debiter(100);
        verify(banqueMock).crediter(100);
        verify(joueurMock).crediter(200);
        verify(banqueMock).debiter(200);
    }
    
    @Test
    public void testBanqueInsolvableApresGain() throws JeuFermeException, DebitImpossibleException {
        // Configuration des mocks
        when(joueurMock.mise()).thenReturn(100);
        when(de1Mock.lancer()).thenReturn(3);
        when(de2Mock.lancer()).thenReturn(4);
        when(banqueMock.est_solvable()).thenReturn(false);
        
        // Création du jeu
        Jeu jeu = new Jeu(banqueMock);
        
        // Jouer
        jeu.jouer(joueurMock, de1Mock, de2Mock);
        
        // Vérifications
        verify(joueurMock).debiter(100);
        verify(banqueMock).crediter(100);
        verify(joueurMock).crediter(200);
        verify(banqueMock).debiter(200);
        assertFalse(jeu.estOuvert());
    }
} 