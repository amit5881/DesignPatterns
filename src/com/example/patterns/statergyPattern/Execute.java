package com.example.patterns.statergyPattern;

import com.example.patterns.statergyPattern.behaviours.flyBehaviour.FlyBehaviour;
import com.example.patterns.statergyPattern.behaviours.walkBehaviour.WalkBehaviour;
import com.example.patterns.statergyPattern.constants.DuckBehaviourRegistry;
import com.example.patterns.statergyPattern.constants.DuckTypes;

import java.util.List;

public class Execute {

  public static void main(String[] args) {
    DuckTypes duckType = DuckTypes.WILD_DUCK;

    List<Object> behaviours = new DuckBehaviourRegistry().getDuckBehaviours(duckType);
    Object flyBehaviour = behaviours.get(0);
    Object walkBehaviour = behaviours.get(1);

    System.out.println("**** " + duckType + " ****");
    System.out.println(((FlyBehaviour) flyBehaviour).fly());
    System.out.println(((WalkBehaviour) walkBehaviour).walk());
  }
}
