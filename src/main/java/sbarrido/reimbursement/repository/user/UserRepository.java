public interface UserRepository extends CrudRepository<User, String> {
    
    User findByUsername(String username);
}