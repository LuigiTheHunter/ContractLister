package eu.roggstar.contractlister;

import java.sql.Date;

class Contract {
    public String title,company,contNr,custNr;
    public Date resignDeadline,startDate,endDate;
    public Boolean active = true;
    public Integer index;

    public Contract(String title, String company, String contNr,String custNr,Date resignDeadline,Date startDate,Date endDate,Boolean active){
        this.title = title;
        this.company = company;
        this.contNr = contNr;
        this.custNr = custNr;
        this.resignDeadline = resignDeadline;
        this.startDate = startDate;
        this.endDate = endDate;
        if(!active) {
            this.active = active;
        }
    }
}
