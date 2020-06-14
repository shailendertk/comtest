package com.comcast.csv.interview.problems.test;

import com.comcast.csv.interview.problems.FileJsonResourceProblem;
import com.comcast.csv.meme.Meme;
import com.comcast.csv.meme.YoureDoingItWrongException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FileJsonResourceProblemTestCase {
    private final static Logger LOG = LoggerFactory.getLogger(FileJsonResourceProblemTestCase.class);

    private FileJsonResourceProblem problem;

    @Before
    public void setUp() throws Throwable {
        LOG.debug("setUp()");
        problem = new FileJsonResourceProblem();
    }


    @Test
    public void readFromFileTest() throws YoureDoingItWrongException {
        LOG.debug("readFromFileTest()");
//        List<Meme> memes = problem.readFromFile(new File("/workspace/meme-test-feature-simple/src/test/resources/memes.json"));
        List<Meme> memes = problem.readFromFile(new File("src/test/resources/memes.json"));
        assertNotNull(memes);
        for (Meme meme : memes) {
            LOG.debug(meme.toString());
        }
    }

    @Test(expected = NullPointerException.class)
    public void readFromNullFileTest() throws YoureDoingItWrongException {
        LOG.debug("readFromNullFileTest()");
        problem.readFromFile(null);
    }

    @Test
    public void readFromClasspathTest() throws YoureDoingItWrongException {
        LOG.debug("readFromClasspathTest()");
        List<Meme> memes = problem.readFromClasspath("memes.json");
        assertNotNull(memes);
        for (Meme meme : memes) {
            LOG.debug(meme.toString());
        }
    }

    @Test(expected = NullPointerException.class)
    public void readFromNullClasspathTest() throws YoureDoingItWrongException {
        LOG.debug("readFromNullClasspathTest()");
        problem.readFromClasspath(null);
    }
}
