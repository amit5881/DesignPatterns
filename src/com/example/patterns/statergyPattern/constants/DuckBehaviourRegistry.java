package com.example.patterns.statergyPattern.constants;

import static com.example.patterns.statergyPattern.constants.DuckTypes.CITY_DUCK;
import static com.example.patterns.statergyPattern.constants.DuckTypes.CLOUD_DUCK;
import static com.example.patterns.statergyPattern.constants.DuckTypes.MOUNTAIN_DUCK;
import static com.example.patterns.statergyPattern.constants.DuckTypes.WILD_DUCK;

import com.example.patterns.statergyPattern.behaviours.flyBehaviour.FlyingHigh;
import com.example.patterns.statergyPattern.behaviours.flyBehaviour.FlyingLow;
import com.example.patterns.statergyPattern.behaviours.flyBehaviour.WildFlying;
import com.example.patterns.statergyPattern.behaviours.walkBehaviour.NoWalk;
import com.example.patterns.statergyPattern.behaviours.walkBehaviour.WalkingFast;
import com.example.patterns.statergyPattern.behaviours.walkBehaviour.WalkingSlow;
import java.util.List;
import java.util.Map;

public class DuckBehaviourRegistry {
  public List<Object> getDuckBehaviours(DuckTypes duck) {
    return Map.of(
        WILD_DUCK, List.of(new WildFlying(), new WalkingFast()),
        CITY_DUCK, List.of(new FlyingLow(), new WalkingSlow()),
        MOUNTAIN_DUCK, List.of(new FlyingHigh(), new NoWalk()),
        CLOUD_DUCK, List.of(new FlyingHigh(), new NoWalk())
    ).get(duck);
  }
}
