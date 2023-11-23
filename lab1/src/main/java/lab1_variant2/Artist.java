package lab1_variant2;

import java.time.LocalDate;
import java.util.Objects;
public class Artist{
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String pseudonym;
    private MusicLabel musicLabel;

    private Artist(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
        this.pseudonym = builder.pseudonym;
    }
    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return lastName;
    }

    public void setSecondName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate date) {
        this.dateOfBirth = date;
    }

    public MusicLabel getMusicLabel() {
        return musicLabel;
    }

    public void setMusicLabel(MusicLabel musicLabel) {
        this.musicLabel = musicLabel;
    }

    public String toString() {
        return "Artist's first name - " + firstName
                + "\n Second name - " + lastName
                + "\n Date of birth - " + dateOfBirth
                + "\n Pseudonym - " + pseudonym
                + "\n Music label - " + musicLabel.getName();
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Artist artist = (Artist) object;
        return firstName.equals(artist.firstName) && lastName.equals(artist.lastName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
    public static class Builder {
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String pseudonym;



        public Builder(String pseudonym) {
            this.pseudonym = pseudonym;
        }
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder dateOfBirth(LocalDate date) {
            this.dateOfBirth = date;
            return this;
        }


        public Artist build()  {
            return new Artist(this);
        }

    }

}
