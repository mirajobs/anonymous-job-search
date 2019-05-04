package com.mycareer;

public abstract class Invite {
    public abstract WorkConditions getConditions();

    public abstract Interview accept();
    public abstract void reject();
}
