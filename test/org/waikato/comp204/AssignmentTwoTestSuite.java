package org.waikato.comp204;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.waikato.comp204.misc.PokemonEncounterTest;
import org.waikato.comp204.misc.PokemonTest;
import org.waikato.comp204.scrollback.GenericScrollbackTest;
import org.waikato.comp204.scrollback.ScrollbackTest;

/**
 * If you add any additional test files, add them to the SuiteClasses
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({PokemonEncounterTest.class, PokemonTest.class, GenericScrollbackTest.class, ScrollbackTest.class})
public class AssignmentTwoTestSuite {}