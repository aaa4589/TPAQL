package anwer.TP2.exo3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateurAvecException() throws ServiceException {
        // Given
        Utilisateur utilisateur = new Utilisateur("Spark", "Hadoop", "spark@gmail.com");

        // Configuration du comportement du mock
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);


        UserService userService = new UserService(utilisateurApiMock);

        // Then
        assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateur);
        });
    }

    @Test
    public void testCreerUtilisateurAvecErreurValidation() throws ServiceException {
        // Given
        Utilisateur utilisateur = new Utilisateur("", "", "");
        UserService userService = new UserService(utilisateurApiMock);

        // When/Then
        assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateur);
        });

        // Vérifie qu'aucun appel à l'API n'a été fait
        verify(utilisateurApiMock, never()).creerUtilisateur(any(Utilisateur.class));
    }

    @Test
    public void testCreerUtilisateurAvecId() throws ServiceException {
        // Given
        Utilisateur utilisateur = new Utilisateur("Spark", "Hadoop", "spark@gmail.com");
        int idUtilisateur = 123;

        // When
        doReturn(idUtilisateur).when(utilisateurApiMock).creerUtilisateur(utilisateur);

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);

        // Then
        assertEquals(idUtilisateur, utilisateur.getId());
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }

    @Test
    public void testCreerUtilisateurAvecCaptureArguments() throws ServiceException {
        // Given
        Utilisateur utilisateur = new Utilisateur("Spark", "Hadoop", "spark@gmail.com");
        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);

        // When
        doReturn(1).when(utilisateurApiMock).creerUtilisateur(utilisateur);

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);

        // Then
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();

        assertEquals("Spark", utilisateurCapture.getNom());
        assertEquals("Hadoop", utilisateurCapture.getPrenom());
        assertEquals("spark@gmail.com", utilisateurCapture.getEmail());
    }
}