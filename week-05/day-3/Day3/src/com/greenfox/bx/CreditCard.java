package com.greenfox.bx;

import java.util.Comparator;

/**
 * Created by Söp on 2016.11.16..
 */
public class CreditCard implements CreditCardy, Comparator<Object> {
    private String name;
    private String codeAccount;
    private int sumCVV;

    public CreditCard(int i, String name, String codeAccount) {
        this.name = name;
        this.codeAccount = codeAccount;
        this.setSumCVV(cumeSumCVV(codeAccount));
    }

    @Override
    public void setSumCVV(int sumCVV) {
        this.sumCVV = sumCVV;
    }

    @Override
    public int getSumCVV() {
        return sumCVV;
    }

    @Override
    public void setNameCardholder(String nameCardholder) {

    }

    @Override
    public String getNameCardholder() {
        return null;
    }

    @Override
    public void setCodeAccount(String codeAccount) {

    }

    @Override
    public String getCodeAccount() {
        return codeAccount;
    }

    @Override
    public int cumeSumCVV(String codeAccount) {
        int sum = 0;
        for (int i = 0; i < codeAccount.length(); i++) {
            sum += Integer.parseInt(codeAccount.substring(i, i + 1));
        }
        return sum;
    }

    @Override
    public boolean ValidCard(String codeAccount, int sumCVV) {
        if (sumCVV == cumeSumCVV(codeAccount)) {
            return true;

        } else {
            return false;
        }
    }


    public String toString() {
        return String.format("Name=%s CC#=%s CVV=%d", name, codeAccount, sumCVV);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
