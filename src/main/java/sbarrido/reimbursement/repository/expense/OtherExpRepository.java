public interface OtherExpRepository extends CrudRepository<OtherExp, Long> {

    List<OtherExp> findByYearAndMonth(int year, int month);
}