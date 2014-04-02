package com.example.CriminalIntent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Daniel on 4/1/14.
 * CrimeLab will be a singleton (a class that will only have one instance)
 */
public class CrimeLab {
    private ArrayList<Crime> mCrime;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    // This constructor is private so that only the class can call it as needed.
    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrime = new ArrayList<Crime>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            mCrime.add(crime);
        }
    }

    // This static method is the only way to call the constructor and it is only called if there is no instance of
    // the class already, if there is then it will just return the instance created.
    public static CrimeLab get(Context c) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrime;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrime) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}
