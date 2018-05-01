//import com.codeup.pawtify.daos.*;
//import com.codeup.pawtify.models.Animal;
//import com.codeup.pawtify.models.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;3
//import java.util.Random;
//
//@Component
//public class PawtifySeeder implements CommandLineRunner {
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//    private final AnimalRepository animalDao;
//    private final UsersRepository userDao;
//    private final CatBreedRepository catDao;
//    private final DogBreedRepository dogDao;
//    private final PawtificationRepository pawdao;
//
//    @Value("${app.env}")
//    private String eviroment;
//
//    public PawtifySeeder(AnimalRepository animalDao, UsersRepository userDao, CatBreedRepository catDao, DogBreedRepository dogDao, PawtificationRepository pawdao){
//        this.animalDao = animalDao;
//        this.userDao = userDao;
//        this.catDao = catDao;
//        this.dogDao = dogDao;
//        this.pawdao = pawdao;
//    }
//
//    private List<User> seedUsers(){
//        List<User> users = Arrays.asList(
//                new User(1L, "emma dejong", "+13059008059", "edjong", "edejong@gmail.com", "edejong"),
//                new User(2L, "laura prochaska", "+13059008059", "lalepro", "lalepro@gmail.com", "lalepro"),
//                new User(3L, "bettina trejo", "+3059008059", "btrejo", "betrejo@gmail.com", "betrejo")
//        );
//        userDao.save(users);
//                return users;
//    }
//
////    Generate a list of animals and return it after saving
//    private void seedAnimals(List<Animal> animals){
//        Animal animal = new Animal(1L, "Lily", "less than 1 year", "female", "large", "brown", "good with children, dogs, and cats", null, null, catDao.findOne(id), dogDao.findOne(id)),
//
//    }
//
//
//
//
//
//}
//