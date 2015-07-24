package com.comcast.csv.interview.problems.test;

import com.comcast.csv.interview.problems.PojoAlgProblem;
import com.comcast.csv.meme.YoureDoingItWrongException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

import static org.junit.Assert.*;

public class PojoAlgProblemTestCase {
    private final static Logger LOG = LoggerFactory.getLogger(PojoAlgProblemTestCase.class);

    private PojoAlgProblem problem;
    private Rectangle inner;
    private Rectangle outer;

    @Before
    public void setUp() throws Throwable {
        LOG.debug("setUp()");
        problem = new PojoAlgProblem();
    }

    @Test(expected = NullPointerException.class)
    public void bottomRightNullTest() throws YoureDoingItWrongException {
        LOG.debug("bottomRightNullTest()");
        problem.bottomRight(null, null);
    }

    @Test
    public void validBottomRightTest() throws YoureDoingItWrongException {
        LOG.debug("validBottomRightTest()");
        inner = new Rectangle(1,1,2,1);//(1,1,1,1);
        outer = new Rectangle(0,0,3,2);//(0,0,2,2);
        problem.bottomRight(inner, outer);
        assertTrue(problem.isBottomRight());
    }

    @Test
    public void inValidBottomRightTest() throws YoureDoingItWrongException {
        LOG.debug("inValidBottomRightTest()");
        inner = new Rectangle(1,1,3,2);//(2,2,2,1);
        outer = new Rectangle(0,0,3,2);
        problem.bottomRight(inner, outer);
        assertFalse(problem.isBottomRight());
    }

    @Test(expected = NullPointerException.class)
    public void middleCenterNullTest() throws YoureDoingItWrongException {
        LOG.debug("middleCenterNullTest()");
        problem.middleCenter(null, null);
    }

    @Test
    public void validMiddleCenterTest() throws YoureDoingItWrongException {
        LOG.debug("validMiddleCenterTest()");
        inner = new Rectangle(2,7,2,1);//(1,1,3,2);
        outer = new Rectangle(1,6,4,3);//(0,0,5,4);
        problem.middleCenter(inner, outer);
        assertTrue(problem.isMiddleCenter());
    }

    @Test
    public void inValidMiddleCenterTest() throws YoureDoingItWrongException {
        LOG.debug("inValidMiddleCenterTest()");
        inner = new Rectangle(3,2,2,1);//(2,1,2,1);
        outer = new Rectangle(1,1,4,3);//(0,0,5,4);
        problem.middleCenter(inner, outer);
        assertFalse(problem.isMiddleCenter());
    }
}
