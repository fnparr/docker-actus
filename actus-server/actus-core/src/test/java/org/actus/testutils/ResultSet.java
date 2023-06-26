package org.actus.testutils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import org.actus.types.EventType;
import org.actus.util.CommonUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class ResultSet {
    HashMap<String, String> values;
    LocalDateTime eventDate;
    LocalDateTime exerciseDate;
    EventType eventType;
    String currency;
    Double payoff;
    Double accruedInterest;
    Double accruedInterest2;
    Double exerciseAmount;
    Double feeAccrued;
    Double interestCalculationBaseAmount;
    Double interestScalingMultiplier;
    Double nextPrincipalRedemptionPayment;
    Double nominalInterestRate;
    Double nominalInterestRate2;
    Double notionalPrincipal;
    Double notionalPrincipal2;
    Double notionalScalingMultiplier;

    public HashMap<String, String> getValues() {
        return values;
    }

    public void setValues(HashMap<String, String> values) {
        this.values = values;
    }

    public LocalDateTime getEventDate() { return eventDate; }

    public void setEventDate(String eventDate) {
        this.eventDate = LocalDateTime.parse(eventDate);
    }

    public LocalDateTime getExerciseDate() {
        return exerciseDate;
    }

    public void setExerciseDate(String exerciseDate) {
        this.exerciseDate = LocalDateTime.parse(exerciseDate);
    }

    public EventType getEventType() { return eventType; }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getPayoff() {
        return payoff;
    }

    public void setPayoff(Double payoff) {
        this.payoff = payoff;
    }

    public Double getAccruedInterest() {
        return accruedInterest;
    }

    public void setAccruedInterest(Double accruedInterest) {
        this.accruedInterest = accruedInterest;
    }

    public Double getAccruedInterest2() {
        return accruedInterest2;
    }

    public void setAccruedInterest2(Double accruedInterest2) {
        this.accruedInterest2 = accruedInterest2;
    }

    public Double getExerciseAmount() {
        return exerciseAmount;
    }

    public void setExerciseAmount(Double exerciseAmount) {
        this.exerciseAmount = exerciseAmount;
    }

    public Double getFeeAccrued() {
        return feeAccrued;
    }

    public void setFeeAccrued(Double feeAccrued) {
        this.feeAccrued = feeAccrued;
    }

    public Double getInterestCalculationBaseAmount() {
        return interestCalculationBaseAmount;
    }

    public void setInterestCalculationBaseAmount(Double interestCalculationBaseAmount) { this.interestCalculationBaseAmount = interestCalculationBaseAmount; }

    public Double getInterestScalingMultiplier() {
        return interestScalingMultiplier;
    }

    public void setInterestScalingMultiplier(Double interestScalingMultiplier) { this.interestScalingMultiplier = interestScalingMultiplier; }

    public Double getNextPrincipalRedemptionPayment() {
        return nextPrincipalRedemptionPayment;
    }

    public void setNextPrincipalRedemptionPayment(Double nextPrincipalRedemptionPayment) { this.nextPrincipalRedemptionPayment = nextPrincipalRedemptionPayment; }

    public Double getNominalInterestRate() {
        return nominalInterestRate;
    }

    public void setNominalInterestRate(Double nominalInterestRate) {
        this.nominalInterestRate = nominalInterestRate;
    }

    public Double getNominalInterestRate2() {
        return nominalInterestRate2;
    }

    public void setNominalInterestRate2(Double nominalInterestRate2) { this.nominalInterestRate2 = nominalInterestRate2; }

    public Double getNotionalPrincipal() {
        return notionalPrincipal;
    }

    public void setNotionalPrincipal(Double notionalPrincipal) {
        this.notionalPrincipal = notionalPrincipal;
    }

    public Double getNotionalPrincipal2() {
        return notionalPrincipal2;
    }

    public void setNotionalPrincipal2(Double notionalPrincipal2) {
        this.notionalPrincipal2 = notionalPrincipal2;
    }

    public Double getNotionalScalingMultiplier() {
        return notionalScalingMultiplier;
    }

    public void setNotionalScalingMultiplier(Double notionalScalingMultiplier) { this.notionalScalingMultiplier = notionalScalingMultiplier; }

    public void roundTo(int decimals) {
        // round payoff
        for(String key : this.values.keySet()){
            Double numericValue = null;
            try{
                numericValue = Double.valueOf(this.values.get(key));
            }catch(NumberFormatException e){}
            if(!CommonUtils.isNull(numericValue)){
                BigDecimal bd = new BigDecimal(Double.toString(numericValue));
                numericValue = bd.setScale(decimals, RoundingMode.FLOOR).toBigInteger().doubleValue();
                this.values.put(key,numericValue.toString());
            }
        }
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(String key : this.values.keySet()){
            builder.append(key +": " +this.values.get(key) + ", ");
        }
        builder.delete(builder.length()-2,builder.length());
        return builder.toString();
    }

    // for assertEquals in JUnit testing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashMap<String, String> resultsToCompare = ((ResultSet) o).getValues();
        Boolean equal = true;
        for(String key : this.values.keySet()){
            equal &= this.values.get(key).equals(resultsToCompare.get(key));
        }
        return equal;
    }

    //parse required fields to values Map
    public void setRequiredValues(HashMap<String, String> keys, HashMap<String, String> values){
        HashMap<String, String> setFields = new HashMap<>();
        for(String fieldName : keys.keySet()){
            setFields.put(fieldName, values.get(fieldName));
        }
        this.values = setFields;
    }

    //parse set fields to values Map
    public void setValues(){
        HashMap<String, String> setFields = new HashMap<>();
        for(Field f : this.getClass().getDeclaredFields()){
            try {
                Object value = f.get(this);
                if(value != null){
                    setFields.put(f.getName(), value.toString());
                }
            }catch(Exception e){
                System.err.println("IndexOutOfBounds");
            }
        }
        this.values = setFields;
    }
}
