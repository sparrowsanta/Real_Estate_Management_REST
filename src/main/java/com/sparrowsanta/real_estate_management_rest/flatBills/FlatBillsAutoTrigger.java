package com.sparrowsanta.real_estate_management_rest.flatBills;

import com.sparrowsanta.real_estate_management_rest.flatBillsDefinitions.FlatBillsDefinitions;
import com.sparrowsanta.real_estate_management_rest.flatBillsDefinitions.FlatBillsDefinitionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Configuration
@EnableScheduling
public class FlatBillsAutoTrigger {
    @Autowired
    private FlatBillsService flatBillsService;
    @Autowired
    private FlatBillsDefinitionsService flatBillsDefinitionsService;

    private static final int NUMBER_OF_DAYS_BEFORE_PAYMENT_TO_TRIGGER = 15;
    private static final int RUN_INTERVAL_IN_MINUTES = 1;
    private int numberOfPaymentsTriggered;


    @Scheduled(fixedDelay = 1000 * 60 * RUN_INTERVAL_IN_MINUTES)
    public void executeTask1() {
        numberOfPaymentsTriggered = 0;
        List<FlatBillsDefinitions> flatBillsDefinitions = flatBillsDefinitionsService.findAll();
        flatBillsDefinitions.forEach(this::checkIfGeneratePayment);
        System.out.println(LocalDateTime.now() + " - Triggered " + numberOfPaymentsTriggered + " payment(s)");
        System.out.println("Next run in " + RUN_INTERVAL_IN_MINUTES + " minute(s)");

    }

    private void checkIfGeneratePayment(FlatBillsDefinitions flatBillsDefinition) {
        FlatBills lastPayment = flatBillsService.getLastPaymentByBillDefinitionId(flatBillsDefinition.getId());
//        System.out.println(flatBillsDefinition.getBillDescription());
//        System.out.println(lastPayment == null ? "Brak płatnośći" : "Ostatnia płatność " + lastPayment.getPaymentDate());
        if (lastPayment == null || lastPayment.getPaymentDate().isBefore(LocalDate.now())) {
            int monthsToAdd = lastPayment == null ? 1 : flatBillsDefinition.getBillFrequencyInMonths();
            LocalDate newPaymentDate = LocalDate.now();

            newPaymentDate = newPaymentDate.plusMonths(monthsToAdd).withDayOfMonth(
                    Math.min(flatBillsDefinition.getPaymentTillDayOfMonth(), newPaymentDate.plusMonths(monthsToAdd).with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth()));
//            System.out.println("Next payment date = " + newPaymentDate);
            if (NUMBER_OF_DAYS_BEFORE_PAYMENT_TO_TRIGGER >= ChronoUnit.DAYS.between(LocalDate.now(), newPaymentDate)) {
//                System.out.println("New payment within " + numberOfDaysBeforePaymentToTrigger + " days");
//                System.out.println("New payment date should be triggered for " + newPaymentDate);
                triggerNewPayment(flatBillsDefinition, newPaymentDate);
                numberOfPaymentsTriggered++;
            } else {
//                System.out.println("New payment should not be triggered as date not within " + numberOfDaysBeforePaymentToTrigger + " days");
            }

        } else {
//            System.out.println("New payment should not be triggered - next payment already exists");
        }

//        System.out.println("-------------------------------");

    }

    private void triggerNewPayment(FlatBillsDefinitions flatBillsDefinition, LocalDate paymentDate) {
        FlatBills payment = new FlatBills();
        payment.setAmount(flatBillsDefinition.getBillAmount());
        payment.setBillDefinitionId(flatBillsDefinition.getId());
        payment.setCurrency(flatBillsDefinition.getCurrency());
        payment.setDescription(flatBillsDefinition.getBillDescription());
        payment.setFlatId(flatBillsDefinition.getFlatId());
        payment.setIncomeOutcome(flatBillsDefinition.getIncomeOutcome());
        payment.setPaymentDate(paymentDate);
        payment.setPaid(false);
        flatBillsService.save(payment);
    }

}


