import model.Movie;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;


public class MovieStoreTest {

    @Test
    public void returnsNoResultsWhenNoTitlesPartiallyMatchSearch() throws Exception{
        MovieStore movieStore = new MovieStore();

         List<Movie> results = movieStore.findByPartialTitle("abc");

        assertThat(results.size(),is(0));
    }

    @Test
    public void findAMoviesWhenTitlesArePartiallyMatched() throws Exception{
        MovieStore movieStore = new MovieStore();
        Movie harryPotter = new Movie("Harry Potter");

        movieStore.add(harryPotter);
        movieStore.add(new Movie("Star Wars"));
        movieStore.add(new Movie("Wanted"));
        movieStore.add(new Movie("The Lord Of Rings"));

        movieStore.findByPartialTitle("abc");

        List<Movie> results = movieStore.findByPartialTitle("arry");

        assertThat(results.size(),is(1));
        assertThat(results, contains(harryPotter));

    }

}