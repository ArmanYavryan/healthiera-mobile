package com.healthiera.mobile.serivce;

import com.activeandroid.query.Select;
import com.healthiera.mobile.entity.Goal;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Yengibar Manasyan
 * @date 10/18/16
 */
public class GoalService {

    public Long createGoal(Goal goal) {
        assertThat(goal).isNotNull();
        assertThat(goal.getId()).isNull();
        assertThat(goal.getName()).isNotNull().isNotEmpty();
        assertThat(goal.getValue()).isNotNull().isNotEmpty();
        final Long id = goal.save();
        assertThat(id).isNotNull().isGreaterThan(0L);

        return id;
    }

    public List<Goal> getAllGoals() {
        final List<Goal> goals = new Select()
                .from(Goal.class)
                .execute();
        assertThat(goals).isNotNull();

        return goals;
    }
}
