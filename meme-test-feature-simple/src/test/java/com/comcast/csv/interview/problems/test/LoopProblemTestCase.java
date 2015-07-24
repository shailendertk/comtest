package com.comcast.csv.interview.problems.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.comcast.csv.interview.problems.LoopProblem;
import com.comcast.csv.meme.Meme;

public class LoopProblemTestCase {
    private final static Logger LOG = LoggerFactory.getLogger(LoopProblemTestCase.class);

    private LoopProblem problem;
    private List<Meme> memes;
    private String[] tags = {"tag1", "tag2", "tag3"};

    @Before
    public void setUp() throws Throwable {
        LOG.debug("setUp()");
        problem = new LoopProblem();
        memes = new ArrayList<Meme>();

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Meme meme = new Meme();
            meme.setName("meme" + i);
            meme.setYear(random.nextInt(2050) + 1000);
            meme.setTags(tags);
            memes.add(meme);
        }
    }

    @Test
    public void doWhileLoopTest() {
        problem.doWhileLoop(memes);
    }

    @Test
    public void forLoopTest() {
        problem.forLoop(memes);
    }

    @Test
    public void whileLoopTest() {
        problem.whileLoop(memes);
    }

}
