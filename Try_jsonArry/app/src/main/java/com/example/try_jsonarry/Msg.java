package com.example.try_jsonarry;

import java.util.List;

public class Msg {
    private Integer code;

    private String message;
    private List<Mdata> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Mdata> getData() {
        return data;
    }

    public void setData(List<Mdata> data) {
        this.data = data;
    }

    class Mdata {
        private long statusId;
        private long statusInstrumentId;
        private String statusRealTemp;
        private String statusSpinUserName;
        private String statusLockLevel;
        private String statusSpin;
        private String statusNLevel;
        private String statusHELevel;
        private String statusUploadTime;

        public long getStatusId() {
            return statusId;
        }

        public void setStatusId(long statusId) {
            this.statusId = statusId;
        }

        public long getStatusInstrumentId() {
            return statusInstrumentId;
        }

        public void setStatusInstrumentId(long statusInstrumentId) {
            this.statusInstrumentId = statusInstrumentId;
        }

        public String getStatusRealTemp() {
            return statusRealTemp;
        }

        public void setStatusRealTemp(String statusRealTemp) {
            this.statusRealTemp = statusRealTemp;
        }

        public String getStatusSpinUserName() {
            return statusSpinUserName;
        }

        public void setStatusSpinUserName(String statusSpinUserName) {
            this.statusSpinUserName = statusSpinUserName;
        }

        public String getStatusLockLevel() {
            return statusLockLevel;
        }

        public void setStatusLockLevel(String statusLockLevel) {
            this.statusLockLevel = statusLockLevel;
        }

        public String getStatusSpin() {
            return statusSpin;
        }

        public void setStatusSpin(String statusSpin) {
            this.statusSpin = statusSpin;
        }

        public String getStatusNLevel() {
            return statusNLevel;
        }

        public void setStatusNLevel(String statusNLevel) {
            this.statusNLevel = statusNLevel;
        }

        public String getStatusHELevel() {
            return statusHELevel;
        }

        public void setStatusHELevel(String statusHELevel) {
            this.statusHELevel = statusHELevel;
        }

        public String getStatusUploadTime() {
            return statusUploadTime;
        }

        public void setStatusUploadTime(String statusUploadTime) {
            this.statusUploadTime = statusUploadTime;
        }
    }
}
