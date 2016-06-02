package com.enity;

/**
 * Created by Administrator on 2016/5/25.
 */
public class beaninfo {


    /**
     * status : 0
     * msg : ok
     * result : {"year":"2016","month":"04","day":"02","week":"六","lunaryear":"2016","lunarmonth":"二月","lunarday":"廿五","ganzhi":"丙申","shengxiao":"猴","workholiday":"1","star":"白羊座","huangli":{"nongli":"农历二〇一六年二月廿五","taishen":"占门炉外东北","wuxing":"大溪水","chong":"冲（戊申）猴","sha":"煞北","jiri":"青龙（黄道）闭日","zhiri":"青龙（黄道吉日）","xiongshen":"游祸 血支 归忌 八专","jishenyiqu":"月德 王日 五富 普护 五合 青龙 鸣犬对","caishen":"东北","xishen":"东北","fushen":"东南","suici":["丙申年","辛卯月","甲寅日"],"yi":["裁衣","经络","伐木","开柱眼","拆卸","修造","动土","上梁","合脊","合寿木","入殓","除服","成服","移柩","破土","安葬","启攒","修坟","立碑"],"ji":["祭祀","嫁娶","出行","上梁","掘井"]}}
     */

    private String status;
    private String msg;
    /**
     * year : 2016
     * month : 04
     * day : 02
     * week : 六
     * lunaryear : 2016
     * lunarmonth : 二月
     * lunarday : 廿五
     * ganzhi : 丙申
     * shengxiao : 猴
     * workholiday : 1
     * star : 白羊座
     * huangli : {"nongli":"农历二〇一六年二月廿五","taishen":"占门炉外东北","wuxing":"大溪水","chong":"冲（戊申）猴","sha":"煞北","jiri":"青龙（黄道）闭日","zhiri":"青龙（黄道吉日）","xiongshen":"游祸 血支 归忌 八专","jishenyiqu":"月德 王日 五富 普护 五合 青龙 鸣犬对","caishen":"东北","xishen":"东北","fushen":"东南","suici":["丙申年","辛卯月","甲寅日"],"yi":["裁衣","经络","伐木","开柱眼","拆卸","修造","动土","上梁","合脊","合寿木","入殓","除服","成服","移柩","破土","安葬","启攒","修坟","立碑"],"ji":["祭祀","嫁娶","出行","上梁","掘井"]}
     */

    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private String year;
        private String month;
        private String day;
        private String week;
        private String lunaryear;
        private String lunarmonth;
        private String lunarday;
        private String ganzhi;
        private String shengxiao;
        private String workholiday;
        private String star;

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getLunaryear() {
            return lunaryear;
        }

        public void setLunaryear(String lunaryear) {
            this.lunaryear = lunaryear;
        }

        public String getLunarmonth() {
            return lunarmonth;
        }

        public void setLunarmonth(String lunarmonth) {
            this.lunarmonth = lunarmonth;
        }

        public String getLunarday() {
            return lunarday;
        }

        public void setLunarday(String lunarday) {
            this.lunarday = lunarday;
        }

        public String getGanzhi() {
            return ganzhi;
        }

        public void setGanzhi(String ganzhi) {
            this.ganzhi = ganzhi;
        }

        public String getShengxiao() {
            return shengxiao;
        }

        public void setShengxiao(String shengxiao) {
            this.shengxiao = shengxiao;
        }

        public String getWorkholiday() {
            return workholiday;
        }

        public void setWorkholiday(String workholiday) {
            this.workholiday = workholiday;
        }

        public String getStar() {
            return star;
        }

        public void setStar(String star) {
            this.star = star;
        }
    }
}
