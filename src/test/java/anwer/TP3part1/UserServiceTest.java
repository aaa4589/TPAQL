package anwer.TP3part1;

import anwer.TP3.User;
import anwer.TP3.UserRepository;
import anwer.TP3.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void testGetUserById() {
        // Arange
        UserRepository userRepositoryMock = mock(UserRepository.class);
        User expectedUser = new User(1L, "Alice");
        when(userRepositoryMock.findUserById(1L)).thenReturn(expectedUser);

        UserService userService = new UserService(userRepositoryMock);

        // Act
        User user = userService.getUserById(1L);

        // Assert
        assertEquals(expectedUser, user);
        verify(userRepositoryMock).findUserById(1L); // Vérifie l'appel
    }
}

