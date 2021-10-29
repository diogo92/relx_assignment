package com.relx.naming.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Name parsing class, contains the methods that apply the logic for name parsing.
 */
@Service
public class NamingService {


    public static final String SEPARATOR = ",";
    public static final String RESULT_STRING = "First name: %s, Last name: %s";
    public static final String REGEX = "([ ])(?!.*[ ])";

    /**
     *
     * Parse one single name, can be separated by comma or white space
     * If the name contains a comma, the string is split, making the substring before the comma the last name and the substring after the comma the first name
     * If the name does not contain a comma, the last name will be the substring after the last white space and the first name will be the substring before the last white space
     * @param name - name of the author to parse
     * @return - string parsed in the RESULT_STRING constant format
     */
    public String parseName(String name) {

        String firstName = "";
        String lastName = "";
        if(name != null && !name.isEmpty()) {
            if (name.contains(",")) {
                lastName = name.substring(0, name.indexOf(SEPARATOR)).trim();
                firstName = name.substring(name.indexOf(SEPARATOR) + 1).trim();
            } else {
                String[] splitNames = name.split(REGEX);
                firstName = splitNames[0];
                lastName = splitNames.length > 1 ? splitNames[1] : "";
            }
        }
        return String.format(RESULT_STRING, firstName,lastName);
    }

    /**
     * Parse a string that may contain several names, separated by comma
     * The input is split by comma, and for each substring, the last name will be the substring after the last white space and the first name will be the substring before the last white space
     * @param names - string with the joined names of the authors
     * @return - list of string parsed in the RESULT_STRING constant format
     */
    public ArrayList<String> parseJoinedNames(String names) {

        ArrayList<String> result = new ArrayList<String>();
        if(names != null && !names.isEmpty()) {
            String[] splitNames = names.split(SEPARATOR);

            for (String authorName : splitNames) {
                String[] splitAuthorName = authorName.split(REGEX);
                String firstName = splitAuthorName[0].trim();
                String lastName = splitAuthorName.length > 1 ? splitAuthorName[1].trim() : "";
                result.add(String.format(RESULT_STRING, firstName, lastName));
            }
        }
        return result;
    }
}
