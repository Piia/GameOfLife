package main.java.game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
    main.java.game.RulesTest.class, 
    main.java.game.FactoryTest.class})
public class GameTestSuite {}
