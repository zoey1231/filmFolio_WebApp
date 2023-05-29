package com.example.movie.mapper;

import com.example.movie.model.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class) //runwith: indicate to start this unit test class, SpringRunner.class: an instance
public class MovieMapperTests {
    @Autowired
    private MovieMapper movieMapper;
    /**
     *
     * Unit test
     * 1. must be void
     * 2. must has @Test annotation
     * has be public and has no input parameter
     */
    @Test
    public void insert() {
        Movie movie = new Movie("'First Wives Club, The'",1996,"Comedy",116313L,2925L);
        Integer rows = movieMapper.insert(movie);
        assert rows == 1;
    }

    @Test
    public void findByName() {
        String name = "'First Wives Club, The'";
        Movie movie = movieMapper.findByName(name);
        System.out.println("find by name: \n" + movie);
    }

    @Test
    public void findById() {
        Long id = 829L;
        Movie movie = movieMapper.findById(id);
        System.out.println("find by id: \n" + movie);
    }

    @Test
    public void search(){
        String searchString = "comedy";
        System.out.println("search result: \n" + movieMapper.search(searchString));
    }
}
