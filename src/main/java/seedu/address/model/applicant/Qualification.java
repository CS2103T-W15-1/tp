package seedu.address.model.applicant;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Applicant's qualification in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidQualification(String)}
 */
public class Qualification {
    public static final String MESSAGE_CONSTRAINTS =
            "Qualifications should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the qualification must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String highestQualification;

    /**
     * Constructs a {@code Qualification}.
     *
     * @param qualification A valid qualification.
     */
    public Qualification(String qualification) {
        requireNonNull(qualification);
        checkArgument(isValidQualification(qualification), MESSAGE_CONSTRAINTS);
        highestQualification = qualification;
    }

    /**
     * Returns true if a given string is a valid qualification.
     */
    public static boolean isValidQualification(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return highestQualification;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof seedu.address.model.applicant.Qualification // instanceof handles nulls
                && highestQualification.equals(((seedu.address.model.applicant.Qualification) other)
                .highestQualification)); // state check
    }

    @Override
    public int hashCode() {
        return highestQualification.hashCode();
    }
}