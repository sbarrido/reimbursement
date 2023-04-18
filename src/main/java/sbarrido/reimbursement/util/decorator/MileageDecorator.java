package sbarrido.reimbursement.util.decorator;

import sbarrido.reimbursement.model.expense.Mileage;

public abstract class MileageDecorator extends Mileage {
    Mileage mileage;
    public abstract int getTotal();
}
