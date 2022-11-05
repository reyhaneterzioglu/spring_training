package com.cydeo;

import com.cydeo.enums.UserRole;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final MovieRepository movieRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;


    public QueryDemo(AccountRepository accountRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, MovieCinemaRepository movieCinemaRepository, MovieRepository movieRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.movieRepository = movieRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        ACCOUNT REPOSITORY

//        System.out.println(accountRepository.findByCountry("United States"));
//        System.out.println(accountRepository.findByAgeLessThanEqual(28));
//        System.out.println(accountRepository.findByRole(UserRole.USER));
//        System.out.println(accountRepository.findByAgeBetween(20, 40));
//        System.out.println(accountRepository.findByAddressStartingWith("262"));
//        System.out.println(accountRepository.findByOrderByAge());
//        System.out.println(accountRepository.retrieveAll());
//        System.out.println(accountRepository.retrieveAllAdminAccounts());
//        System.out.println(accountRepository.retrieveAllSortByAge());
//        System.out.println(accountRepository.retrieveAllContains("Josie"));
//        System.out.println(accountRepository.readAllAgeGreaterThan(37));
//        System.out.println(accountRepository.retrieveAllAgeLessThan(35));


//        CINEMA REPOSITORY

//        System.out.println(cinemaRepository.findByName("Hall 1 - EMPIRE"));
//        System.out.println(cinemaRepository.findTop3BySponsoredNameContainingOrderBySponsoredName("Mc"));
//        System.out.println(cinemaRepository.findByLocationCountry("United States"));
//        System.out.println(cinemaRepository.findByNameOrSponsoredName("Hall 1 - EMPIRE", "McDonald"));
//        System.out.println(cinemaRepository.findNameById(11L));
//        System.out.println(cinemaRepository.readAllByCountry("United States"));
//        System.out.println(cinemaRepository.readAllByNameOrSponsoredNameContaining("EMPIR"));
//        System.out.println(cinemaRepository.readAllByOrderByName());
//        System.out.println(cinemaRepository.findDistinctBySponsoredName());

//        GENRE REPOSITORY

//        System.out.println(genreRepository.readAll());
//        System.out.println(genreRepository.readByNameContaining("Com"));

//        MOVIE CINEMA REPOSITORY

//        System.out.println(movieCinemaRepository.readById(1L));
//        System.out.println(movieCinemaRepository.countByCinema_Id(1L));
//        System.out.println(movieCinemaRepository.countByMovie_Id(1L));
//        System.out.println(movieCinemaRepository.findByDateTimeBefore(LocalDateTime.now()));
//        System.out.println(movieCinemaRepository.findTop3ByOrderByMoviePriceDesc());
//        System.out.println(movieCinemaRepository.findByMovie_NameContaining("Mind"));
//        System.out.println(movieCinemaRepository.findByCinemaLocationName("AMC Empire 25"));
//        System.out.println(movieCinemaRepository.findAllByDateAfter(LocalDateTime.of(2010, 1, 1, 1, 1)));
//        System.out.println(movieCinemaRepository.countByCinemaId(1L));
//        System.out.println(movieCinemaRepository.retrieveByLocationName("AMC Empire 25"));

//        MOVIE REPOSITORY

//        System.out.println(movieRepository.findByName("The Gentleman"));
//        System.out.println(movieRepository.findByPriceBetween(BigDecimal.valueOf(20), BigDecimal.valueOf(30)));
//        System.out.println(movieRepository.findByDurationIn());
//        System.out.println(movieRepository.findByReleaseDateGreaterThan(LocalDate.of(2010, 1, 1)));
//        System.out.println(movieRepository.findByStateAndType(State.ACTIVE, Type.REGULAR));
//        System.out.println(movieRepository.findByPriceRange(BigDecimal.valueOf(20), BigDecimal.valueOf(30)));
//        System.out.println(movieRepository.findAllMovieNames());
//        System.out.println(movieRepository.retrieveByName("The Gentleman"));
//        System.out.println(movieRepository.retrieveByPriceRange(20, 30));
//        System.out.println(movieRepository.retrieveByDurationRange(100, 200));
//        System.out.println(movieRepository.findTop5expensive());

//        TICKET REPOSITORY

//        System.out.println(ticketRepository.countByUserAccountUsername("josieStory"));
//        System.out.println(ticketRepository.countByMovieCinemaMovie(movieRepository.findByName("The Gentleman").get(0)));
//        System.out.println(ticketRepository.findByUserAccountEmail("josie_story@email.com"));
//        System.out.println(ticketRepository.findByDateTimeBetween(LocalDateTime.of(2020,12,05 ,1,1), LocalDateTime.of(2020,12,8 ,19,00)));
//        System.out.println(ticketRepository.findByUser("Josie D Story"));
//        System.out.println(ticketRepository.findByDateRange(LocalDateTime.of(2020, 12, 05, 1, 1), LocalDateTime.of(2020, 12, 8, 19, 00)));
//        System.out.println(ticketRepository.countByUser("Josie D Story"));
//        System.out.println(ticketRepository.countByUserAndRangeOfDate("Josie D Story", LocalDateTime.of(2020, 12, 05, 1, 1), LocalDateTime.of(2020, 12, 8, 19, 00)));
//        System.out.println(ticketRepository.findDistinctByMovieName("The Gentleman"));
//        System.out.println(ticketRepository.findByEmail("josie_story@email.com"));
//        System.out.println(ticketRepository.retrieveAll());
//        System.out.println(); //??

//        USER REPOSITORY

//        System.out.println(userRepository.findByEmail("josie_story@email.com"));
//        System.out.println(userRepository.findByUsername("bernard"));
//        System.out.println(userRepository.findByAccountContainingAccount_Name("Faith R Parsons")); // error
//        System.out.println(userRepository.findByAccountContainingIgnoreCaseAccount_Name("Faith R Parsons")); // error
//        System.out.println(userRepository.findByAccountGreaterThanAccount_Age(20)); // error
//        System.out.println(userRepository.retrieveByEmail("josie_story@email.com"));
//        System.out.println(userRepository.retrieveByUsername("bernard"));
//        System.out.println(userRepository.retrieveAll());
//        System.out.println(userRepository.retrieveAllContainsName("F")); // does not work
//        System.out.println(userRepository.readAll());
//        System.out.println(userRepository.retrieveAllRangeByAge(20, 30));
//        System.out.println(userRepository.readByEmail("josie_story@email.com"));

    }
}
