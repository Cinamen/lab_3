package lab_3;

import lab1_variant2.Album;

import java.time.LocalDate;
import java.util.List;

public interface albumService {
    boolean add(Album album);
    boolean remove(Album album);
    boolean remove(int idx);
    List<Album> sortByDate();
    List<Album> sortBySoldUnits();
    List<Album> sortByDuration();
    List<Album> listByDate(LocalDate targetDate);
    Album longestAlbum();

}
