package com.mycareer;

import java.util.Optional;

public abstract class BaseJob {
    public Manager getManager() {
        return manager;
    }

    public TechStack getTasks() {
        return techStack;
    }

    public Team getTeam() {
        return team;
    }

    public CareerPerspective getCareerPerspective() {
        return careerPerspective;
    }

    public boolean needsOvertimes() {
        return true;
    }

    public interface CareerPerspective {
        boolean isClear();
    }

    public interface Team {
        boolean isGreat();
    }

    public interface TechStack {
        boolean isBoring();
    }

    public interface Manager {
        boolean isBSIng();
        Optional<JobOffer> showOfferAndAskForRaise(final JobOffer offer);
    }

    public WorkConditions getConditions() {return null;}

    public boolean worthSecondChance() {return false;}

    private Manager manager;
    private TechStack techStack;
    private Team team;
    private CareerPerspective careerPerspective;
}
