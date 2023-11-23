package lab_3;


import lab1_variant2.Album;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Album> albums = new TreeSet<>();
         albums.add(new Album("Album 3",LocalDate.of(2022, 1, 1),Duration.ofMinutes(51) ,1000));
        albums.add(new Album("Album 1",LocalDate.of(2011, 1, 1),Duration.ofMinutes(44) ,10001));
        albums.add(new Album("Album 2",LocalDate.of(2000, 1, 1),Duration.ofMinutes(60) ,2000));
        albums.add(new Album("Album 4",LocalDate.of(2000, 1, 1),Duration.ofMinutes(72) ,2000));
        System.out.println(albums);
        albumServiceC service = new albumServiceC(albums);
        System.out.println("Longest album - " + service.longestAlbum());
        System.out.println("List by date: " +  service.listByDate(LocalDate.of(2000, 1, 1)));
        System.out.println("Sorted by date: " +  service.sortByDate());
        System.out.println("Sorted by sold : " +  service.sortBySoldUnits());
        System.out.println("Sorted by duration : " +  service.sortByDuration());
        service.remove(2);
        System.out.println(albums);

        albumServiceStream serviceS = new albumServiceStream(albums);
        albums.add(new Album("Album 4",LocalDate.of(1999, 1, 1),Duration.ofMinutes(49) ,21000));
        System.out.println("StreamAPI ");
        System.out.println("Sorted by date: " + serviceS.sortByDate());
        System.out.println("Sorted by sold : " +  serviceS.sortBySoldUnits());
        System.out.println("Sorted by duration : " +  serviceS.sortByDuration());
    }
}
