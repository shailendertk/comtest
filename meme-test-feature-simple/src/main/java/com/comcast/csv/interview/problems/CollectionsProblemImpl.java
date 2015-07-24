package com.comcast.csv.interview.problems;

import com.comcast.csv.meme.Meme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Implement the specified interface.
 */
public class CollectionsProblemImpl implements CollectionsProblem {

    /**
     * Helper class to sort the collection in order of year.
     */
    public static final Comparator<Meme> MEME_COMPARATOR = new Comparator<Meme>() {

        public int compare(Meme meme1, Meme meme2) {
            int year1 = meme1.getYear();
            int year2 = meme2.getYear();
            int retVal = 0;
            if (year1 < year2) {
                retVal = -1;
            } else if (year1 > year2) {
                retVal = 1;
            }
            return retVal;
        }
    };
    private final static Logger LOG = LoggerFactory.getLogger(CollectionsProblemImpl.class);

    /**
     * Sorts a Collection of Memes by year
     *
     * @param memes     The Collection to sort
     * @param ascending true if the collection should be sorting in ascending order, otherwise false.
     */

    public void sort(Collection<Meme> memes, boolean ascending) {
        LOG.debug("sort()");
        Objects.requireNonNull(memes, "Memes collection can't be null");
        List<Meme> sortedMemes = new ArrayList<Meme>(memes);
        LOG.debug("ascending: " + ascending);
        if (ascending) {
            Collections.sort(sortedMemes, MEME_COMPARATOR);
        } else {
            Collections.sort(sortedMemes, Collections.reverseOrder(MEME_COMPARATOR));
        }
        for (Meme meme : sortedMemes) {
            LOG.debug(meme.toString());
        }
    }

    /**
     * Adds a tag to all meme's that contain another tag
     *
     * @param memes The collection of memes to mutate
     * @param tag   The tag that is to be added
     */
    public void addTag(Collection<Meme> memes, String tag) {
        LOG.debug("addTag()");
        Objects.requireNonNull(memes, "Memes collection can't be null");
        Objects.requireNonNull(tag, "New tag can't be null");
        for (Meme meme : memes) {
            String[] tags = meme.getTags();
            if (tags != null && tags.length > 1) {
                ArrayList<String> tagsList = new ArrayList<String>(Arrays.asList(tags));
                tagsList.add(tag);
                String[] updatedTags = new String[tagsList.size()];
                meme.setTags(tagsList.toArray(updatedTags));
            }
        }
    }
}
