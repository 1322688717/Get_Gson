package com.example.try_jsonarry;

public class Bean {

    String status,lang,unit,timezone;

    public Bean(String status, String lang, String unit, String timezone) {
        this.status = status;
        this.lang = lang;
        this.unit = unit;
        this.timezone = timezone;
    }

    public Bean() {
    }

    @Override
    public String toString() {
        return "Bean{" +
                "status='" + status + '\'' +
                ", lang='" + lang + '\'' +
                ", unit='" + unit + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
