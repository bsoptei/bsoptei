package com.greenfox.bx;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * Created by Söp on 2016.11.16..
 */
public class CreditCardReservation implements Comparator<Object> {
    private Reservation reservation;
    private CreditCard creditCard;

    public CreditCardReservation(Reservation reservation, CreditCard creditCard) {
        this.reservation = reservation;
        this.creditCard = creditCard;
    }

    public String toString() {
        return String.format("%s paid by %s", reservation, creditCard);
    }

    public Reservation getReservation() {
        return reservation;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public Comparator<Object> reversed() {
        return null;
    }

    @Override
    public Comparator<Object> thenComparing(Comparator<? super Object> other) {
        return null;
    }

    @Override
    public <U> Comparator<Object> thenComparing(Function<? super Object, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return null;
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Object> thenComparing(Function<? super Object, ? extends U> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Object> thenComparingInt(ToIntFunction<? super Object> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Object> thenComparingLong(ToLongFunction<? super Object> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Object> thenComparingDouble(ToDoubleFunction<? super Object> keyExtractor) {
        return null;
    }
}
