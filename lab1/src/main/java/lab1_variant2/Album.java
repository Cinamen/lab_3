package lab1_variant2;


import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class Album implements Comparable<Album>{


    private String title;
    private LocalDate releaseDate;
    private Duration totalLength;
    private int totalSoldUnits;
    private MusicLabel musicLabel;

    public Album(String title, LocalDate dateOfRelease, Duration totalLength, int totalSoldUnits) {
        this.title = title;
        this.releaseDate = dateOfRelease;
        this.totalLength = totalLength;
        this.totalSoldUnits = totalSoldUnits;
    }
    public Album(Builder builder) {
        this.title = builder.title;
        this.releaseDate = builder.dateOfRelease;
        this.totalLength = builder.totalLength;
        this.totalSoldUnits = builder.totalSoldUnits;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateOfRelease() {
        return releaseDate;
    }

    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.releaseDate = dateOfRelease;
    }

    public Duration getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(Duration totalLength) {
        this.totalLength = totalLength;
    }

    public int getTotalSoldUnits() {
        return totalSoldUnits;
    }

    public void setTotalSoldUnits(int totalSoldUnits) {
        this.totalSoldUnits = totalSoldUnits;
    }

    public MusicLabel getMusicLabel() {
        return musicLabel;
    }

    public void setMusicLabel(MusicLabel musicLabel) {
        this.musicLabel = musicLabel;
    }

    public String toString() {
        long minutes = totalLength.toMinutes();
        return "Title of album - " + title
                + "\n Date of release - " + releaseDate
                + "\n Album length - " + minutes + " minutes"
                + "\n Total sold units - " + totalSoldUnits;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Album album = (Album) object;
        return title.equals(album.title) && musicLabel.equals(album.musicLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, musicLabel);
    }

    @Override
    public int compareTo(Album o) {
        return this.title.compareTo(o.title);
    }

    public static class Builder {
        private String title;
        private LocalDate dateOfRelease;
        private Duration totalLength;
        private int totalSoldUnits;


        public Builder(String title) {
            this.title = title;
        }


        public Builder dateOfRelease(LocalDate date) {
            this.dateOfRelease = date;
            return this;
        }

        public Builder totalLength(Duration time) {
            this.totalLength = time;
            return this;
        }

        public Builder totalSoldUnits(int amount) {
            this.totalSoldUnits = amount;
            return this;
        }

        public Album build() {
            Album album = new Album(title, dateOfRelease, totalLength, totalSoldUnits);
            Set<ConstraintViolation<Album>> errors;
            try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
                Validator validator = factory.getValidator();
                errors = validator.validate(album);
            }
            if (!errors.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (ConstraintViolation<Album> val : errors) {
                    sb.append("InvalidValue: ").append(val.getInvalidValue()).append("; ")
                            .append(val.getMessage()).append("\n");
                }
                throw new IllegalArgumentException(sb.toString());
            }
            return album;
        }

    }
}
