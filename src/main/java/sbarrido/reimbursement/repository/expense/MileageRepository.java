public interface MileageRepository extends CrudRepository<Mileage, Long> {

    List<Mileage> findByYearAndMonth(int year, int month);
}