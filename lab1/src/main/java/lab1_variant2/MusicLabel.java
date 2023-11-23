package lab1_variant2;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MusicLabel {
    private String labelName;
    private LocalDate foundingDate;
    private double netWorth;
    private String location;
    private List<Artist> artists;

    public MusicLabel(Builder builder) {
        this.labelName = builder.labelName;
        this.foundingDate = builder.foundingDate;
        this.netWorth = builder.netWorth;
        this.location = builder.location;
        this.artists = new ArrayList<>();
    }


    public MusicLabel() {
    }

    public LocalDate getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(LocalDate date) {
        this.foundingDate = date;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double worth) {
        this.netWorth = worth;
    }

    public String getName() {
        return labelName;
    }

    public void setName(String name) {
        this.labelName = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
        artist.setMusicLabel(this);
    }

    public void removeArtist(Artist artist) {
        artists.remove(artist);
        artist.setMusicLabel(null);
    }

    public List<Artist> getArtists() {
        return artists;
    }

    //метод артисти які народилися цього місяця

    //метод наймолодший артист

    public String toString() {
        return "Label - " + labelName
                + "\n Fouding date - " + foundingDate
                + "\n Adress - " + location
                + "\n Net Worth - " + netWorth;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MusicLabel label = (MusicLabel) object;
        return labelName.equals(label.labelName);
    }

    public int hashCode() {
        return Objects.hash(labelName);
    }

    public static class Builder {
        private String labelName;
        private LocalDate foundingDate;
        private double netWorth;
        private String location;


        public Builder(String name) {
            this.labelName = name;
        }

        public Builder foundingDate(LocalDate date) {
            this.foundingDate = date;
            return this;
        }

        public Builder netWorth(double worth) {
            this.netWorth = worth;
            return this;
        }

        public Builder location(String address) {
            this.location = address;
            return this;
        }

        public MusicLabel build()  {
            return new MusicLabel(this);
        }

    }

    public static void main(String[] args) {

        MusicLabel musicLabel = new MusicLabel.Builder("Sony Music")
                .foundingDate(LocalDate.of(1929, 5, 13))
                .netWorth(1000000000.0)
                .location("New York")
                .build();

        Artist artist = new Artist.Builder("Ethel Cain")
                .firstName("Hayden ")
                .lastName("Anhedönia ")
                .dateOfBirth(LocalDate.of(1998, 3, 24))
                .build();

        musicLabel.addArtist(artist);


        Album album = new Album.Builder("Preacher's Daughter")
                .dateOfRelease(LocalDate.of(2022, 5, 12))
                .totalLength(Duration.ofMinutes(75))
                .totalSoldUnits(500000)
                .build();


        album.setMusicLabel(musicLabel);


        System.out.println("Music Label Information:");
        System.out.println(musicLabel.toString());


        System.out.println("\nArtist Information:");
        System.out.println(artist.toString());


        System.out.println("\nAlbum Information:");
        System.out.println(album.toString());

        musicLabel.removeArtist(artist);


        if (artist.getMusicLabel() == null) {
            System.out.println("\nThe artist is not associated with any music label.");
        }
    }









}

