/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardodicaprio
 */
public class SupplierDirectory {
    
    private List<Supplier> supplierList;

    public SupplierDirectory() {
        supplierList = new ArrayList<Supplier>();
    }

    public List<Supplier> getSupplierlist() {
        return supplierList;
    }

    public Supplier addSupplier() {
        Supplier newSupplier = new Supplier();
        supplierList.add(newSupplier);
        return newSupplier;
    }

    public void removeSupplier(Supplier s) {
        supplierList.remove(s);
    }

    public Supplier searchSupplier(String supplierName) {
        for (Supplier supplier : supplierList) {
            if (supplier.getSupplyName().equals(supplierName)) {
                return supplier;
            }
        }
        return null;
    }
    
}
