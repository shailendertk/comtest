package com.comcast.csv.interview.problems.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.comcast.csv.interview.problems.CollectionsProblem;
import com.comcast.csv.interview.problems.CollectionsProblemImpl;
import com.comcast.csv.meme.Meme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class CollectionsProblemTestCase {

    private final static Logger LOG = LoggerFactory.getLogger(CollectionsProblemTestCase.class);
    private Collection<Meme> memes;
    private CollectionsProblem collectionsProblem;
    private String[] tags = {"tag1", "tag2", "tag3"};

    @Before
    public void setUp() throws Throwable {
        LOG.debug("setUp()");

        collectionsProblem = new CollectionsProblemImpl();
        memes = new ArrayList<Meme>();

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Meme meme = new Meme();
            meme.setName("meme" + i);
            meme.setYear(random.nextInt(2050) + 1000);
            if (i % 2 == 0) {
                meme.setTags(tags);
            }
            memes.add(meme);
        }

        for (Meme meme : memes) {
            LOG.debug(meme.toString());
        }
    }

    @Test
    public void addTagTest() {
        LOG.debug("addTagTest()");
        collectionsProblem.addTag(memes, "newtag");
        for (Meme meme : memes) {
            LOG.debug(meme.toString());
            if (meme.getTags() != null) {
                assertTrue("Expected, tag size of meme from collection is greater than original tags.", (meme.getTags().length > tags.length));
            }
        }
    }

    @Test(expected = NullPointerException.class)
    public void nullTagAddTagTest() {
        LOG.debug("nullTagAddTagTest()");
        collectionsProblem.addTag(memes, null);
    }

    @Test(expected = NullPointerException.class)
    public void nullListAddTagTest() {
        LOG.debug("nullListAddTagTest()");
        collectionsProblem.addTag(null, "atag");
    }

    @Test
    public void sortTestAsc() {
        LOG.debug("sortTestAsc()");
        collectionsProblem.sort(memes, true);
        assertNotNull(memes);
    }

    @Test
    public void sortTestDsc() {
        LOG.debug("sortTestDsc()");
        collectionsProblem.sort(memes, false);
        assertNotNull(memes);
    }

    @Test(expected = NullPointerException.class)
    public void nullListSortTestAsc() {
        LOG.debug("nullListSortTestAsc()");
        collectionsProblem.sort(null, true);
        assertNotNull(memes);
    }

}
