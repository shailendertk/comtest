package com.comcast.csv.interview.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The following methods operate on street addresses in a particular format. The format contains the following components:
 * <p>
 * 1. Number of miles from the center of the city
 * 2. Primary direction from the city as a single lower-case letter
 * 3. Street number
 * 4. Street name (always a single word)
 * 5. An abbreviation for either a Street or Avenue with a period
 * <p>
 * </h2>Example Valid Addresses</h2>
 * 25w873 Apple St.
 * 3n17 Special Ave.
 * 0e34800 Main St.
 */
public class StringParsingProblem {

    private final static Logger LOG = LoggerFactory.getLogger(StringParsingProblem.class);

    private static final String ADDRESS_PATTERN =
            "^[A-Za-z0-9]+(\\s[_A-Za-z]+)+(\\s[A-Za-z]+)+(\\.)$";
    private Pattern addressPattern;
    private Matcher matcher;
    private String cityCenter;

    public StringParsingProblem() {
        addressPattern = Pattern.compile(ADDRESS_PATTERN);
        cityCenter = UUID.randomUUID().toString();
    }

    /**
     * Returns true if the address is valid, otherwise false.
     *
     * @param address the address to validate
     * @return true if the address is valid
     */
    public boolean isAddressValid(String address) {
        LOG.debug("isAddressValid() address: " + address);
        Objects.requireNonNull(address, "Address can't be null");
        //we should use geo locations apis here
        matcher = addressPattern.matcher(address);
        return matcher.matches();
    }

    /**
     * Get the distance in miles from the center of the city from the given address.
     *
     * @param address the address
     * @return the distance
     */
    public int getDistanceFromCityCenter(String address) {
        LOG.debug("getDistanceFromCityCenter() address: " + address);
        Objects.requireNonNull(address, "Address can't be null");
        //we should use geo locations apis here

        return cityCenter.length() + address.trim().length()*10;
    }
}
