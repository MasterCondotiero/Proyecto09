package com.Alvarocampos.Proyecto07.Ejercicio10;

import java.time.LocalDate;
import java.util.Random;

public class RandomFecha {
    private final LocalDate minDate;
    private final LocalDate maxDate;
    private final Random random;

    public RandomFecha(LocalDate minDate, LocalDate maxDate) {
        this.minDate = minDate;
        this.maxDate = maxDate;
        this.random = new Random();
    }
    public LocalDate nextDate() {
        int minDay = (int) minDate.toEpochDay();
        int maxDay = (int) maxDate.toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    @Override
    public String toString() {
        return "RandomDate{" +
                "maxDate=" + maxDate +
                ", minDate=" + minDate +
                '}';
    }
}
