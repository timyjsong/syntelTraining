package mytest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CalciTestCase.class, NewTestCase.class})
public class MyTestSuite {

}
