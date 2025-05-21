package com.pluralsight.finance;

public abstract class Contract {
    private String contractDate;
    private String name;
    private String email;
    private double sold;
    private double total;
    private double monthlyPayment;

    public Contract(String contractDate, String name, String email, double sold, double total, double monthlyPayment) {
        this.contractDate = contractDate;
        this.name = name;
        this.email = email;
        this.sold = sold;
        this.total = total;
        this.monthlyPayment = monthlyPayment;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;


        public void getMonthlyPayment; {
            return null;
        }

        public void getTotalPrice; {
            return null;

        }
    }
}
