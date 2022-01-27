package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutImperial() throws Exception {
        assertThat(queryProcessor.process("Imperial"),
                containsString("university"));
    }

    @Test
    public void knowsTeamName() throws Exception {
        assertThat(queryProcessor.process("your name"),
                containsString("MyTeam"));
    }

    @Test
    public void britainWorks() throws Exception {
        assertThat(queryProcessor.process("which year was Theresa May elected as the Prime Minister of Great Britain"),
                containsString("2016"));
    }

    @Test
    public void minusWorks() throws Exception {
        assertThat(queryProcessor.process("what is 13 minus 10"),
                containsString("3"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }
}
