package com.yangwang.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangwang
 * @date 2021-05-16-20:44
 */
public class Manage implements Serializable, Comparable<Manage> {

    public static final long serialVersionUID = 1L;

    public String id;

    public Integer times;

    public ArrayList<Event> events;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTimes() {
        if(events == null){
            return 0;
        }

        return events.size();
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    @Override
    public int compareTo(Manage o) {
//        if (o instanceof Person) {
//            Person p = (Person) o;
        return this.times.compareTo(o.times);
//        } else {
//            throw new RuntimeException("输入的数据不匹配");
//        }
    }



    @Override
    public String toString() {
        return "Manage{" +
                "id='" + id + '\'' +
                ", times=" + times +
                ", events=" + events +
                '}';
    }

    public Manage(){

    }

    public Manage(String id, ArrayList<Event> events) {
        this.id = id;
        this.events = events;
    }

    public Manage(String id, int times, ArrayList<Event> events) {
        this.id = id;
        this.times = times;
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manage manage = (Manage) o;

        if (times != manage.times) return false;
        if (id != null ? !id.equals(manage.id) : manage.id != null) return false;
        return events != null ? events.equals(manage.events) : manage.events == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + times;
        result = 31 * result + (events != null ? events.hashCode() : 0);
        return result;
    }
}
