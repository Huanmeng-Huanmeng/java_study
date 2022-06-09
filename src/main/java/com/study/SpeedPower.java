package com.study;

public class SpeedPower {
    private float winds;
    private float power;
    private float activePowerSPPctTotal;

    public SpeedPower(float winds) {
        this.winds = winds;
    }

    public float getWinds() {
        return winds;
    }

    public void setWinds(float winds) {
        this.winds = winds;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public float getActivePowerSPPctTotal() {
        return activePowerSPPctTotal;
    }

    public void setActivePowerSPPctTotal(float activePowerSPPctTotal) {
        this.activePowerSPPctTotal = activePowerSPPctTotal;
    }

    @Override
    public String toString() {
        return "SpeedPower{" +
                "winds=" + winds +
                ", power=" + power +
                ", activePowerSPPctTotal=" + activePowerSPPctTotal +
                '}';
    }
}
