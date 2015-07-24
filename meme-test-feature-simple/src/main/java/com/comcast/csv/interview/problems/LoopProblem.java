package com.comcast.csv.interview.problems;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.comcast.csv.meme.Meme;

/**
 * Using all forms of loops and recursions to iterate over a {@link List} of
 * {@link Meme}s and log it's name and year. Format of the log message isn't
 * important.
 */
public class LoopProblem {

	private final static Logger LOG = LoggerFactory.getLogger(LoopProblem.class);

	public void forLoop(List<Meme> memes) {
		LOG.debug("forLoop()");
		Objects.requireNonNull(memes, "Memes collection can't be null");
		for (Meme meme : memes) {
			LOG.debug("name: " + meme.getName());
			LOG.debug("year: " + meme.getYear());
		}
	}

	public void whileLoop(List<Meme> memes) {
		LOG.debug("whileLoop()");
		Objects.requireNonNull(memes, "Memes collection can't be null");
		Iterator<Meme> iterator = memes.iterator();
		while (iterator.hasNext()) {
			Meme meme = iterator.next();
			LOG.debug("name: " + meme.getName());
			LOG.debug("year: " + meme.getYear());
		}
	}

	public void doWhileLoop(List<Meme> memes) {
		Objects.requireNonNull(memes, "Memes collection can't be null");
		LOG.debug("doWhileLoop()");
		Iterator<Meme> iterator = memes.iterator();
		do {
			Meme meme = iterator.next();
			LOG.debug("name: " + meme.getName());
			LOG.debug("year: " + meme.getYear());
		} while (iterator.hasNext());
	}
}
