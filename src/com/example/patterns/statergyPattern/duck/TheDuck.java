package com.example.patterns.statergyPattern.duck;

import com.example.patterns.statergyPattern.behaviours.flyBehaviour.FlyBehaviour;
import com.example.patterns.statergyPattern.behaviours.walkBehaviour.WalkBehaviour;

public class TheDuck implements Duck {

  FlyBehaviour flyBehaviour;

  WalkBehaviour walkBehaviour;

  public TheDuck(FlyBehaviour flyBehaviour, WalkBehaviour walkBehaviour) {
    this.flyBehaviour = flyBehaviour;
    this.walkBehaviour = walkBehaviour;
  }

  @Override
  public String walk() {
    return walkBehaviour.walk();
  }

  @Override
  public String fly() {
    return flyBehaviour.fly();
  }
}
