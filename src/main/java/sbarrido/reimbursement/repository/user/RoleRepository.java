public interface RoleRepository extends CrudRepository<Role, String> {
    
    Role findByRole(String role);
}