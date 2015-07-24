package com.comcast.csv.interview.problems;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import com.comcast.csv.meme.Meme;
import com.comcast.csv.meme.YoureDoingItWrongException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Read a list of {@link Meme}s from a JSON source file that might be on the classpath or file system.
 */
public class FileJsonResourceProblem {

    private final static Logger LOG = LoggerFactory.getLogger(FileJsonResourceProblem.class);

    /**
     * Read a list of memes from a JSON file stored on the filesystem
     *
     * @param file the file to read
     * @return the list of memes read
     */

    public List<Meme> readFromFile(File file) throws YoureDoingItWrongException {
        LOG.debug("readFromFile()");
        Objects.requireNonNull(file, "File object can't be null");
        JSONParser parser = new JSONParser();
        List<Meme> memes = new ArrayList<Meme>();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(file));
        } catch (IOException ioe) {
            throw new YoureDoingItWrongException(ioe.getMessage(), ioe.getCause());
        } catch (ParseException pe) {
            throw new YoureDoingItWrongException(pe.getMessage(), pe.getCause());
        }
        return prepareMemeList(obj);
    }

    /**
     * Read a list of memes from a JSON file stored on the classpath
     *
     * @param path the path to the resource
     * @return the list of memes read
     */
    public List<Meme> readFromClasspath(String path) throws YoureDoingItWrongException {
        LOG.debug("readFromClasspath()");
        Objects.requireNonNull(path, "File path can't be null");
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(path)));
        } catch (FileNotFoundException fnfe) {
            throw new YoureDoingItWrongException(fnfe.getMessage(), fnfe.getCause());
        } catch (ParseException pe) {
            throw new YoureDoingItWrongException(pe.getMessage(), pe.getCause());
        } catch (IOException ioe) {
            throw new YoureDoingItWrongException(ioe.getMessage(), ioe.getCause());
        }
        return prepareMemeList(obj);
    }

    /**
     * Read a list of memes from a JSON object
     *
     * @param obj the Json Object
     * @return the list of memes read
     */
    private List<Meme> prepareMemeList(Object obj) {
        LOG.debug("prepareMemeList()");
        Objects.requireNonNull(obj, "Meme Object can't be null");
        List<Meme> memes = new ArrayList<Meme>();
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray memesArray = (JSONArray) jsonObject.get("memes");
        for(Object memeObj : memesArray) {
            JSONObject memeJsnObj = (JSONObject) memeObj;
            Meme meme = new Meme();
            String name = (String) memeJsnObj.get("name");
            LOG.debug("name: " + name);
            meme.setName(name);
            String year = (String) memeJsnObj.get("year");
            LOG.debug("year: " + year);
            meme.setYear(Integer.parseInt(year));
            JSONArray tagsList = (JSONArray) memeJsnObj.get("tags");
            LOG.debug("Tag List:");
            String[] updatedTags = new String[tagsList.size()];
            int i = 0;
            for (Object tag : tagsList) {
                LOG.debug("tag: " + tag);
                updatedTags[i++] = (String) tag;
            }
            meme.setTags(updatedTags);
            memes.add(meme);
        }
        return memes;
    }


}
