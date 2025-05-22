package com.pluralsight.finance;

import com.pluralsight.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;





public class ContractFileManager {

    private static final String FILE_NAME = "contracts.csv";
// The file writer is able to distinguish between sales contract and lease contract and write them.
    public Contract saveContract(Contract contract) {
        StringBuilder input = new StringBuilder();

        try (BufferedWriter write = new BufferedWriter(new FileWriter(FILE_NAME, true))) {


            if (contract instanceof SalesContract sale) {
                Vehicle vehicle = sale.getVehicleSold();

                input.append("SALE|")
                        .append(sale.getContractDate()).append("|")
                        .append(sale.getName()).append("|")
                        .append(sale.getEmail()).append("|")
                        .append(vehicle.getVin()).append("|")
                        .append(vehicle.getYear()).append("|")
                        .append(vehicle.getMake()).append("|")
                        .append(vehicle.getModel()).append("|")
                        .append(vehicle.getVehicleType()).append("|")
                        .append(vehicle.getColor()).append("|")
                        .append(vehicle.getOdometer()).append("|")
                        .append(vehicle.getPrice()).append("|")
                        .append(sale.getSalesTaxAmount()).append("|")
                        .append(sale.getRecordingFee()).append("|")
                        .append(sale.getProcessingFee()).append("|")
                        .append(sale.getTotalPrice()).append("|")
                        .append(sale.isFinanceOption() ? "YES" : "NO").append("|")
                        .append(sale.getMonthlyPayment());

                write.append(input);
                // write: SALE|date|name|email|vehicle details|fees|finance|payment
            } else if (contract instanceof LeaseContract lease) {
          
                write.append(input);
            }

        } catch (IOException e) {
            System.err.println("Error writing code");
        }
        return contract;
    }
}
