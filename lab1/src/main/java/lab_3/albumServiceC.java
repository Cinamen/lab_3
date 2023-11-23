package lab_3;

import lab1_variant2.Album;

import java.time.LocalDate;
import java.util.*;

public class albumServiceC implements albumService {
    private final Set<Album> albums;

    public albumServiceC(Set<Album> albums) {
        this.albums = albums;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    @Override
    public boolean add(Album Album) throws UnsupportedOperationException, ClassCastException {
        return albums.add(Album);
    }

    @Override
    public boolean remove(Album album) throws UnsupportedOperationException, ClassCastException {
        return albums.remove(album);
    }

    @Override
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
    //найдовший

    @Override
    public List<Album> sortByDate() {
        List<Album> res = new ArrayList<>(albums);
        res.sort(Comparator.comparing(Album::getDateOfRelease));
        return res;
    }

    @Override
    public List<Album> sortBySoldUnits() {
        List<Album> res = new ArrayList<>(albums);
        res.sort(Comparator.comparing(Album::getTotalSoldUnits));
        return res;
    }

    @Override
    public List<Album> sortByDuration() {
        List<Album> res = new ArrayList<>(albums);
        res.sort(Comparator.comparing(Album::getTotalLength));
        return res;
    }

    @Override
    public List<Album> listByDate(LocalDate targetDate) {
        List<Album> result = new ArrayList<>();

        for (Album album : albums) {
            if (album.getDateOfRelease().equals(targetDate)) {
                result.add(album);
            }
        }
        return result;
    }
    @Override
    public Album longestAlbum() {
        if (albums.isEmpty()) {
            return null;
        }
        Iterator<Album> iterator = albums.iterator();
        Album longestAlbum = iterator.next();

        while (iterator.hasNext()) {
            Album currentAlbum = iterator.next();
            if (currentAlbum.getTotalLength().compareTo(longestAlbum.getTotalLength()) > 0) {
                longestAlbum = currentAlbum;
            }
        }

        return longestAlbum;
    }
}
