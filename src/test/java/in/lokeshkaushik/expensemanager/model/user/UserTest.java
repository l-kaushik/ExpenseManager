package in.lokeshkaushik.expensemanager.model.user;

import in.lokeshkaushik.expensemanager.utils.BaseJpaTest;
import in.lokeshkaushik.expensemanager.utils.TestDataFactory;
import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest extends BaseJpaTest {

    @Test
    void testUser() {
        User user = TestDataFactory.createUser();
        User found = PersistAndFetch(User.class, user);

        assertNotNull(found);
        assertEquals(user, found);
        assertNotNull(found.getUserAuth());
        assertNotNull(found.getUserInfo());
        assertNotNull(found.getUsername());
        assertEquals(user.getCreatedAt().truncatedTo(ChronoUnit.MILLIS),
                found.getCreatedAt().truncatedTo(ChronoUnit.MILLIS));
        assertEquals(user.getAccounts().size(), found.getAccounts().size());
//        assertEquals(user.getExpenses().size(), found.getExpenses().size());
    }
}
