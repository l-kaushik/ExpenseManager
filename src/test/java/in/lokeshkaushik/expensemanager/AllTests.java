package in.lokeshkaushik.expensemanager;

import in.lokeshkaushik.expensemanager.model.user.UserIntegratedTest;
import in.lokeshkaushik.expensemanager.model.user.UserTest;
import org.junit.platform.suite.api.*;

@Suite
@SelectClasses({
        UserTest.class,
        UserIntegratedTest.class
})

public class AllTests {
}
