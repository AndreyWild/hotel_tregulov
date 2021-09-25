package temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {
//    @Autowired
//    UserRepository repository;
//
//    public User createNewUser(User user) {
//        return repository.save(user);
//    }
//}
//
//@Service
//public class DeleteUserService {
//    @Autowired
//    UserRepository repository;
//
//    public void deleteUser(Long id) {
//        repository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException(id));
//        repository.deleteById(id);
//    }
//}
//
//@Service
//public class DetailUserService {
//    @Autowired
//    UserRepository repository;
//
//    public User listUser(Long id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException(id));
//    }
//}
//
//@Service
//public class ListUserService {
//    @Autowired
//    UserRepository repository;
//
//    public List<User> listAllUsers() {
//        return repository.findAll();
//    }
//}
//
//@Service
//public class UpdateUserService {
//    @Autowired
//    UserRepository repository;
//
//    public User updateUser(Long id, User user) {
//        repository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException(id));
//        user.setId(id);
//        return repository.save(user);
//    }
//}
//    Create a new user service
//        Starting with our CreateUserService class,we’ll create a test
//
//class named CreateUserServiceTest.
//        src/test/java/com/usersapi/endpoints/unit/service/CreateUserServiceTest.java
//
//@RunWith(MockitoJUnitRunner.class)
//public class CreateUserServiceTest {
//    @Mock
//    private UserRepository userRepository;
//    @InjectMocks
//    private CreateUserService createUserService;
//
//    @Test
//    public void whenSaveUser_shouldReturnUser() {
//        User user = new User();
//        user.setName(“Test Name”);
//        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);
//        User created = createUserService.createNewUser(user);
//        assertThat(created.getName()).isSameAs(user.getName());
//        verify(userRepository).save(user);
//    }
}