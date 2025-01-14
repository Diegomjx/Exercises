import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Secure_Password {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Password: ");
            String password = br.readLine();

            // Evaluate password strength
            int score = evaluatePasswordStrength(password);

            // Check wordlists
            int wordlistMatches = checkWordlists(password);

            // Display results
            System.out.println("Password Score: " + score);
            System.out.println("Wordlist Matches: " + wordlistMatches);

            // Provide feedback
            String feedback = getFeedback(score);
            System.out.println("Feedback: " + feedback);

        } catch (Exception e) {
            System.out.println("[I] Error: " + e);
        }
    }

    // Evaluate password strength based on criteria
    private static int evaluatePasswordStrength(String password) {
        int length = password.length();
        boolean hasLowercase = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasUppercase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasNumber = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecial = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();

        // Compute base score
        int score = length * ((hasLowercase ? 1 : 0) + (hasUppercase ? 5 : 0)
                + (hasNumber ? 5 : 0) + (hasSpecial ? 5 : 0));
	int conditionsMet = (hasLowercase ? 1 : 0) 
                  	  + (hasUppercase ? 1 : 0)
                  	  + (hasNumber ? 1 : 0)
                  	  + (hasSpecial ? 1 : 0);

        // Adjust score based on length thresholds
        if (length >= 15) {
            score += 20; // Bonus for long passwords
        } else if (length >= 8 && hasLowercase && hasNumber) {
            score += 10; // Bonus for meeting minimum criteria
        } else if (conditionsMet == 1){  
	          score /= 20; // Penalty for using only one
	      } else if (conditionsMet == 2){  
	          score /= 10; // Penalty for using only two
	      } else if (conditionsMet == 3){  
	          score /= 5; // Penalty for using only three
	      }

        return score;
    }

    // Check password against wordlists
    private static int checkWordlists(String password) {
        String[] wordlists = {
            "wordlists/english.txt",
            "wordlists/shortKrak.txt",
            "wordlists/rockyou.txt"
        };

        int matches = 0;

        for (String wordlist : wordlists) {
            try (BufferedReader br = new BufferedReader(new FileReader(wordlist))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.equals(password)) {
                        matches++;
                        break; // Exit early if found
                    }
                }
            } catch (IOException e) {
                System.out.println("[I] Error reading wordlist: " + wordlist);
            }
        }

        return matches;
    }

    // Provide feedback based on score
    private static String getFeedback(int score) {
        if (score < 30) {
            return "LOW";
        } else if (score < 60) {
            return "MEDIUM";
        } else if (score < 300) {
            return "HIGH";
        } else {
            return "INSANE";
        }
    }
}
