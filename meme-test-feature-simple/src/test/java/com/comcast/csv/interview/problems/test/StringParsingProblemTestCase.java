package com.comcast.csv.interview.problems.test;

import com.comcast.csv.interview.problems.StringParsingProblem;
import com.comcast.csv.meme.Meme;
import com.comcast.csv.meme.YoureDoingItWrongException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class StringParsingProblemTestCase {
    private final static Logger LOG = LoggerFactory.getLogger(StringParsingProblemTestCase.class);

    private StringParsingProblem problem;

    @Before
    public void setUp() throws Throwable {
        LOG.debug("setUp()");
        problem = new StringParsingProblem();
    }

    @Test(expected = NullPointerException.class)
    public void nullAddressTest() throws YoureDoingItWrongException {
        LOG.debug("nullAddressTest()");
        problem.isAddressValid(null);
    }

    @Test
    public void validAddressTest() throws YoureDoingItWrongException {
        LOG.debug("validAddressTest()");
        boolean isValid = problem.isAddressValid("25w873 Apple St.");
        assertTrue(isValid);
    }

    @Test
    public void inValidAddressTest() throws YoureDoingItWrongException {
        LOG.debug("inValidAddressTest()");
        boolean isValid = problem.isAddressValid("25w873aApplesSt.");
        assertFalse(isValid);
    }

    @Test(expected = NullPointerException.class)
    public void getDistanceFromCityCenterWithNullAddressTest() throws YoureDoingItWrongException {
        LOG.debug("getDistanceFromCityCenterWithNullAddressTest()");
        problem.getDistanceFromCityCenter(null);
    }

    @Test
    public void getDistanceFromCityCenterTest() throws YoureDoingItWrongException {
        LOG.debug("getDistanceFromCityCenterTest()");
        int dist = problem.getDistanceFromCityCenter("25w873 Apple St.");
        LOG.debug("dist: " + dist);
        assertNotNull(Integer.valueOf(dist));
    }
}
