package com.codewithishita.letsgrowmore_task1;

public class Model {
    private String name,death,cured,active,total,incAct,incDec,incRec;

    public Model(String name, String death, String cured,
                 String active, String total, String incAct, String incDec, String incRec)
    {
        this.name = name;
        this.death = death;
        this.cured = cured;
        this.active = active;
        this.total = total;
        this.incAct = incAct;
        this.incDec = incDec;
        this.incRec = incRec;
    }

    public String getIncDec()
    {
        return incDec;
    }

    public void setIncDec(String incDec)
    {
        this.incDec = incDec;
    }

    public String getIncAct()
    {
        return incAct;
    }

    public void setIncAct(String incAct)
    {
        this.incAct = incAct;
    }

    public String getIncRec()
    {
        return incRec;
    }

    public void setIncRec(String incRec)
    {
        this.incRec = incRec;
    }

    public String getTotal()
    {
        return total;
    }

    public void setTotal(String total)
    {
        this.total = total;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDeath()
    {
        return death;
    }

    public void setDeath(String death)
    {
        this.death = death;
    }

    public String getActive()
    {
        return active;
    }

    public void setActive(String active)
    {
        this.active = active;
    }

    public String getCured()
    {
        return cured;
    }

    public void setCured(String cured)
    {
        this.cured = cured;
    }

}

