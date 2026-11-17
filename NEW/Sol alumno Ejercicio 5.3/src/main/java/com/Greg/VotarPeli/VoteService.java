package com.Greg.VotarPeli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VoteService {
    // this is the filing cabinet. holds all the counts + all the emails that voted
    // lives as long as the app runs. rules: business: this email hasn’t voted yet

    // create an Array for storing the emails
    private List<String> emailsVoted = new ArrayList<>();

    // list to store votes. index corresponds with movies index
    private List<Integer> votesList = new ArrayList<>(Arrays.asList(0, 0, 0));

    // Returns a read-only VIEW of the vote counts (not a copy): callers always see
    // the current
    // votes, but any attempt to modify the list throws
    // UnsupportedOperationException.
    // Votes can only change through this class's own methods (registerVote).
    // A Lombok @Getter would return the real list, letting callers modify it.
    public List<Integer> getVotesList() {
        return Collections.unmodifiableList(votesList);
    }

    // helper function to check if email has already registerd a vote
    private boolean checkIfVoted(String email) {
        return emailsVoted.contains(email);
    }

    // registers a vote and saves the email
    public void registerVote(String email, int movieIndex) throws RuntimeException {
        // FIRST! normalizes email so they are stored in same format
        email = email.trim().toLowerCase();
        // checks if email has voted already
        if (checkIfVoted(email)) {
            throw new RuntimeException("User with this email has already registered a vote");
        }
        // check if index is within range:
        if (movieIndex < 0 || movieIndex >= votesList.size()) {
            throw new RuntimeException("Invalid movie.");
        }
        votesList.set(movieIndex, votesList.get(movieIndex) + 1);
        emailsVoted.add(email);
    }
}
