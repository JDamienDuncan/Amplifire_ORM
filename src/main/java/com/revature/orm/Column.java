package com.revature.orm;

import java.lang.reflect.Method;

// Attempting to use 

public class Column{

	private final String name;
    private final Method getter;
    private final Method setter;
   

    public Column(String name) {
        this.name = name;
        this.getter = null;
        this.setter = null;
        
    }

    public Column(String name, Method getter, Method setter) {
        assert name != null;
        assert getter != null;
        assert setter != null;

        this.name = name;
        this.getter = getter;
        this.setter = setter;
        
    }

    public String getName() { return name; }
    public Method getGetter() { return getter; }
    public Method getSetter() { return setter; }
    

    @Override
    public int hashCode() { return name.hashCode() ^ getter.hashCode() ^ setter.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Column)) return false;
        Column col = (Column) o;
        return this.name.equals(col.getName()) &&
                this.getter.equals(col.getGetter()) &&
                this.setter.equals(col.getSetter());
    }

}