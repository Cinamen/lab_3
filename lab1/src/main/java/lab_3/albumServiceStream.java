package lab_3;

import lab1_variant2.Album;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class albumServiceStream implements albumService{
    private final Set<Album> albums;

    public albumServiceStream(Set<Album> albums) {
        this.albums = albums;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    @Override
    public boolean add(Album AlbumC) throws UnsupportedOperationException, ClassCastException {
        return albums.add(AlbumC);
    }

    @Override
    public boolean remove(Album album) throws UnsupportedOperationException, ClassCastException {
        return albums.remove(album);
    }

    public boolean remove(int idx) {
        int i = 0;
        for(Album album : albums){
            if (i == idx){
                return albums.remove(album);
            }
            i++;
        }
        return false;
    }

    @Override
    public List<Album> sortByDate() {
        return albums.stream()
                .sorted(Comparator.comparing(Album::getDateOfRelease))
                .collect(Collectors.toList());
    }

    @Override
    public List<Album> sortBySoldUnits() {
        return albums.stream()
                .sorted(Comparator.comparing(Album::getTotalSoldUnits))
                .collect(Collectors.toList());
    }

    @Override
    public List<Album> sortByDuration() {
        return albums.stream()
                .sorted(Comparator.comparing(Album::getTotalLength))
                .collect(Collectors.toList());
    }

    @Override
    public List<Album> listByDate(LocalDate targetDate) {
        return albums.stream()
                .filter(album -> album.getDateOfRelease().equals(targetDate))
                .collect(Collectors.toList());
    }

    @Override
    public Album longestAlbum() {
        if (albums.isEmpty()) {
            return null;
        }

        Optional<Album> longestAlbum = albums.stream()
                .max(Comparator.comparing(album -> album.getTotalLength().toMinutes()));

        return longestAlbum.orElse(null);
    }
}
