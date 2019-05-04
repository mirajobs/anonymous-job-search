package com.mycareer;

import java.util.Optional;

public class Career {
    private Person me;

    public class Job extends BaseJob {
        public boolean isMyDreamJob() {
            return getManager().isBSIng() // "it's just a small change..."
                    || !getTeam().isGreat()  // 25 devs, everyone "owns" everything
                    || !getCareerPerspective().isClear() // no promotion this year, sorry
                    || getTasks().isBoring() // legacy code, no docs, no tests
                    || needsOvertimes(); // "What do you mean it’s not ready?"
        }
    }

    public void careerLoop(final Job currentJob) {
        if (!currentJob.isMyDreamJob()) {
            final ConfidentialProfile profile = AnonymousJobSearch.ProfileBuilder()
                    .withSkills(me.getSkills())
                    .withExperience(me.getExperience())
                    .withExpectations(me.getNewJobExpectations())
                    .withPlatform("https://mirajobs.com")
                    .build();

            profile.onCompanyInvitation(invite -> { // Employers apply to you,
                if (invite.getConditions().compareTo(currentJob.getConditions()) > 0) {
                    final Interview interview = invite.accept(); // reveal your identity

                    final Optional<JobOffer> offer = interview.attendIfInterested();

                    if (!offer.isPresent()) { return; } // not today..

                    if (currentJob.worthSecondChance()) {
                        final Optional<JobOffer> counterOffer = currentJob.getManager()
                                .showOfferAndAskForRaise(offer.get());

                        if (counterOffer.isPresent()) {
                            me.celebrate("Pay Bump!");
                            return;
                        }
                    }

                    final Job newJob = offer.get().accept();
                    me.celebrate("New Job!");
                    careerLoop(newJob); // any chances for a stack overflow? :)
                } else {
                    invite.reject(); // anonymously refuse
                }
            });
        }

        me.relax(); // and keep performing on the current job whatsoever
    }
}
//TODO: Add a unit test and verify that Person.celebrate() is called `times(1)` :)
