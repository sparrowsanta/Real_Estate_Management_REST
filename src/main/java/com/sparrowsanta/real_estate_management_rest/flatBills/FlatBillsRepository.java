package com.sparrowsanta.real_estate_management_rest.flatBills;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlatBillsRepository extends AbstractBaseRepository<FlatBills, Long> {

    List<FlatBills> findAllByFlatIdOrderByPaymentDateDesc(Long flatId);

    List<FlatBills> findAllByPaidOrderByPaymentDateDesc(boolean paid);

    FlatBills findFirstByBillDefinitionIdOrderByPaymentDateDesc(Long billDefinitionId);


    @Query(value = "SELECT MONTHNAME(fb.payment_date) AS MONTH FROM flat_bills_definitions fbd JOIN flat_bills fb ON fb.bill_definition_id = fbd.id GROUP BY MONTHNAME(fb.payment_date)  ORDER BY MONTHNAME(fb.payment_date)  DESC LIMIT 5" , nativeQuery = true)
    @Modifying
    String[] getMonths();

    @Query(value = "SELECT SUM(fbd.bill_amount) AS MONTH FROM flat_bills_definitions fbd JOIN flat_bills fb ON fb.bill_definition_id = fbd.id WHERE fbd.flat_id = ?1 GROUP BY MONTH(fb.payment_date) ORDER BY MONTH(fb.payment_date) DESC LIMIT 5" , nativeQuery = true)
    @Modifying
    String[] getSumBillsDefinitionPerMonth(long flat_id);

    @Query(value = "SELECT SUM(fb.amount) AS PAID_AMOUNT FROM flat_bills fb JOIN flat_bills_definitions fbd on fb.bill_definition_id = fbd.id WHERE paid = 1 AND fbd.flat_id = ?1 GROUP BY MONTH(fb.payment_date), paid ORDER BY MONTH(fb.payment_date) DESC LIMIT 5" , nativeQuery = true)
    @Modifying
    String[] getSumBillsPerMonth(long flat_id);

/*    /HQL query
    @Query("SELECT c,l,p,u FROM  Course c, Lesson l, Progress p, User u "
            + "WHERE c.id=l.courseId AND l.id = p.lessonId AND p.userId = u.id AND u.id=:userId AND c.id=:courseId")
    public List<Object[]> getLessonsWithProgress(@Param("userId") Integer userId, @Param("courseId")Integer courseId);*/


/*    SELECT MONTH(fb.payment_date) AS MONTH, SUM(fb.amount) AS PAID_AMMOUNT, fb.paid AS PAID
    FROM flat_bills fb
    JOIN flat_bills_definitions fbd on fb.bill_definition_id = fbd.id
    WHERE paid = 1
    GROUP BY MONTH(fb.payment_date), paid
    ORDER BY payment_date DESC
    LIMIT 5*/

//    SET description = ?1, room_square_meters = ?2, expected_rent_price = ?3, room_type = ?4 WHERE r.id = ?5"
}
