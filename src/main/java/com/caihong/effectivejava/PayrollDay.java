package com.caihong.effectivejava;

public enum PayrollDay {
    MONDAY, SATURDAY(PayType.WEEKEND);
    private final PayType payType;

    PayrollDay() {
        this(PayType.WEEKDAY);
    }

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    private enum PayType {
        WEEKDAY {
            @Override
            int overtimePay(int minutesWorked, int payRate) {
                return minutesWorked <= MINUTES_PER_SHIFT ? 0 : (minutesWorked - MINUTES_PER_SHIFT) * payRate;
            }
        },
        WEEKEND {
            @Override
            int overtimePay(int minutesWorked, int payRate) {
                return minutesWorked * payRate * 2;
            }
        };

        private static final int MINUTES_PER_SHIFT = 8 * 60;

        abstract int overtimePay(int minutesWorked, int payRate);

        int pay(int minutesWorked, int payRate) {
            int basePay = MINUTES_PER_SHIFT * payRate;
            return basePay + overtimePay(minutesWorked, payRate);
        }
    }
}
